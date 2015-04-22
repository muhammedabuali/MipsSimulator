package eg.edu.guc.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created by kady on 17/04/15.
 * <p/>
 * Some utilities that is used in other classes
 *
 * @author kady
 */
public class Utilities {


    /**
     * Converting an int to a byte array
     *
     * @param value integer value
     * @param bytes the number of bytes returned
     * @return a byte array with the same integer value with <code>bytes</code> length
     */
    public static byte[] intToByteArray(Integer value, int bytes) {
        return ByteBuffer.allocate(bytes).order(ByteOrder.BIG_ENDIAN).putInt(value).array();
    }

    /**
     * Converting a byte array to an int
     *
     * @param value byte array
     * @return equivalent value as int
     */
    public static int byteArrayToInt(byte[] value) {
        return ByteBuffer.wrap(value).order(ByteOrder.BIG_ENDIAN).getInt();
    }
}
