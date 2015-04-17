package eg.edu.guc.mips;

import eg.edu.guc.instructions.IFormatInstruction;
import eg.edu.guc.instructions.Instruction;
import eg.edu.guc.instructions.JFormatInstruction;
import eg.edu.guc.instructions.RFormatInstruction;
import eg.edu.guc.registers.Register;
import eg.edu.guc.registers.RegisterFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;

public class Main {
    private static BufferedReader reader;
    private static String filePath = "src/eg/edu/guc/programFiles/test1.txt";
    private static ArrayList<Instruction> inMipsInstructions;
    private static Hashtable<String, String[]> nameInstruction;

    public static void main(String[] args) {
        readInstructionsData();
        //read the file
        File file = new File(filePath);
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null || !inMipsInstructions.isEmpty()) {
                inMipsInstructions.add(parse(line));//initial state is IF ... abd unstarted state is removed
                for (int i = 0; i < inMipsInstructions.size(); i++) {
                    inMipsInstructions.get(i).execute();
                    if (inMipsInstructions.get(i).advanceState() == Instruction.State.FINISHED)
                        inMipsInstructions.remove(i);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("wrong file path");
        } catch (IOException e) {
            System.out.println("you have reached the ending of the file");
        }
    }

    private static void readInstructionsData() {
        nameInstruction = new Hashtable<String, String[]>();
        String instructionsDataPath = "src/eg/edu/guc/data/instructions.csv";
        File file = new File(instructionsDataPath);
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] info = line.split(",");
                nameInstruction.put(info[0], info);
            }
        } catch (FileNotFoundException e) {
            System.out.println("wrong file path");
        } catch (IOException e) {
            System.out.println("you have reached the ending of the file");
        }
    }

    private static Instruction parse(String line) {
        String[] info = line.split(" ,");
        return null;
    }

}
