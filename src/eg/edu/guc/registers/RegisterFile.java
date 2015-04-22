package eg.edu.guc.registers;

import eg.edu.guc.utils.Utilities;

/**
 * Created by kady on 12/04/15.
 * <p/>
 * The register file , containing references to all MIPS processor's registers
 *
 * @author kady
 */
public class RegisterFile {

    // ZERO_REGISTER .. Don't touch !
    public static final Register ZERO_REGISTER = new Register(Utilities.intToByteArray(0, 4));

    //Arguments
    public static Register A0_REGISTER;
    public static Register A1_REGISTER;
    public static Register A2_REGISTER;
    public static Register A3_REGISTER;

    //Result
    public static Register V0_REGISTER;
    public static Register V1_REGISTER;

    //Temp Registers
    public static Register T0_REGISTER;
    public static Register T1_REGISTER;
    public static Register T2_REGISTER;
    public static Register T3_REGISTER;
    public static Register T4_REGISTER;
    public static Register T5_REGISTER;
    public static Register T6_REGISTER;
    public static Register T7_REGISTER;
    public static Register T8_REGISTER;
    public static Register T9_REGISTER;

    //Saved Registers
    public static Register S0_REGISTER;
    public static Register S1_REGISTER;
    public static Register S2_REGISTER;
    public static Register S3_REGISTER;
    public static Register S4_REGISTER;
    public static Register S5_REGISTER;
    public static Register S6_REGISTER;
    public static Register S7_REGISTER;

    //Global pointer
    public static Register GP_REGISTER;

    //Stack pointer
    public static Register SP_REGISTER;

    //Frame pointer
    public static Register FP_REGISTER;

    //Return address
    public static Register RA_REGISTER;

    //Pipelining Stuff
    public static Register IF_ID_REGISTER;
    public static Register ID_EX_REGISTER;
    public static Register EX_MEM_REGISTER;
    public static Register EX_WB_REGISTER;


    /**
     * Initializing <strong>All</strong> registers in <code>RegisterFile</code> to <strong>Zeros</strong>
     *
     * @return true if all initialized correctly
     */
    public static boolean init() {
        // TODO can be done using reflection ?
        A0_REGISTER = new Register(Utilities.intToByteArray(0, 4));
        A1_REGISTER = new Register(Utilities.intToByteArray(0, 4));
        A2_REGISTER = new Register(Utilities.intToByteArray(0, 4));
        A3_REGISTER = new Register(Utilities.intToByteArray(0, 4));

        V0_REGISTER = new Register(Utilities.intToByteArray(0, 4));
        V1_REGISTER = new Register(Utilities.intToByteArray(0, 4));

        T0_REGISTER = new Register(Utilities.intToByteArray(0, 4));
        T1_REGISTER = new Register(Utilities.intToByteArray(0, 4));
        T2_REGISTER = new Register(Utilities.intToByteArray(0, 4));
        T3_REGISTER = new Register(Utilities.intToByteArray(0, 4));
        T4_REGISTER = new Register(Utilities.intToByteArray(0, 4));
        T5_REGISTER = new Register(Utilities.intToByteArray(0, 4));
        T6_REGISTER = new Register(Utilities.intToByteArray(0, 4));
        T7_REGISTER = new Register(Utilities.intToByteArray(0, 4));
        T8_REGISTER = new Register(Utilities.intToByteArray(0, 4));
        T9_REGISTER = new Register(Utilities.intToByteArray(0, 4));

        S0_REGISTER = new Register(Utilities.intToByteArray(0, 4));
        S1_REGISTER = new Register(Utilities.intToByteArray(0, 4));
        S2_REGISTER = new Register(Utilities.intToByteArray(0, 4));
        S3_REGISTER = new Register(Utilities.intToByteArray(0, 4));
        S4_REGISTER = new Register(Utilities.intToByteArray(0, 4));
        S5_REGISTER = new Register(Utilities.intToByteArray(0, 4));
        S6_REGISTER = new Register(Utilities.intToByteArray(0, 4));
        S7_REGISTER = new Register(Utilities.intToByteArray(0, 4));

        GP_REGISTER = new Register(Utilities.intToByteArray(0, 4));
        SP_REGISTER = new Register(Utilities.intToByteArray(0, 4));
        FP_REGISTER = new Register(Utilities.intToByteArray(0, 4));
        RA_REGISTER = new Register(Utilities.intToByteArray(0, 4));


        //FIXME register structure will be updated to contain more bytes
        IF_ID_REGISTER = new Register(Utilities.intToByteArray(0, 4));
        ID_EX_REGISTER = new Register(Utilities.intToByteArray(0, 4));
        EX_MEM_REGISTER = new Register(Utilities.intToByteArray(0, 4));
        EX_WB_REGISTER = new Register(Utilities.intToByteArray(0, 4));


        return true;
    }

}
