package eg.edu.guc.instructions;

import eg.edu.guc.registers.Register;

import java.util.HashMap;

/**
 * Created by kady on 12/04/15.
 */
public class IFormatInstruction extends Instruction {

    /*
    op 6b String  //  operation code (opcode)
rs  5b  Register // first source register number
rt  5b  Register // second source register number
constant/address 16b byte//function code (extends opcode)

     */

    private String opcode;//TODO discuss about type , masked byte ?
    private Register sourceRegister, targetRegister;
    private short constantAddressHolder;

    public IFormatInstruction(State state,
                              String opcode,
                              Register sourceRegister,
                              Register targetRegister,
                              short constantAddressHolder) {
        super(state);
        this.opcode = opcode;
        this.sourceRegister = sourceRegister;
        this.targetRegister = targetRegister;
        this.constantAddressHolder = constantAddressHolder;
    }

    public IFormatInstruction(State state) {
        super(state);
    }

    @Override
    public boolean execute() {
        return false;
    }

    @Override
    public HashMap<String, Integer> getControlSignals() {
        return null;
    }

    // Getters and Setters

    public String getOpcode() {
        return opcode;
    }

    public void setOpcode(String opcode) {
        this.opcode = opcode;
    }

    public Register getSourceRegister() {
        return sourceRegister;
    }

    public void setSourceRegister(Register sourceRegister) {
        this.sourceRegister = sourceRegister;
    }

    public Register getTargetRegister() {
        return targetRegister;
    }

    public void setTargetRegister(Register targetRegister) {
        this.targetRegister = targetRegister;
    }

    public short getConstantAddressHolder() {
        return constantAddressHolder;
    }

    public void setConstantAddressHolder(short constantAddressHolder) {
        this.constantAddressHolder = constantAddressHolder;
    }
}
