package eg.edu.guc.tests;

import eg.edu.guc.mips.Mips;
import eg.edu.guc.registers.Register;
import eg.edu.guc.registers.RegisterFile;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kady on 25/04/15.
 *
 * @author kady
 */
public class SimulatorTests {
    @Test
    public void testNormalProgram() {
        Mips mipo = new Mips("program_files/test1.txt");
        mipo.run();

        System.out.println(RegisterFile.T0_REGISTER.getData());
        System.out.println(RegisterFile.T1_REGISTER.getData());
        System.out.println(RegisterFile.T2_REGISTER.getData());
    }
}
