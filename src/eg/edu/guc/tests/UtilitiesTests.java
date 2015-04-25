package eg.edu.guc.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eg.edu.guc.registers.RegisterFile;
import eg.edu.guc.utils.Utilities;

public class UtilitiesTests {
    @Test
    public void testGetRegByName() {
        int atRegNum = Utilities.getRegisterByName("$at").getNumber();
        assertTrue("Should be 1", atRegNum == 1);
    }

    @Test
    public void testGetRegByNumber() {
        int atRegNum = Utilities.getRegisterByNumber(1).getNumber();
        assertTrue("Should be 1", atRegNum == 1);
    }

    @Test
    public void testGetInstNameByOpcode() {
        String instruction = Utilities.getInstructionNameByOpcode(32);
        assertTrue("The instruction should be add", instruction.equals("add"));
    }
}
