package eg.edu.guc.tests;

import eg.edu.guc.instructions.IFormatInstruction;
import eg.edu.guc.instructions.Instruction;
import eg.edu.guc.mips.Main;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by mohamed on 18/04/15.
 */
public class ParserTests {

    @Test
    public void testingParser() {
        Main.initializeNameRegisterHtbl();
        Main.readInstructionsData();
        String inst = "addi $t0, $0, 10";
        Instruction instruction = Main.parse(inst);
        assertTrue("addi instruction should be instance of IFormatInstruction class", instruction instanceof IFormatInstruction);
        assertTrue("opcode for addi instruction should be 8", instruction.getOpcode() == (byte) 8);
    }

}
