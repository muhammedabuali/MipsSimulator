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
        init(A0_REGISTER, 0);
        init(A1_REGISTER, 0);
        init(A2_REGISTER, 0);
        init(A3_REGISTER, 0);

        init(V0_REGISTER, 0);
        init(V1_REGISTER, 0);

        init(T0_REGISTER, 0);
        init(T1_REGISTER, 0);
        init(T2_REGISTER, 0);
        init(T3_REGISTER, 0);
        init(T4_REGISTER, 0);
        init(T5_REGISTER, 0);
        init(T6_REGISTER, 0);
        init(T7_REGISTER, 0);
        init(T8_REGISTER, 0);
        init(T9_REGISTER, 0);

        init(S0_REGISTER, 0);
        init(S1_REGISTER, 0);
        init(S2_REGISTER, 0);
        init(S3_REGISTER, 0);
        init(S4_REGISTER, 0);
        init(S5_REGISTER, 0);
        init(S6_REGISTER, 0);
        init(S7_REGISTER, 0);

        init(GP_REGISTER, 0);
        init(SP_REGISTER, 0);
        init(FP_REGISTER, 0);
        init(RA_REGISTER, 0);

        init(IF_ID_REGISTER, 0);
        init(ID_EX_REGISTER, 0);
        init(EX_MEM_REGISTER, 0);
        init(EX_WB_REGISTER, 0);


        return true;
    }

    /**
     * Initializing a specific register with a value
     *
     * @param register
     * @param value
     * @return a reference of the initialized register
     */
    public static Register init(Register register, int value) {
        register = new Register(Utilities.intToByteArray(value));
        return register;
    }

}
