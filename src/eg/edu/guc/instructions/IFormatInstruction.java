package eg.edu.guc.instructions;

import eg.edu.guc.registers.Register;

import java.util.HashMap;

/**
 * Created by kady on 12/04/15.
 * @author kady
 */
public class IFormatInstruction extends Instruction {


    private Register sourceRegister, targetRegister;
    private short constantAddressHolder;

    public IFormatInstruction(State state,
                              byte opcode,
                              Register sourceRegister,
                              Register targetRegister,
                              short constantAddressHolder) {
        super(state, opcode);
        this.sourceRegister = sourceRegister;
        this.targetRegister = targetRegister;
        this.constantAddressHolder = constantAddressHolder;
    }

    public IFormatInstruction(State state) {
        super(state);
    }

    @Override
    public boolean execute() {
        //TODO implement and add documentation
        return false;
    }

    @Override
    public HashMap<String, Integer> getControlSignals() {
        //TODO implement and add documentation
        return null;
    }

    // Getters and Setters

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
