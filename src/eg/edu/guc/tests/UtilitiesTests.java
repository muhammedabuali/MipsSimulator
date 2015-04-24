package eg.edu.guc.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eg.edu.guc.registers.RegisterFile;
import eg.edu.guc.utils.Utilities;

public class UtilitiesTests {
	@Test
	public void testGetRegByName() {
		RegisterFile.init();
		int atRegNum = Utilities.getRegisterByName("$at").getNumber();
		assertTrue("Should be 1", atRegNum == 1);
	}

	@Test
	public void testGetRegByNumber() {
		RegisterFile.init();
		int atRegNum = Utilities.getRegisterByNumber(1).getNumber();
		assertTrue("Should be 1", atRegNum == 1);
	}
	
	@Test
	public void testGetInstNameByOpcode(){
		RegisterFile.init();
		String instruction = Utilities.getInstructionNameByOpcode(1);
		assertTrue("the instruction should be add", instruction.equals("add"));
	}
}
