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
    private String opcode;//TODO discuss about type , masked byte ?

    public Instruction(State state, String opcode) {
        this.state = state;
        this.opcode = opcode;
    }

    public Instruction(State state) {
        this.state = state;
    }

    public void advanceState() {
        //TODO implement and add documentation
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


    public enum State {
        UNSTARTED, IF, ID, EX, MEM, WB, FINISHED
    }

}
