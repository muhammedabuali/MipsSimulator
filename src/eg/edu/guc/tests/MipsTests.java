package eg.edu.guc.tests;

import static org.junit.Assert.*;

import eg.edu.guc.registers.IDEXRegister;
import eg.edu.guc.registers.IFIDRegister;
import org.junit.Test;

import eg.edu.guc.mips.Mips;
import eg.edu.guc.mips.Parser;
import eg.edu.guc.registers.RegisterFile;
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
        int instruction = Integer.parseInt("000000" + "01001" + "01010" + "01000" + "00000" + "100000", 2);
        IFIDRegister.setInstruction(instruction);

        Mips m = new Mips();


        m.decode();
        assertTrue("funct should be 100000", Utilities.getSubset(IDEXRegister.getOffset(), 0, 5) == 0b100000);
        assertTrue("rt should be $t2", Utilities.getRegisterByNumber(IDEXRegister.getRt()) == RegisterFile.T2_REGISTER);
        assertTrue("rd should be $t0", Utilities.getRegisterByNumber(IDEXRegister.getRd()).equals(RegisterFile.T0_REGISTER));
    }
}
