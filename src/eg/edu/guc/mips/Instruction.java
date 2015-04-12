package eg.edu.guc.mips;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kady on 12/04/15.
 *
 * @author kady
 */
public abstract class Instruction {

    private State state;

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


    private enum State {
        UNSTARTED, IF, ID, EX, MEM, WB, FINISHED
    }

}
