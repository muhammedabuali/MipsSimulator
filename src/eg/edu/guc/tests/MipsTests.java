package eg.edu.guc.tests;

import org.junit.Test;

import eg.edu.guc.mips.Mips;
import eg.edu.guc.registers.RegisterFile;

public class MipsTests {

	@Test
	public void testGetRInstructionBitStream() {
		RegisterFile.init();
		Mips m = new Mips();

		int instCode = m.getInstructionBitStream("add $t1, $t2, $t3");
		System.out.println(instCode);
	}
}
