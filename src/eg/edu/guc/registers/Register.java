package eg.edu.guc.registers;

/**
 * Created by kady on 12/04/15.
 * <p>
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

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        if (this == RegisterFile.ZERO_REGISTER) {
            System.err.println("Register ZERO can't be set");
            return;
        }
        this.data = data;
    }
}
