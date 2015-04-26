package eg.edu.guc.tests;

import static org.junit.Assert.*;

import eg.edu.guc.registers.*;
import org.junit.Test;

import eg.edu.guc.mips.Mips;
import eg.edu.guc.mips.Parser;
import eg.edu.guc.utils.Utilities;

public class MipsTests {

    @Test
    public void testGetRInstructionBitStream() {
        Mips m = new Mips();

        int instCode = m.getInstructionBitStream(Parser.parseInstruction(
                "add $t1, $t2, $t3", 1));
        assertTrue(
                "The code for the instruction should be 0x014b4820 as found in mars",
                Integer.toHexString(instCode).equals("14b4820"));
    }

    @Test
    public void testGetIInstructionBitStream() {
        Mips m = new Mips();

        int instCode = m.getInstructionBitStream(Parser.parseInstruction(
                "addi $t1, $t2, 11", 1));
        assertTrue(
                "The code for the instruction should be 0x2149000b as found in mars",
                Integer.toHexString(instCode).equals("2149000b"));
    }

    @Test
    public void testGetInstructionNameByOpcodePart() {
        int instruction = Integer.parseInt("2149000b", 16);
        int opcode = (instruction >> 26) << 26;

        if (opcode == 0) {
            // R format Instruction need to get function code
            int functioncode = instruction & ((1 << 6) - 1); // anding with mask
            opcode |= functioncode;
        }

        String instructionName = Utilities.getInstructionNameByOpcode(opcode);
        assertTrue("The instruction should be addi",
                instructionName.equals("addi"));

    }

    @Test
    public void testAddInstructionDecode() {
        //add t0 t1 t2
        Mips m = new Mips();

        RegisterFile.T1_REGISTER.setData(2);
        RegisterFile.T2_REGISTER.setData(3);

        int instCode = m.getInstructionBitStream(Parser.parseInstruction(
                "add $t0, $t1, $t2", 1));
        IFIDRegister.setInstruction(instCode);
        IDEXRegister.setPc(0);

        int instruction = Integer.parseInt("000000" + "01001" + "01010" + "01000" + "00000" + "100000", 2);
        assertTrue("instruction bits should be  000000 01001 01010 01000 00000 100000", IFIDRegister.getInstruction() == instruction);

        m.decode();
        assertTrue("funct should be 100000", Utilities.getSubset(IDEXRegister.getOffset(), 0, 5) == 0b100000);
        assertTrue("rt should be $t2", Utilities.getRegisterByNumber(IDEXRegister.getRt()) == RegisterFile.T2_REGISTER);
        assertTrue("rd should be $t0", Utilities.getRegisterByNumber(IDEXRegister.getRd()).equals(RegisterFile.T0_REGISTER));

        m.execute();

        m.memory();

        m.writeBack();

        assertTrue("t0 should be 5", RegisterFile.T0_REGISTER.getData() == 5);
    }

    @Test
    public void testSubInstructionDecode() {
        //add t0 t1 t2
        Mips m = new Mips();

        RegisterFile.T1_REGISTER.setData(3);
        RegisterFile.T2_REGISTER.setData(2);

        int instCode = m.getInstructionBitStream(Parser.parseInstruction(
                "sub $t0, $t1, $t2", 1));
        IFIDRegister.setInstruction(instCode);
        IDEXRegister.setPc(0);

        int instruction = Integer.parseInt("000000" + "01001" + "01010" + "01000" + "00000" + "100010", 2);
        assertTrue("instruction bits should be  000000 01001 01010 01000 00000 100000", IFIDRegister.getInstruction() == instruction);

        m.decode();
        assertTrue("funct should be 100010", Utilities.getSubset(IDEXRegister.getOffset(), 0, 5) == 0b100010);
        assertTrue("rt should be $t2", Utilities.getRegisterByNumber(IDEXRegister.getRt()) == RegisterFile.T2_REGISTER);
        assertTrue("rd should be $t0", Utilities.getRegisterByNumber(IDEXRegister.getRd()).equals(RegisterFile.T0_REGISTER));

        m.execute();

        m.memory();

        m.writeBack();
        assertTrue("t0 should be 1", RegisterFile.T0_REGISTER.getData() == 1);
    }
    @Test
    public void testAddIInstructionDecode() {
        //add t0 t1 t2
        Mips m = new Mips();

        RegisterFile.T1_REGISTER.setData(3);

        int instCode = m.getInstructionBitStream(Parser.parseInstruction(
                "addi $t1, $t1, 7", 1));
        IFIDRegister.setInstruction(instCode);
        IDEXRegister.setPc(1);

        /*int instruction = Integer.parseInt("000000" + "01001" + "01010" + "01000" + "00000" + "100010", 2);
        assertTrue("instruction bits should be  000000 01001 01010 01000 00000 100000", IFIDRegister.getInstruction() == instruction);

        assertTrue("funct should be 100010", Utilities.getSubset(IDEXRegister.getOffset(), 0, 5) == 0b100010);
        assertTrue("rt should be $t2", Utilities.getRegisterByNumber(IDEXRegister.getRt()) == RegisterFile.T2_REGISTER);
        assertTrue("rd should be $t0", Utilities.getRegisterByNumber(IDEXRegister.getRd()).equals(RegisterFile.T0_REGISTER));
        */
        m.decode();

        m.execute();

        m.memory();
        m.writeBack();

        assertTrue("t1 should be 10", RegisterFile.T1_REGISTER.getData() == 10);
    }
    @Test
    public void testAndInstructionDecode() {
        //add t0 t1 t2
        Mips m = new Mips();

        RegisterFile.T1_REGISTER.setData(3);
        RegisterFile.T2_REGISTER.setData(7);


        int instCode = m.getInstructionBitStream(Parser.parseInstruction(
                "and $t0, $t1, $t2", 1));
        IFIDRegister.setInstruction(instCode);
        IDEXRegister.setPc(1);

        m.decode();

        m.execute();

        m.memory();

        m.writeBack();

        assertTrue("t0 should be 2", RegisterFile.T0_REGISTER.getData() == 3);
    }
    @Test
    public void testNorInstructionDecode() {
        //add t0 t1 t2
        Mips m = new Mips();

        RegisterFile.T1_REGISTER.setData(2);
        RegisterFile.T2_REGISTER.setData(7);

        int instCode = m.getInstructionBitStream(Parser.parseInstruction(
                "nor $t0, $t1, $t2", 1));
        IFIDRegister.setInstruction(instCode);
        IDEXRegister.setPc(1);

        m.decode();

        m.execute();

        m.memory();

        m.writeBack();

        assertTrue("t0 should be -8", RegisterFile.T0_REGISTER.getData() == -8);
    }
    @Test
    public void testSltInstructionDecode() {
        //add t0 t1 t2
        Mips m = new Mips();

        RegisterFile.T1_REGISTER.setData(7);
        RegisterFile.T2_REGISTER.setData(8);

        int instCode = m.getInstructionBitStream(Parser.parseInstruction(
                "slt $t4, $t1, $t2", 1));
        IFIDRegister.setInstruction(instCode);
        IDEXRegister.setPc(1);

        m.decode();

        m.execute();

        m.memory();

        m.writeBack();

        System.out.println(RegisterFile.T4_REGISTER.getData());
        assertTrue("t4 should be 1", RegisterFile.T4_REGISTER.getData() == 1);
    }
}
