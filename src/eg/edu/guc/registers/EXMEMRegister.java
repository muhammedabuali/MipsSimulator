package eg.edu.guc.registers;

/**
 * Created by kady on 22/04/15.
 *
 * @author kady
 */
public class EXMEMRegister {
    private static int branchAddress, aluOut, registerValueToMem;
    private static boolean zeroFlag;

    private static byte rd;

    //WB controls

    static boolean memToReg, RegWrite;

    //Memory controls

    static boolean memWrite, memRead;

    public static int getBranchAddress() {
        return branchAddress;
    }

    public static void setBranchAddress(int branchAddress) {
        EXMEMRegister.branchAddress = branchAddress;
    }

    public static int getAluOut() {
        return aluOut;
    }

    public static void setAluOut(int aluOut) {
        EXMEMRegister.aluOut = aluOut;
    }

    public static int getRegisterValueToMem() {
        return registerValueToMem;
    }

    public static void setRegisterValueToMem(int registerValueToMem) {
        EXMEMRegister.registerValueToMem = registerValueToMem;
    }

    public static boolean isZeroFlag() {
        return zeroFlag;
    }

    public static void setZeroFlag(boolean zeroFlag) {
        EXMEMRegister.zeroFlag = zeroFlag;
    }

    public static byte getRd() {
        //TODO mask
        return rd;
    }

    public static void setRd(byte rd) {
        //TODO Check length ... 5
        EXMEMRegister.rd = rd;
    }

    public static boolean isMemToReg() {
        return memToReg;
    }

    public static void setMemToReg(boolean memToReg) {
        EXMEMRegister.memToReg = memToReg;
    }

    public static boolean isRegWrite() {
        return RegWrite;
    }

    public static void setRegWrite(boolean regWrite) {
        RegWrite = regWrite;
    }

    public static boolean isMemWrite() {
        return memWrite;
    }

    public static void setMemWrite(boolean memWrite) {
        EXMEMRegister.memWrite = memWrite;
    }

    public static boolean isMemRead() {
        return memRead;
    }

    public static void setMemRead(boolean memRead) {
        EXMEMRegister.memRead = memRead;
    }
}
