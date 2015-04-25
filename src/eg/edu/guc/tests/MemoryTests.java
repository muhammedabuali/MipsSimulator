package eg.edu.guc.tests;

import eg.edu.guc.memory.Memory;
import eg.edu.guc.registers.RegisterFile;
import eg.edu.guc.utils.Utilities;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by mohamed on 17/04/15.
 */
public class MemoryTests {
    @Test
    public void testGetInstructionNameByOpcodePart() {
        Memory.init();

        Memory.storeWord(50, 147);
        Memory.storeWord(-50, 151);

        Memory.storeWord('c', 160);

        System.out.println(Character.toChars(Memory.loadWord(160)));

        assertTrue("value in address 147 sould be 50", Memory.loadWord(147) == 50);
        assertTrue("value in address 148 sould be -50", Memory.loadWord(151) == -50);



    }
}
