package eg.edu.guc.instructions;

import java.util.HashMap;

/**
 * Created by kady on 12/04/15.
 */
public class JFormatInstruction extends Instruction {

    private int jumpAddress;

    public JFormatInstruction(State state, String opcode, int jumpAddress) {
        super(state, opcode);
        this.jumpAddress = jumpAddress;
    }

    public JFormatInstruction(State state) {
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

    //Getters and Setters

    public int getJumpAddress() {
        return jumpAddress;
    }

    public void setJumpAddress(int jumpAddress) {
        this.jumpAddress = jumpAddress;
    }
}
