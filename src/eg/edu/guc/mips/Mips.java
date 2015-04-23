package eg.edu.guc.mips;


import eg.edu.guc.registers.IDEXRegister;
import eg.edu.guc.registers.IFIDRegister;
import eg.edu.guc.registers.MEMWBRegister;

import java.io.*;

public class Mips {
    private String[] instructions;


    /**
     * Reading a file containing a mips instructions
     *
     * @param file
     * @throws IOException
     */
    private void readProgram(File file) throws IOException {
        int line = 0;
        BufferedReader reader = new BufferedReader(new FileReader(file));

        while ((instructions[line] = reader.readLine()) != null) {
            line++;
        }
    }

    /**
     * Fetching an instruction from the loaded instructions
     */
    public int fetch() {
        IDEXRegister.setPc(IFIDRegister.getPc());
        int instruction = getInstructionBitStream(instructions[Components.getPC()]);


        IFIDRegister.setInstruction(instruction);
        IFIDRegister.setPc(Components.incrementPC());

        return instruction;
    }

    public void decode() {

        int instruction = IFIDRegister.getInstruction();

        IDEXRegister.setPc(IFIDRegister.getPc());

        IFIDRegister.setInstruction(instruction);
        IFIDRegister.setPc(Components.incrementPC());

        String opearation = "";
        String controlSignalString = "";//RegDst-RegWrite--ALUOp-MemWrite-MemRead-MemToReg
        /*
        ALU src : whether the ALu should take input from registers (false)or sign extended input)

         */
        switch (opearation) {
            case "add":
                setControSignals(false,true,0b10,false,false,false,false,false);
                break;

            case "sub":
                setControSignals(false,true,0b10,false,false,false,false,false);
                break;

            case "addi":
                setControSignals(true,true,0b00,false,false,false,false,false);
                break;

            case "lw":
                setControSignals(true,false,0b00,true,false,false,true,true);
                break;

            case "sw":
                setControSignals(true,false,0b00,false,true,false,false,false);
                break;

            case "lb":
                setControSignals(true,true,0b00,false,false,false,false,false);
                break;
        }

    }
    public void setControSignals(boolean ALUSrc, boolean RegDst, int AlUop,
                                 boolean MemRead, boolean MemWrite, boolean branch,
                                 boolean RegWrite, boolean MemToReg) {


    }

    /**
     * Converting an instruction to equivalent bits
     *
     * @param instruction
     * @return
     */
    private int getInstructionBitStream(String instruction) {
        //TODO Convert instruction to the appropriate bitstream
        return -1;
    }

}
