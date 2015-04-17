package eg.edu.guc.instructions;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kady on 12/04/15.
 *
 * @author kady
 */
public abstract class Instruction {

    private State state;
    private byte opcode;

    public Instruction(State state, byte opcode) {
        this.state = state;
        this.opcode = opcode;
    }

    public Instruction(State state) {
        this.state = state;
    }

    public State advanceState() {
        //TODO implement and add documentation
        return state;
    }

    public abstract boolean execute();

    public abstract HashMap<String, Integer> getControlSignals();


    // Getters and Setters

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public byte getOpcode() {
        return opcode;
    }

    public void setOpcode(byte opcode) {
        this.opcode = opcode;
    }

    public enum State {
         IF, ID, EX, MEM, WB, FINISHED
    }
}
