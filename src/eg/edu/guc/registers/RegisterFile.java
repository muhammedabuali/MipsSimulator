package eg.edu.guc.registers;

/**
 * Created by kady on 12/04/15.
 * <p/>
 * The register file , containing references to all MIPS processor's registers
 *
 * @author kady
 */
public class RegisterFile {

	// ZERO_REGISTER .. Don't touch !
	public static final Register ZERO_REGISTER = new Register(0, 0);

	// Assembler Temporary
	public static Register AT_REGISTER;

	// Arguments
	public static Register A0_REGISTER;
	public static Register A1_REGISTER;
	public static Register A2_REGISTER;
	public static Register A3_REGISTER;

	// Result
	public static Register V0_REGISTER;
	public static Register V1_REGISTER;

	// Temp Registers
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

	// Saved Registers
	public static Register S0_REGISTER;
	public static Register S1_REGISTER;
	public static Register S2_REGISTER;
	public static Register S3_REGISTER;
	public static Register S4_REGISTER;
	public static Register S5_REGISTER;
	public static Register S6_REGISTER;
	public static Register S7_REGISTER;

	// Global pointer
	public static Register GP_REGISTER;

	// Stack pointer
	public static Register SP_REGISTER;

	// Frame pointer
	public static Register FP_REGISTER;

	// Return address
	public static Register RA_REGISTER;

	/**
	 * Initializing <strong>All</strong> registers in <code>RegisterFile</code>
	 * to <strong>Zeros</strong>
	 *
	 * @return true if all initialized correctly
	 */
	public static boolean init() {
        AT_REGISTER = new Register(0, 1,"$at");

        A0_REGISTER = new Register(0, 4,"$a0");
        A1_REGISTER = new Register(0, 5,"$a1");
        A2_REGISTER = new Register(0, 6,"$a2");
        A3_REGISTER = new Register(0, 7,"$a3");

        V0_REGISTER = new Register(0, 2,"$v0");
        V1_REGISTER = new Register(0, 3,"$v1");

        T0_REGISTER = new Register(0, 8,"$t0");
        T1_REGISTER = new Register(0, 9,"$t1");
        T2_REGISTER = new Register(0, 10,"$t2");
        T3_REGISTER = new Register(0, 11,"$t3");
        T4_REGISTER = new Register(0, 12,"$t4");
        T5_REGISTER = new Register(0, 13,"$t5");
        T6_REGISTER = new Register(0, 14,"$t6");
        T7_REGISTER = new Register(0, 15,,"$t7");
        T8_REGISTER = new Register(0, 24,"$t8");
        T9_REGISTER = new Register(0, 25,"$t9");

        S0_REGISTER = new Register(0, 16,"$s0");
        S1_REGISTER = new Register(0, 17,"$s1");
        S2_REGISTER = new Register(0, 18,"$s2");
        S3_REGISTER = new Register(0, 19,"$s3");
        S4_REGISTER = new Register(0, 20,"$s4");
        S5_REGISTER = new Register(0, 21,"$s5");
        S6_REGISTER = new Register(0, 22,"$s6");
        S7_REGISTER = new Register(0, 23,"$s7");

        GP_REGISTER = new Register(0, 28,"$gp");
        SP_REGISTER = new Register(0, 29,"$sp");
        FP_REGISTER = new Register(0, 30,"$fp");
        RA_REGISTER = new Register(0, 31,"$ra");

        return true;
    }
}
