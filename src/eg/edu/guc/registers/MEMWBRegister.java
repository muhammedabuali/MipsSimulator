package eg.edu.guc.registers;

/**
 * Created by kady on 22/04/15.
 *
 * @author kady
 */
public class MEMWBRegister {

    private static int aluOut, memoryRead;

    private static byte rd;

    //WB controls

    static boolean memToReg, regWrite;

    public static int getAluOut() {
        return aluOut;
    }

    public static void setAluOut(int aluOut) {
        MEMWBRegister.aluOut = aluOut;
    }

    public static int getMemoryRead() {
        return memoryRead;
    }

    public static void setMemoryRead(int memoryRead) {
        MEMWBRegister.memoryRead = memoryRead;
    }

    public static byte getRd() {
        //TODO mask
        return rd;
    }

    public static void setRd(byte rd) {
        //TODO Check length ... 5
        MEMWBRegister.rd = rd;
    }

    public static boolean isMemToReg() {
        return memToReg;
    }

    public static void setMemToReg(boolean memToReg) {
        MEMWBRegister.memToReg = memToReg;
    }

    public static boolean isRegWrite() {
        return regWrite;
    }

    public static void setRegWrite(boolean regWrite) {
        MEMWBRegister.regWrite = regWrite;
    }
}
