package eg.edu.guc.registers;

/**
 * Created by kady on 22/04/15.
 *
 * @author kady
 */
public class IDEXRegister {

    private static int pc, registerOneValue, registerTwoValue, offset;

    private static byte rt, rd;

    //WB controls

    static boolean memToReg, RegWrite;

    //Memory controls

    static boolean memWrite, memRead, branch;

    //EX controls

    static boolean regDest, aluSrc;

    static int aluOp;

    public static int getPc() {
        return pc;
    }

    public static void setPc(int pc) {
        IDEXRegister.pc = pc;
    }

    public static int getRegisterOneValue() {
        return registerOneValue;
    }

    public static void setRegisterOneValue(int registerOneValue) {
        IDEXRegister.registerOneValue = registerOneValue;
    }

    public static int getRegisterTwoValue() {
        return registerTwoValue;
    }

    public static void setRegisterTwoValue(int registerTwoValue) {
        IDEXRegister.registerTwoValue = registerTwoValue;
    }

    public static int getOffset() {
        return offset;
    }

    public static void setOffset(int offset) {
        IDEXRegister.offset = offset;
    }

    public static byte getRt() {
        //TODO mask
        return rt;
    }

    public static void setRt(byte rt) {
        //TODO Check length ... 5
        IDEXRegister.rt = rt;
    }

    public static byte getRd() {
        //TODO mask
        return rd;
    }

    public static void setRd(byte rd) {
        //TODO Check length ... 5
        IDEXRegister.rd = rd;
    }

    public static boolean isMemToReg() {
        return memToReg;
    }

    public static void setMemToReg(boolean memToReg) {
        IDEXRegister.memToReg = memToReg;
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
        IDEXRegister.memWrite = memWrite;
    }

    public static boolean isMemRead() {
        return memRead;
    }

    public static void setMemRead(boolean memRead) {
        IDEXRegister.memRead = memRead;
    }

    public static boolean isRegDest() {
        return regDest;
    }

    public static void setRegDest(boolean regDest) {
        IDEXRegister.regDest = regDest;
    }

    public static int isAluOp() {
        return aluOp;
    }

    public static void setAluOp(int aluOp) {
        IDEXRegister.aluOp = aluOp;
    }

    public static boolean isAluSrc() {
        return aluSrc;
    }

    public static void setAluSrc(boolean aluSrc) {
        IDEXRegister.aluSrc = aluSrc;
    }
}
