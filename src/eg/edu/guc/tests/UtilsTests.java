package eg.edu.guc.tests;

import eg.edu.guc.instructions.IFormatInstruction;
import eg.edu.guc.instructions.Instruction;
import eg.edu.guc.mips.Main;
import eg.edu.guc.utils.Utilities;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by mohamed on 17/04/15.
 */
public class UtilsTests {

    @Test
    public void byteArrayToIntTest() {
        byte[] data = new byte[]{0x10, 0x12, 0x13, 0x14};
        assertEquals(269619988, Utilities.byteArrayToInt(data));

        data = new byte[]{0x00, 0x00, 0x13, 0x14};
        assertEquals(4884, Utilities.byteArrayToInt(data));
    }

    @Test
    public void intToByteArrayTest() {
        int value = 269619988;


        assertTrue(Arrays.equals(new byte[]{0x10, 0x12, 0x13, 0x14}, Utilities.intToByteArray(value, 4)));
        //FIXME WAT BigEndian ?
        assertTrue(Arrays.equals(new byte[]{0x10, 0x12, 0x13, 0x14, 0x00}, Utilities.intToByteArray(value, 5)));

        assertFalse(Arrays.equals(new byte[]{0x12, 0x12, 0x13, 0x14}, Utilities.intToByteArray(value, 4)));
        assertFalse(Arrays.equals(new byte[]{0x10, 0x12, 0x13, 0x14}, Utilities.intToByteArray(value, 5)));
    }

}
