package eg.edu.guc.registers;

/**
 * Created by kady on 22/04/15.
 *
 * @author kady
 */
public class MEMWBRegister {

    private int aluOut, memoryRead;

    private byte rd;

    //WB controls

    boolean memToReg, RegWrite;

    public int getAluOut() {
        return aluOut;
    }

    public void setAluOut(int aluOut) {
        this.aluOut = aluOut;
    }

    public int getMemoryRead() {
        return memoryRead;
    }

    public void setMemoryRead(int memoryRead) {
        this.memoryRead = memoryRead;
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
}
