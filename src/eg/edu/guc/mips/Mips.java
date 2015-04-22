package eg.edu.guc.mips;


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
    public String fetch() {
        String instruction = instructions[Components.getPC()];
        Components.incrementPC();
        return instruction;
    }


}
