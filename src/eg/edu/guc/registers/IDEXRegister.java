package eg.edu.guc.registers;

/**
 * Created by kady on 22/04/15.
 *
 * @author kady
 */
public class IDEXRegister {

    private int pc, registerOneValue, registerTwoValue, offset;

    private byte Rt, Rd;

    //WB controls

    boolean memToReg, RegWrite;

    //Memory controls

    boolean memWrite, memRead;

    //EX controls

    boolean regDest, aluOp, aluSrc;

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public int getRegisterOneValue() {
        return registerOneValue;
    }

    public void setRegisterOneValue(int registerOneValue) {
        this.registerOneValue = registerOneValue;
    }

    public int getRegisterTwoValue() {
        return registerTwoValue;
    }

    public void setRegisterTwoValue(int registerTwoValue) {
        this.registerTwoValue = registerTwoValue;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public byte getRt() {
        //TODO mask
        return Rt;
    }

    public void setRt(byte rt) {
        //TODO Check length ... 5
        Rt = rt;
    }

    public byte getRd() {
        //TODO mask
        return Rd;
    }

    public void setRd(byte rd) {
        //TODO Check length ... 5
        Rd = rd;
    }

    public boolean isMemToReg() {
        return memToReg;
    }

    public void setMemToReg(boolean memToReg) {
        this.memToReg = memToReg;
    }

    public boolean isRegWrite() {
        return RegWrite;
    }

    public void setRegWrite(boolean regWrite) {
        RegWrite = regWrite;
    }

    public boolean isMemWrite() {
        return memWrite;
    }

    public void setMemWrite(boolean memWrite) {
        this.memWrite = memWrite;
    }

    public boolean isMemRead() {
        return memRead;
    }

    public void setMemRead(boolean memRead) {
        this.memRead = memRead;
    }

    public boolean isRegDest() {
        return regDest;
    }

    public void setRegDest(boolean regDest) {
        this.regDest = regDest;
    }

    public boolean isAluOp() {
        return aluOp;
    }

    public void setAluOp(boolean aluOp) {
        this.aluOp = aluOp;
    }

    public boolean isAluSrc() {
        return aluSrc;
    }

    public void setAluSrc(boolean aluSrc) {
        this.aluSrc = aluSrc;
    }
}
