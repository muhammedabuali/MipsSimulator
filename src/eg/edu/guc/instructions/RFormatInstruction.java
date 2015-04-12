package eg.edu.guc.instructions;

import eg.edu.guc.registers.Register;

import java.util.HashMap;

/**
 * Created by kady on 12/04/15.
 *
 * @author kady
 */
public class RFormatInstruction extends Instruction {

    private String opcode; //TODO discuss about type , masked byte ?
    private Register sourceRegister, targetRegister, destinationRegister;
    private byte shiftAmount, function;

    public RFormatInstruction(State state,
                              String opcode,
                              Register sourceRegister,
                              Register targetRegister,
                              Register destinationRegister,
                              byte shiftAmount,
                              byte function) {
        super(state);
        this.opcode = opcode;
        this.sourceRegister = sourceRegister;
        this.targetRegister = targetRegister;
        this.destinationRegister = destinationRegister;
        this.shiftAmount = shiftAmount;
        this.function = function;
    }

    public RFormatInstruction(Instruction.State state) {
        super(state);
    }

    @Override
    public boolean execute() {
        //TODO implement and add documentation
        return false;
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

    public Register getDestinationRegister() {
        return destinationRegister;
    }

    public void setDestinationRegister(Register destinationRegister) {
        this.destinationRegister = destinationRegister;
    }

    public byte getShiftAmount() {
        return shiftAmount;
    }

    public void setShiftAmount(byte shiftAmount) {
        this.shiftAmount = shiftAmount;
    }

    public byte getFunction() {
        return function;
    }

    public void setFunction(byte function) {
        this.function = function;
    }

    @Override
    public HashMap<String, Integer> getControlSignals() {
        //TODO implement and add documentation
        return null;
    }
}
