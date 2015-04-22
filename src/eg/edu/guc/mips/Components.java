package eg.edu.guc.mips;

/**
 * Created by kady on 22/04/15.
 */
public class Components {
    private static int PC;

    public static int getPC() {
        return PC;
    }

    public static void incrementPC() {
        Components.PC += 1;
    }

    public static void setPC(int PC) {
        Components.PC = PC;
    }
}
