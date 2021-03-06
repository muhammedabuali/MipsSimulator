package eg.edu.guc.mips;

import eg.edu.guc.memory.Memory;
import eg.edu.guc.registers.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JTextArea;

import eg.edu.guc.utils.ALUControl;
import eg.edu.guc.utils.Utilities;

public class Mips {
    private ArrayList<String> instructions;
    private ArrayList<String[]> parsedInstrutions;

    public Mips() {

    }

    public Mips(String path) {
        try {
            readProgram(new File(path));
            run();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Mips(JTextArea codeArea) {
        instructions = new ArrayList<String>();
        String[] lines = codeArea.getText().split("\n");
        for (String inst : lines)
            instructions.add(inst);
        parsedInstrutions = Parser.parseInstructions(instructions);
        run();
    }

    public void runText(JTextArea codeArea) {
        instructions = new ArrayList<String>();
        String[] lines = codeArea.getText().split("\n");
        for (String inst : lines)
            instructions.add(inst);
        parsedInstrutions = Parser.parseInstructions(instructions);
        run();
    }

    /**
     * Reading a file containing a mips instructions
     *
     * @throws IOException
     */

    public void decode() {

        int instruction = IFIDRegister.getInstruction();

        IDEXRegister.setPc(IFIDRegister.getPc());// store 32 bit incremented PC
        Register register1 = Utilities.getRegisterByNumber(Utilities.getSubset(
                IFIDRegister.getInstruction(), 21, 25));
        IDEXRegister.setRegisterOneValue(register1.getData());// store register
        // 1 data

        Register register2 = Utilities.getRegisterByNumber(Utilities.getSubset(
                IFIDRegister.getInstruction(), 16, 20));
        IDEXRegister.setRegisterTwoValue(register2.getData());// store register
        // 2 data

        Register register3 = Utilities.getRegisterByNumber(Utilities.getSubset(
                IFIDRegister.getInstruction(), 11, 15));

        int offset = Utilities.getSubset(IFIDRegister.getInstruction(), 0, 15);
        if (Integer.toBinaryString(offset).length() == 16)
            offset |= 0xffff0000;
        IDEXRegister.setOffset(offset);// store offset
        System.out.println(offset);
        int rt = register2.getNumber();
        IDEXRegister.setRt((byte) rt);

        int rd = register3.getNumber();
        IDEXRegister.setRd((byte) rd);

        int opcode = Utilities.getSubset(instruction, 26, 31) << 26;

        if (opcode == 0) {
            // R format Instruction need to get function code
            int functioncode = instruction & ((1 << 6) - 1); // anding with mask
            opcode |= functioncode;
        }

        String operation = Utilities.getInstructionNameByOpcode(opcode);

		/*
         * ALU src : whether the ALU should take input from registers (false)or
		 * sign extended input)
		 */
        switch (operation) {
            // arithmatic
            case "add":
                setControSignals(false, true, 0b10, false, false, false, false,
                        false, false, false, true, false);
                break;

            case "sub":
                setControSignals(false, true, 0b10, false, false, false, false,
                        false, false, false, true, false);
                break;

            case "addi":
                setControSignals(true, false, 0b00, false, false, false, false,
                        false, false, false, true, false);
                break;
            // loading from memory
            case "lw":
                setControSignals(true, false, 0b00, true, false, false, false,
                        true, true, false, false, false);
                break;

            case "lb":
                setControSignals(true, true, 0b00, false, false, false, false,
                        false, false, false, true, false);
                break;

            case "lbu":
                setControSignals(true, true, 0b00, false, false, false, false,
                        false, false, false, true, true);
                break;

            case "sw":
                setControSignals(true, false, 0b00, false, true, false, false,
                        false, false, false, false, false);
                break;

            case "sb":
                setControSignals(true, false, 0b00, false, true, false, false,
                        false, false, false, true, false);
                break;

            case "lui":// needs to be redone
                setControSignals(true, true, 0b00, false, false, false, false,
                        false, false, false, true, true);
                break;

            // logic
            case "sll":// same as addi diffrence is in funct
                setControSignals(true, true, 0b10, false, false, false, false,
                        false, false, false, false, false);
                break;

            case "srl":// same as addi diffrence is in funct
                setControSignals(true, true, 0b10, false, false, false, false,
                        false, false, false, false, false);
                break;

            case "and":// same as add,sub diffrence is in funct
                setControSignals(false, true, 0b10, false, false, false, false,
                        false, false, false, true, false);
                break;

            case "nor":// same as add,sub diffrence is in funct
                setControSignals(false, true, 0b10, false, false, false, false,
                        false, false, false, true, false);
                break;

            // branching
            case "beq":// same as add,sub diffrence is in funct
                setControSignals(false, false, 0b10, false, false, true, false,
                        false, false, false, false, false);
                break;

            case "bne":// same as add,sub diffrence is in funct
                setControSignals(false, false, 0b10, false, false, true, false,
                        false, false, true, false, false);
                break;
            // jumping
            case "j":// 0b11 im aluop converts 26bit address to 32bit address
                setControSignals(false, false, 0b11, false, false, true, false,
                        false, false, false, false, false);
                break;

            case "jal":// added new
                setControSignals(false, false, 0b11, false, false, true, false,
                        false, false, false, false, false);
                IDEXRegister.setLink(true);
                break;

            case "jr":// same as add,sub diffrence is in funct
                setControSignals(false, false, 0b11, false, false, true, true,
                        false, false, false, false, false);
                break;

            case "slt":// same as add,sub diffrence is in funct
                setControSignals(false, true, 0b10, false, false, false, false,
                        false, false, false, true, false);
                break;
            case "sltu":// same as add,sub diffrence is in funct
                setControSignals(false, true, 0b10, false, false, false, false,
                        false, true, false, true, false);
                break;
        }

        // sending jump address to EXMEMRegister
        IDEXRegister.setJumpAddress(Utilities.getSubset(instruction, 0, 25));

    }

    /*
     * added new MEM signal memByte to be used with lw , lb , lbu , sw added new
     * MEM signal unsigned to be used with lw , lb , lbu , sw added new MEM
     * signal "compOne" to use with beq , bne added new EX signal "jump" to b
     * diffrenciate between jump and branch 00 beq bne ,01 j ,10 Jal ,11 jar
     */
    public void setControSignals(boolean ALUSrc, boolean regDst, int AlUop,
                                 boolean memRead, boolean memWrite, boolean branch, boolean jump,
                                 boolean memByte, boolean unsigned, boolean compOne,
                                 boolean regWrite, boolean memToReg) {

        IDEXRegister.setAluSrc(ALUSrc);
        IDEXRegister.setRegDest(regDst);
        IDEXRegister.setAluOp(AlUop);
        IDEXRegister.setMemRead(memRead);
        IDEXRegister.setMemWrite(memWrite);
        IDEXRegister.setBranch(branch);
        IDEXRegister.setJump(jump);
        IDEXRegister.setMemByte(memByte);
        IDEXRegister.setUnsigned(unsigned);
        IDEXRegister.setCompOne(compOne);
        IDEXRegister.setRegWrite(regWrite);
        IDEXRegister.setMemToReg(memToReg);
        IDEXRegister.setLink(false);
    }

    private void readProgram(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        instructions = new ArrayList<String>();
        String line;
        while ((line = reader.readLine()) != null)
            instructions.add(line);
        reader.close();
        parsedInstrutions = Parser.parseInstructions(instructions);
    }

    /**
     * Fetching an instruction from the loaded instructions
     */
    public int fetch() {
        int instruction;
        try {
            instruction = getInstructionBitStream(parsedInstrutions
                    .get(Components.getPC()));
        } catch (IndexOutOfBoundsException e) {
            instruction = 0;
        }

        IFIDRegister.setInstruction(instruction);
        IFIDRegister.setPc(Components.incrementPC());

        return instruction;
    }

    /**
     * Converting an instruction to equivalent bits
     *
     * @return
     */
    public int getInstructionBitStream(String[] instruction) {
        if(instruction[0].equals("NOP"))return 0;
        String[] instructionData = Utilities
                .getInstructionDataByName(instruction[0].toString());

        String instName = instructionData[0];
        String instType = instructionData[1];
        String instOpCode = instructionData[2];
        String instFunCode = instructionData[3];

        if (instType.equals("R")) {
            return getRInstructionBitStream(instName, instOpCode, instFunCode,
                    instruction[1].toString(), instruction[2].toString(),
                    instruction[3].toString());
        } else if (instType.equals("I")) {
            return getIInstructionBitStream(instName, instOpCode,
                    instruction[1].toString(), instruction[2].toString(),
                    instruction.length == 4 ? instruction[3].toString() : "");
        } else if (instType.equals("J")) {
            return getJInstructionBitStream(instName, instOpCode,
                    instruction[1].toString());
        }

        return -1;
    }

    /**
     * retruns Integer that represents the given R Type Instruction
     * <p/>
     * <p/>
     * [B31-26, B25-21, B20-16, B15-11, B10-6, B5-0]
     * <p/>
     * [opcode, register s, register t, register d, shift amount, function]
     */
    private int getRInstructionBitStream(String instName, String instOpCode,
                                         String instFunctionCode, String destReg, String srcReg,
                                         String targetReg) {
        int opCode = Integer.parseInt(instOpCode, 16);
        int funCode = Integer.parseInt(instFunctionCode, 16);
        int destRegNum = Utilities.getRegisterByName(destReg).getNumber();
        int srcRegNum = Utilities.getRegisterByName(srcReg).getNumber();
        int targetRegNum = 0;
        int shiftamount = 0;
        if (targetReg.charAt(0) == '$') {
            targetRegNum = Utilities.getRegisterByName(targetReg).getNumber();
        } else {
            shiftamount = Integer.parseInt(targetReg, 16);
        }
        return (opCode << 26) | (srcRegNum << 21) | (targetRegNum << 16)
                | (destRegNum << 11) | (shiftamount << 6) | (funCode);
    }

    /**
     * retruns Integer that represents the given I Type Instruction
     * <p/>
     * [B31-26, B25-21, B20-16, B15-0]
     * <p/>
     * [opcode, register s, register t, immediate]
     */
    private int getIInstructionBitStream(String instName, String instOpCode,
                                         String targetReg, String srcReg, String immediate) {
        int opCode = Integer.parseInt(instOpCode, 16);
        int targetRegNum = Utilities.getRegisterByName(targetReg).getNumber();
        int srcRegNum = 0;
        int constant = 0;
        if (immediate.length() > 0) {
            srcRegNum = Utilities.getRegisterByName(srcReg).getNumber();
            constant = Integer.parseInt(immediate);
        } else {
            // lw or sw or lb or sb
            constant = Integer
                    .parseInt(srcReg.substring(0, srcReg.indexOf('(')));
            srcReg = srcReg.substring(srcReg.indexOf("(") + 1,
                    srcReg.indexOf(")"));
            srcRegNum = Integer.parseInt(srcReg);
        }
        return (opCode << 26) | (srcRegNum << 21) | (targetRegNum << 16)
                | (constant & 0x0000ffff);
    }

    /**
     * perform the IDEX STAGE and write all values to the Register EXMEM
     */
    public void execute() {
        // WB controls
        EXMEMRegister.setMemToReg(IDEXRegister.isMemToReg());
        EXMEMRegister.setRegWrite(IDEXRegister.isRegWrite());

        // Mem controls
        EXMEMRegister.setMemWrite(IDEXRegister.isMemWrite());
        EXMEMRegister.setMemRead(IDEXRegister.isMemRead());
        EXMEMRegister.setLink(IDEXRegister.isLink());

        // AluOp
        int functionField = IDEXRegister.getOffset() & 63;// extract last 6 bits
        int aluControlOutput = ALUControl.generateAluop(
                IDEXRegister.getAluOp(), functionField);
        int AluSecondInput = (!IDEXRegister.isAluSrc() ? IDEXRegister
                .getRegisterTwoValue() : IDEXRegister.getOffset());
        int aluOutput = ALUControl.perform(IDEXRegister.getRegisterOneValue(),
                AluSecondInput, aluControlOutput);
        EXMEMRegister.setAluOut(aluOutput);
        EXMEMRegister.setZeroFlag(aluOutput == 0 ? true : false);

        // branch address
        int shifted = IDEXRegister.getOffset() << 2;
        int added = shifted + IDEXRegister.getPc();
        EXMEMRegister.setBranchAddress(added);

        // rd
        byte rd = !IDEXRegister.isRegDest() ? IDEXRegister.getRt()
                : IDEXRegister.getRd();// need to be reviewed
        EXMEMRegister.setRd(rd);

        // register value to mem
        EXMEMRegister.setMemoryWriteValue(IDEXRegister.getRegisterTwoValue());

        // membyte unsigned compOne jump branch
        EXMEMRegister.setMemByte(IDEXRegister.isMemByte());
        EXMEMRegister.setUnsigned(IDEXRegister.isUnsigned());
        EXMEMRegister.setCompOne(IDEXRegister.isCompOne());
        EXMEMRegister.setJump(IDEXRegister.isJump());
        EXMEMRegister.setBranch(IDEXRegister.isBranch());

        // adding jumpAddress
        int leftFourBitsPC = IFIDRegister.getPc() & 0xf0000000;
        int addressJump = IDEXRegister.getJumpAddress();
        EXMEMRegister.setJumpAddress(leftFourBitsPC | addressJump);

        // adding the register address in case of jr
        EXMEMRegister.setJrRegisterAddress(IDEXRegister.getRegisterOneValue());
    }

    public void memory() {

        // WB controls
        MEMWBRegister.setMemToReg(EXMEMRegister.isMemToReg());
        MEMWBRegister.setRegWrite(EXMEMRegister.isRegWrite());

        // ALUOut
        MEMWBRegister.setAluOut(EXMEMRegister.getAluOut());

        // REGISTER Address
        MEMWBRegister.setRd(EXMEMRegister.getRd());

        // READING
        if (EXMEMRegister.isMemRead()) {
            if (EXMEMRegister.isMemByte()) {
                if (EXMEMRegister.isUnsigned()) {
                    // lbu
                    MEMWBRegister.setMemoryRead(Memory
                            .loadByteUnsigned(EXMEMRegister.getAluOut()));
                } else {
                    // lb
                    MEMWBRegister.setMemoryRead(Memory.loadByte(EXMEMRegister
                            .getAluOut()));
                }
            } else {
                // lw
                MEMWBRegister.setMemoryRead(Memory.loadWord(EXMEMRegister
                        .getAluOut()));
            }

        } else if (EXMEMRegister.isMemWrite()) {
            if (EXMEMRegister.isMemByte())
                // sb
                Memory.storeByte((byte) EXMEMRegister.getMemoryWriteValue(),
                        EXMEMRegister.getAluOut());
            else
                // sw
                Memory.storeWord(EXMEMRegister.getMemoryWriteValue(),
                        EXMEMRegister.getAluOut());
        }
        if (EXMEMRegister.isJump()) {
            if (EXMEMRegister.isBranch()) {
                // j , jal
                if (EXMEMRegister.isLink())
                    RegisterFile.RA_REGISTER.setData(Components.getPC());
                Components.setPC(EXMEMRegister.getJumpAddress());
            } else {
                // jr
                Components.setPC(EXMEMRegister.getJrRegisterOneValueAddress());
            }
        } else {
            // beq and bne
            if (EXMEMRegister.isBranch()) {

                if ((!EXMEMRegister.isCompOne() && EXMEMRegister.isZeroFlag())
                        || (EXMEMRegister.isCompOne() && !EXMEMRegister
                        .isZeroFlag()))
                    Components.setPC(EXMEMRegister.getBranchAddress());

            }
        }

    }

    public void writeBack() {
        if (MEMWBRegister.isRegWrite()) {
            if (MEMWBRegister.isMemToReg()) {
                Utilities.getRegisterByNumber(MEMWBRegister.getRd()).setData(
                        MEMWBRegister.getMemoryRead());
            } else {
                Utilities.getRegisterByNumber(MEMWBRegister.getRd()).setData(
                        MEMWBRegister.getAluOut());
            }
        }
    }

    /**
     * retruns Integer that represents the given J Type Instruction
     * <p/>
     * [B31-26, B25-0]
     * <p/>
     * [opcode, target]
     */
    private int getJInstructionBitStream(String instName, String instOpCode,
                                         String target) {
        int opCode = Integer.parseInt(instOpCode, 16);
        int constant = Utilities.getLabelNumber(target);
        return (opCode << 26) | (constant);
    }

    public void advance() {
        writeBack();
        memory();
        execute();
        decode();
        fetch();
    }

    public void run() {
        while (Components.getPC() < parsedInstrutions.size() + 4) {
            advance();
        }
    }

}
