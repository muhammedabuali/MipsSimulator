package eg.edu.guc.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import eg.edu.guc.mips.Mips;
import eg.edu.guc.mips.Parser;
import eg.edu.guc.registers.RegisterFile;
import eg.edu.guc.utils.Utilities;

public class MipsTests {

	@Test
	public void testGetRInstructionBitStream() {
		RegisterFile.init();
		Mips m = new Mips();

		int instCode = m.getInstructionBitStream(Parser.parseInstruction(
				"add $t1, $t2, $t3", 1));
		assertTrue(
				"The code for the instruction should be 0x014b4820 as found in mars",
				Integer.toHexString(instCode).equals("14b4820"));
	}

	@Test
	public void testGetIInstructionBitStream() {
		RegisterFile.init();
		Mips m = new Mips();

		int instCode = m.getInstructionBitStream(Parser.parseInstruction(
				"addi $t1, $t2, 11", 1));
		assertTrue(
				"The code for the instruction should be 0x2149000b as found in mars",
				Integer.toHexString(instCode).equals("2149000b"));
	}

	@Test
	public void testGetInstructionNameByOpcodePart() {
		RegisterFile.init();
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
}
