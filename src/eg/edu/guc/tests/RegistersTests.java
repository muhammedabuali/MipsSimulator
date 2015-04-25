package eg.edu.guc.tests;

import eg.edu.guc.registers.Register;
import eg.edu.guc.registers.RegisterFile;
import eg.edu.guc.utils.Constants;
import eg.edu.guc.utils.Utilities;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mohamed on 17/04/15.
 */
public class RegistersTests {
    @Test
    public void testingRegisterDisplay() {
        RegisterFile.init();

        Register a0 = RegisterFile.A0_REGISTER;

        Register v1 = RegisterFile.V1_REGISTER;

        assertEquals("REGISTER\n" +
                "$a0\t==> number:4\n" +
                "HEX:0\n" +
                "BIN:0\n" +
                "DEC:0\n", a0.toString());

        assertEquals("REGISTER\n" +
                "$v1\t==> number:3\n" +
                "HEX:0\n" +
                "BIN:0\n" +
                "DEC:0\n", v1.toString());

        a0.setData(0b01000000000000111000000000000000);

        assertEquals("REGISTER\n" +
                "$a0\t==> number:4\n" +
                "HEX:40038000\n" +
                "BIN:1000000000000111000000000000000\n" +
                "DEC:1073971200\n", a0.toString());

        v1.setData(15);

        assertEquals("REGISTER\n" +
                "$v1\t==> number:3\n" +
                "HEX:f\n" +
                "BIN:1111\n" +
                "DEC:15\n", v1.toString());


    }
}
