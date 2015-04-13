package eg.edu.guc.mips;

import eg.edu.guc.instructions.Instruction;

import java.io.*;
import java.util.ArrayList;

public class Main {
    private static BufferedReader reader;
    private static String filePath = "src/eg/edu/guc/programFiles/test1.txt";
    private static ArrayList<Instruction> inMipsInstructions;

    public static void main(String[] args) {
        //read the file
        File file = new File(filePath);
        try {
            reader = new BufferedReader(new FileReader(file));
            String line ;
            while ((line = reader.readLine()) != null || !inMipsInstructions.isEmpty())
            {
                inMipsInstructions.add(parse(line));//initial state is IF ... abd unstarted state is removed
                for (int i = 0; i < inMipsInstructions.size(); i++)
                {
                    inMipsInstructions.get(i).execute();
                    if(inMipsInstructions.get(i).advanceState() == Instruction.State.FINISHED)
                        inMipsInstructions.remove(i);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("wrong file path");
        } catch (IOException e) {
            System.out.println("you have reached the ending of the file");
        }
    }

    private static Instruction parse(String line) {
        //TODO implement the parse function here :D
        return  null;
    }

}
