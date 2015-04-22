package eg.edu.guc.registers;

import eg.edu.guc.utils.Utilities;

/**
 * Created by kady on 12/04/15.
 * <p/>
 * Register class , representing a single register in the mips processor
 *
 * @author kady
 */
public class Register {
    private byte[] data;

    public Register(byte[] data) {
        this.data = new byte[4];
        for (int i = 0; i < data.length; i++) {
            this.data[i] = data[i];
        }
    }

    /**
     * Constructing a register with an int value
     *
     * @param data
     */
    public Register(int data) {
        this.data = Utilities.intToByteArray(data, 4);
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        //TODO Check if we can throw an exception , or remove this and depend on the final declaration's exception
        if (this == RegisterFile.ZERO_REGISTER) {
            System.err.println("Register ZERO can't be set");
            return;
        }
        this.data = data;
    }

    /**
     * Setting data into register passing an int
     *
     * @param data
     */
    public void setData(int data) {
        //TODO Check if we can throw an exception , or remove this and depend on the final declaration's exception
        if (this == RegisterFile.ZERO_REGISTER) {
            System.err.println("Register ZERO can't be set");
            return;
        }

        this.data = Utilities.intToByteArray(data, 4);
    }
}
