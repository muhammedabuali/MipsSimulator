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
    public static final Register ZERO_REGISTER = new Register(0, 0, "$0");

    // Assembler Temporary
    public static Register AT_REGISTER = new Register(0, 1, "$at");
    // Arguments
    public static Register A0_REGISTER = new Register(0, 4, "$a0");
    public static Register A1_REGISTER = new Register(0, 5, "$a1");
    public static Register A2_REGISTER = new Register(0, 6, "$a2");
    public static Register A3_REGISTER = new Register(0, 7, "$a3");
    // Result
    public static Register V0_REGISTER = new Register(0, 2, "$v0");
    public static Register V1_REGISTER = new Register(0, 3, "$v1");
    // Temp Registers
    public static Register T0_REGISTER = new Register(0, 8, "$t0");
    public static Register T1_REGISTER = new Register(0, 9, "$t1");
    public static Register T2_REGISTER = new Register(0, 10, "$t2");
    public static Register T3_REGISTER = new Register(0, 11, "$t3");
    public static Register T4_REGISTER = new Register(0, 12, "$t4");
    public static Register T5_REGISTER = new Register(0, 13, "$t5");
    public static Register T6_REGISTER = new Register(0, 14, "$t6");
    public static Register T7_REGISTER = new Register(0, 15, "$t7");
    public static Register T8_REGISTER = new Register(0, 24, "$t8");
    public static Register T9_REGISTER = new Register(0, 25, "$t9");
    // Saved Registers
    public static Register S0_REGISTER = new Register(0, 16, "$s0");
    public static Register S1_REGISTER = new Register(0, 17, "$s1");
    public static Register S2_REGISTER = new Register(0, 18, "$s2");
    public static Register S3_REGISTER = new Register(0, 19, "$s3");
    public static Register S4_REGISTER = new Register(0, 20, "$s4");
    public static Register S5_REGISTER = new Register(0, 21, "$s5");
    public static Register S6_REGISTER = new Register(0, 22, "$s6");
    public static Register S7_REGISTER = new Register(0, 23, "$s7");

    public static Register GP_REGISTER = new Register(0, 28, "$gp");
    public static Register SP_REGISTER = new Register(0, 29, "$sp");
    public static Register FP_REGISTER = new Register(0, 30, "$fp");
    public static Register RA_REGISTER = new Register(0, 31, "$ra");


}
