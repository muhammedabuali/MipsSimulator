package eg.edu.guc.registers;

/**
 * Created by kady on 22/04/15.
 *
 * @author kady
 */
public class IFIDRegister {
    private static int instruction;
    private static int pc;

    public static int getInstruction() {
        return instruction;
    }

    public static void setInstruction(int instruction) {
        IFIDRegister.instruction = instruction;
    }

    public static int getPc() {
        return pc;
    }

    public static void setPc(int pc) {
        IFIDRegister.pc = pc;
    }
}
