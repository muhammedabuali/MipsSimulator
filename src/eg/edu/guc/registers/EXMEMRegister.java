package eg.edu.guc.registers;

/**
 * Created by kady on 22/04/15.
 *
 * @author kady
 */
public class EXMEMRegister {
    private int branchAddress, aluOut, registerValueToMem;
    private boolean zeroFlag;

    byte rd;

    //WB controls

    boolean memToReg, RegWrite;

    //Memory controls

    boolean memWrite, memRead;

    public int getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(int branchAddress) {
        this.branchAddress = branchAddress;
    }

    public int getAluOut() {
        return aluOut;
    }

    public void setAluOut(int aluOut) {
        this.aluOut = aluOut;
    }

    public int getRegisterValueToMem() {
        return registerValueToMem;
    }

    public void setRegisterValueToMem(int registerValueToMem) {
        this.registerValueToMem = registerValueToMem;
    }

    public boolean isZeroFlag() {
        return zeroFlag;
    }

    public void setZeroFlag(boolean zeroFlag) {
        this.zeroFlag = zeroFlag;
    }

    public byte getRd() {
        //TODO mask
        return rd;
    }

    public void setRd(byte rd) {
        //TODO Check length ... 5
        this.rd = rd;
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
}
