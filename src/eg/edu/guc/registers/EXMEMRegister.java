package eg.edu.guc.registers;

/**
 * Created by kady on 22/04/15.
 *
 * @author kady
 */
public class EXMEMRegister {
    private static int branchAddress, aluOut, memoryReadValue;
    private static boolean zeroFlag;

    private static byte rd;

    //WB controls

    static boolean memToReg, RegWrite;

    //Memory controls

    static boolean memWrite, memRead;

    //Aly Control Signals

    static boolean memByte, unsigned, compOne, jump, branch;

    //jump address <last line in conventions.text --> jump address
    static int jumpAddress;

    //register one value in case of jr
    static int jrRegisterAddress;

    public static int getJumpAddress() {
        return jumpAddress;
    }

    public static void setJumpAddress(int jumpAddress) {
        EXMEMRegister.jumpAddress = jumpAddress;
    }

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

    public static int getMemoryReadValue() {
        return memoryReadValue;
    }

    public static void setMemoryReadValue(int memoryReadValue) {
        EXMEMRegister.memoryReadValue = memoryReadValue;
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

    public static boolean isMemByte() {
        return memByte;
    }

    public static void setMemByte(boolean memByte) {
        EXMEMRegister.memByte = memByte;
    }

    public static boolean isUnsigned() {
        return unsigned;
    }

    public static void setUnsigned(boolean unsigned) {
        EXMEMRegister.unsigned = unsigned;
    }

    public static boolean isCompOne() {
        return compOne;
    }

    public static void setCompOne(boolean compOne) {
        EXMEMRegister.compOne = compOne;
    }

    public static boolean isJump() {
        return jump;
    }

    public static void setJump(boolean jump) {
        EXMEMRegister.jump = jump;
    }

    public static boolean isBranch() {
        return branch;
    }

    public static void setBranch(boolean branch) {
        EXMEMRegister.branch = branch;
    }

    public static int getJrRegisterOneValueAddress() {
        return jrRegisterAddress;
    }

    public static void setJrRegisterAddress(int jrRegisterAddress) {
        EXMEMRegister.jrRegisterAddress = jrRegisterAddress;
    }
}
