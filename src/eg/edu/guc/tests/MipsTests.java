package eg.edu.guc.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import eg.edu.guc.mips.Mips;
import eg.edu.guc.registers.RegisterFile;

public class MipsTests {

	@Test
	public void testGetRInstructionBitStream() {
		RegisterFile.init();
		Mips m = new Mips();

		int instCode = m.getInstructionBitStream("add $t1, $t2, $t3");
		assertTrue(
				"The code for the instruction should be 0x014b4820 as found in mars",
				Integer.toHexString(instCode).equals("14b4820"));
	}

	@Test
	public void testGetIInstructionBitStream() {
		RegisterFile.init();
		Mips m = new Mips();

		int instCode = m.getInstructionBitStream("addi $t1, $t2, 11");
		assertTrue(
				"The code for the instruction should be 0x2149000b as found in mars",
				Integer.toHexString(instCode).equals("2149000b"));
	}
}
