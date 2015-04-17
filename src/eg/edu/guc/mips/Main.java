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
    private static Hashtable<String, Instruction> nameInstruction;

    public static void main(String[] args) {
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
        String instructionsDataPath = "src/eg/edu/guc/data/instructions.csv";
        File file = new File(instructionsDataPath);
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] info = line.split(",");
                Instruction instruction = null;
                String instName = info[0];
                char instType = info[1].charAt(0);
                byte opcode = Byte.parseByte(info[2], 16);
                String funcode = info[3];
                switch (instType) {
                    case 'R':
                        instruction = new RFormatInstruction(Instruction.State.IF, opcode, null, null, null, (byte) 0, Byte.parseByte(funcode, 16));
                        break;
                    case 'I':
                        instruction = new IFormatInstruction(Instruction.State.IF, opcode, null, null, (short) 0);
                        break;
                    case 'J':
                        instruction = new JFormatInstruction(Instruction.State.IF, opcode, 0);
                        break;
                    default:
                        System.err.println("Unkown Instruction type '" + instType + "'");
                }
                nameInstruction.put(instName, instruction);
            }
        } catch (FileNotFoundException e) {
            System.out.println("wrong file path");
        } catch (IOException e) {
            System.out.println("you have reached the ending of the file");
        }
    }

    private static Instruction parse(String line) {
        //TODO implement the parse function here :D
        return null;
    }

}
