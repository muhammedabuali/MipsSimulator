package eg.edu.guc.registers;

/**
 * Created by kady on 12/04/15.
 * <p/>
 * The register file , containing references to all MIPS processor's registers
 *
 * @author kady
 */
public class RegisterFile {

    // ZERO .. Don't touch !
    public static final Register ZERO = new Register(0);


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
    public static Register R_ID_EX_REGISTER;
    public static Register R_EX_MEM_REGISTER;
    public static Register E_EX_WB_REGISTER;


    public static boolean init() {
        //TODO add implementation and documentation
        return false;
    }

    public static boolean init(Register register, int value) {
        //TODO add implementation and documentation
        return false;
    }

}
