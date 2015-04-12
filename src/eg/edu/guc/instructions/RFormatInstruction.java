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

    @Override
    public HashMap<String, Integer> getControlSignals() {
        //TODO implement and add documentation
        return null;
    }
}
