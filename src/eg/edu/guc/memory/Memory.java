package eg.edu.guc.memory;

/**
 * Created by kady on 12/04/15.
 * <p/>
 * Memory class representing the main memory in mips architecture
 *
 * @author kady
 */
public class Memory {

    private static int[] memory;
    private static int size;

    public Memory() {
        init();
    }

    public static int loadWord(int location) {
        //TODO implement and add documentation
        return -1;
    }

    public static byte loadByte(int location) {
        //TODO implement and add documentation
        return -1;
    }

    public static byte loadByteUnsigned(int location) {
        //TODO implement and add documentation
        return -1;
    }

    public static boolean storeWord(int data, int location) {
        //TODO implement and add documentation
        return false;
    }

    public static boolean storeByte(byte data, int location) {
        //TODO implement and add documentation
        return false;
    }

    public static boolean clear() {
        //TODO implement and add documentation
        return true;
    }

    public static void init() {
        //TODO implement and add documentation
        memory = new int[size];
    }


    //Getters and setters

    public int[] getMemory() {
        return memory;
    }

    public void setMemory(int[] memory) {
        Memory.memory = memory;
    }
}
