package eg.edu.guc.registers;

import eg.edu.guc.utils.Utilities;

/**
 * Created by kady on 12/04/15.
 * <p>
 * The register file , containing references to all MIPS processor's registers
 *
 * @author kady
 */
public class RegisterFile {

    // ZERO_REGISTER .. Don't touch !
    public static final Register ZERO_REGISTER = new Register(Utilities.intToByteArray(0));

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
        A0_REGISTER = new Register(Utilities.intToByteArray(0));
        A1_REGISTER = new Register(Utilities.intToByteArray(0));
        A2_REGISTER = new Register(Utilities.intToByteArray(0));
        A3_REGISTER = new Register(Utilities.intToByteArray(0));

        V0_REGISTER = new Register(Utilities.intToByteArray(0));
        V1_REGISTER = new Register(Utilities.intToByteArray(0));

        T0_REGISTER = new Register(Utilities.intToByteArray(0));
        T1_REGISTER = new Register(Utilities.intToByteArray(0));
        T2_REGISTER = new Register(Utilities.intToByteArray(0));
        T3_REGISTER = new Register(Utilities.intToByteArray(0));
        T4_REGISTER = new Register(Utilities.intToByteArray(0));
        T5_REGISTER = new Register(Utilities.intToByteArray(0));
        T6_REGISTER = new Register(Utilities.intToByteArray(0));
        T7_REGISTER = new Register(Utilities.intToByteArray(0));
        T8_REGISTER = new Register(Utilities.intToByteArray(0));
        T9_REGISTER = new Register(Utilities.intToByteArray(0));

        S0_REGISTER = new Register(Utilities.intToByteArray(0));
        S1_REGISTER = new Register(Utilities.intToByteArray(0));
        S2_REGISTER = new Register(Utilities.intToByteArray(0));
        S3_REGISTER = new Register(Utilities.intToByteArray(0));
        S4_REGISTER = new Register(Utilities.intToByteArray(0));
        S5_REGISTER = new Register(Utilities.intToByteArray(0));
        S6_REGISTER = new Register(Utilities.intToByteArray(0));
        S7_REGISTER = new Register(Utilities.intToByteArray(0));

        GP_REGISTER = new Register(Utilities.intToByteArray(0));
        SP_REGISTER = new Register(Utilities.intToByteArray(0));
        FP_REGISTER = new Register(Utilities.intToByteArray(0));
        RA_REGISTER = new Register(Utilities.intToByteArray(0));

        IF_ID_REGISTER = new Register(Utilities.intToByteArray(0));
        ID_EX_REGISTER = new Register(Utilities.intToByteArray(0));
        EX_MEM_REGISTER = new Register(Utilities.intToByteArray(0));
        EX_WB_REGISTER = new Register(Utilities.intToByteArray(0));


        return true;
    }

}
