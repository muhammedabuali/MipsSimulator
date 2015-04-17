package eg.edu.guc.utils;

import eg.edu.guc.instructions.Instruction;

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
     * @return a byte array with the same integer value if concatenated
     */
    public static byte[] intToByteArray(Integer value) {
        return new byte[]{
                (byte) (value >>> 24),
                (byte) (value >>> 16),
                (byte) (value >>> 8),
                (byte) value.intValue()};
    }

    public static Instruction parse(String line) {
        //TODO implement the parse function here :D
        return null;
    }
}
