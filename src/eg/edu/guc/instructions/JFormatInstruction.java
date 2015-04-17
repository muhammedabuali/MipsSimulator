package eg.edu.guc.instructions;

import java.util.HashMap;

/**
 * Created by kady on 12/04/15.
 *
 * @author kady
 * @author kady
 */
public class JFormatInstruction extends Instruction {

    private int jumpAddress;

    public JFormatInstruction(State state, byte opcode, int jumpAddress) {
        super(state, opcode);
        this.jumpAddress = jumpAddress;
    }

    public JFormatInstruction(State state) {
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

    //Getters and Setters

    public int getJumpAddress() {
        return jumpAddress;
    }

    public void setJumpAddress(int jumpAddress) {
        this.jumpAddress = jumpAddress;
    }
}
