package eg.edu.guc.mips;


import eg.edu.guc.registers.IFIDRegister;

import java.io.*;

public class Mips {
    private String[] instructions;


    /**
     * Reading a file containing a mips instructions
     *
     * @param file
     * @throws IOException
     */
    private void readProgram(File file) throws IOException {
        int line = 0;
        BufferedReader reader = new BufferedReader(new FileReader(file));

        while ((instructions[line] = reader.readLine()) != null) {
            line++;
        }
    }

    /**
     * Fetching an instruction from the loaded instructions
     */
    public int fetch() {
        int instruction = getInstructionBitStream(instructions[Components.getPC()]);


        IFIDRegister.setInstruction(instruction);
        IFIDRegister.setPc(Components.incrementPC());

        return instruction;
    }

    /**
     * Converting an instruction to equivalent bits
     *
     * @param instruction
     * @return
     */
    private int getInstructionBitStream(String instruction) {
        //TODO Convert instruction to the appropriate bitstream
        return -1;
    }

}
