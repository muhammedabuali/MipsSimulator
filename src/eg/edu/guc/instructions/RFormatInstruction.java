package eg.edu.guc.instructions;

import eg.edu.guc.registers.Register;
import eg.edu.guc.registers.RegisterFile;

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
        if (!destinationRegister.equals(RegisterFile.ZERO_REGISTER)) {
            this.setState(State.ID);
            switch (this.getOpcode()) {
                case 0000:
                    add();
                    break;
                case 0001:
                    sub();
                    break;
                case 0010:
                    and();
                    break;
                case 0011:
                    nor();
                    break;
                case 0100:
                    slt();
                    break;
                default:
                    sltu();
                    break;
            }
            return true;
        }
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
        this.setState(State.EX);
        byte [] destinationArray = new byte[4];
        byte [] sourceArray = sourceRegister.getData();
        byte [] targetArray = targetRegister.getData();
        for (int i = 0; i<destinationArray.length;i++)
        {
            destinationArray[i]= (byte) (sourceArray[i] + targetArray[i]);
        }
        destinationRegister.setData(destinationArray);
    }

    // subtracting method
    public void sub()
    {
        this.setState(State.EX);
        byte [] destinationArray = new byte[4];
        byte [] sourceArray = sourceRegister.getData();
        byte [] targetArray = targetRegister.getData();
        for (int i = 0; i<destinationArray.length;i++)
        {
            destinationArray[i]= (byte) (sourceArray[i] - targetArray[i]);
        }
        destinationRegister.setData(destinationArray);

    }

    //Bitwise and method
    public void and()
    {
        this.setState(State.EX);
        byte [] destinationArray = new byte[4];
        byte [] sourceArray = sourceRegister.getData();
        byte [] targetArray = targetRegister.getData();
        for (int i = 0; i<destinationArray.length;i++)
        {
            destinationArray[i]= (byte) (sourceArray[i] & targetArray[i]);
        }
        destinationRegister.setData(destinationArray);

    }
    //Bitwise nor method
    public void nor()
    {
        this.setState(State.EX);
        byte [] destinationArray = new byte[4];
        byte [] sourceArray = sourceRegister.getData();
        byte [] targetArray = targetRegister.getData();
        for (int i = 0; i<destinationArray.length;i++)
        {
            destinationArray[i]= (byte) ~(sourceArray[i] | targetArray[i]);
        }
        destinationRegister.setData(destinationArray);

    }
    // Set if less than method
    public void slt()
    {
        this.setState(State.EX);
        boolean notEqual = false;
        byte [] destinationArray = new byte[4];
        byte [] sourceArray = sourceRegister.getData();
        byte [] targetArray = targetRegister.getData();
        for (int i = 0; i<destinationArray.length;i++)
        {
            if (sourceArray[i] != targetArray[i])
            {
                notEqual=true;
                break;
            }

        }
        if (!notEqual)
            destinationArray[3]=1;

    }
    // Set if less than unsigned method
    public void sltu()
    {
        this.setState(State.EX);
        boolean notEqual = false;
        byte [] destinationArray = new byte[4];
        byte [] sourceArray = sourceRegister.getData();
        byte [] targetArray = targetRegister.getData();
        for (int i = 0; i<destinationArray.length;i++)
        {
            if (sourceArray[i] != targetArray[i])
            {
                notEqual=true;
                break;
            }

        }
        if (!notEqual)
            destinationArray[3]=1;

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
