package eg.edu.guc.registers;

/**
 * Created by kady on 12/04/15.
 * <p/>
 * Register class , representing a single register in the mips processor
 *
 * @author kady
 */
public class Register {
    private int data;

    public Register(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
