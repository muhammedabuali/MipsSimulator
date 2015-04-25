package eg.edu.guc.memory;

/**
 * Created by kady on 12/04/15.
 * <p/>
 * Memory class representing the main memory in mips architecture
 *
 * @author kady
 */
public class Memory {

    private static byte[] memory;
    private static int size = 262144;

    public Memory() {
        init();
    }

    public static int loadWord(int location) {
        int result;
        int b1 = loadByte(location + 0);
        int b2 = loadByte(location + 1);
        int b3 = loadByte(location + 2);
        int b4 = loadByte(location + 3);
        return b1 << 0 | b2 << 8 | b3 << 16 | b4 << 24;
    }

    public static int loadByte(int location) {

        return memory[location];
    }

    public static int loadByteUnsigned(int location) {

        int b1 = loadByte(location + 0);
        return ((int) 0) | b1;
    }

    public static boolean storeWord(int data, int location) {

        storeByte((byte) (data >> 0), location + 0);
        storeByte((byte) (data >> 8), location + 1);
        storeByte((byte) (data >> 16), location + 2);
        storeByte((byte) (data >> 24), location + 3);
        return true;
    }

    public static boolean storeByte(byte data, int location) {
        memory[location] = (byte) data;
        return true;
    }

    public static boolean clear() {
        memory = new byte[size];
        return true;
    }

    public static void init() {
        memory = new byte[size];
    }


    //Getters and setters

    public byte[] getMemory() {
        return memory;
    }

    public void setMemory(byte[] memory) {
        Memory.memory = memory;
    }
}
