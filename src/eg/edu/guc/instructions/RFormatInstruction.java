package eg.edu.guc.instructions;

import eg.edu.guc.registers.Register;

import java.util.HashMap;

/**
 * Created by kady on 12/04/15.
 *
 * @author kady
 */
public class RFormatInstruction extends Instruction {

    private Register sourceRegister, targetRegister, destinationRegister;
    private byte shiftAmount, function;

    public RFormatInstruction(State state,
                              byte opcode,
                              Register sourceRegister,
                              Register targetRegister,
                              Register destinationRegister,
                              byte shiftAmount,
                              byte function) {
        super(state, opcode);
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

    @Override
    public HashMap<String, Integer> getControlSignals() {
        //TODO implement and add documentation
        return null;
    }

    // add method
    public void add()
    {
    }

    // subtracting method
    public void sub()
    {
    }

    //Bitwise and method
    public void and()
    {
    }
    //Bitwise nor method
    public void nor()
    {

    }
    // Set if less than method
    public void slt()
    {
    }
    // Set if less than unsigned method
    public void sltu()
    {
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
}
