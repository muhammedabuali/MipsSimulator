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
    private static Hashtable<String, String[]> instructionNameData;
    private static Hashtable<String, Register> nameRegister;

    public static void main(String[] args) {
        initializeNameRegisterHtbl();
        readInstructionsData();
        inMipsInstructions = new ArrayList<>();
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

    public static void readInstructionsData() {
        instructionNameData = new Hashtable<String, String[]>();
        String instructionsDataPath = "src/eg/edu/guc/data/instructions.csv";
        File file = new File(instructionsDataPath);
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] info = line.split(",");
                instructionNameData.put(info[0], info);
            }
        } catch (FileNotFoundException e) {
            System.out.println("wrong file path");
        } catch (IOException e) {
            System.out.println("you have reached the ending of the file");
        }
    }

    /**
     * adds each Register in the registerFile class into the nameRegister hash table
     */
    public static void initializeNameRegisterHtbl() {
        nameRegister = new Hashtable<String, Register>();

        RegisterFile.init();

        nameRegister.put("$a0", RegisterFile.A0_REGISTER);
        nameRegister.put("$a1", RegisterFile.A1_REGISTER);
        nameRegister.put("$a2", RegisterFile.A2_REGISTER);
        nameRegister.put("$a3", RegisterFile.A3_REGISTER);

        nameRegister.put("$ra", RegisterFile.RA_REGISTER);

        nameRegister.put("$s0", RegisterFile.S0_REGISTER);
        nameRegister.put("$s1", RegisterFile.S1_REGISTER);
        nameRegister.put("$s2", RegisterFile.S2_REGISTER);
        nameRegister.put("$s3", RegisterFile.S3_REGISTER);
        nameRegister.put("$s4", RegisterFile.S4_REGISTER);
        nameRegister.put("$s5", RegisterFile.S5_REGISTER);
        nameRegister.put("$s6", RegisterFile.S6_REGISTER);
        nameRegister.put("$s7", RegisterFile.S7_REGISTER);

        nameRegister.put("$sp", RegisterFile.SP_REGISTER);

        nameRegister.put("$0", RegisterFile.ZERO_REGISTER);

        nameRegister.put("$v0", RegisterFile.V0_REGISTER);
        nameRegister.put("$v1", RegisterFile.V1_REGISTER);

        nameRegister.put("$t0", RegisterFile.T0_REGISTER);
        nameRegister.put("$t1", RegisterFile.T1_REGISTER);
        nameRegister.put("$t2", RegisterFile.T2_REGISTER);
        nameRegister.put("$t3", RegisterFile.T3_REGISTER);
        nameRegister.put("$t4", RegisterFile.T4_REGISTER);
        nameRegister.put("$t5", RegisterFile.T5_REGISTER);
        nameRegister.put("$t6", RegisterFile.T6_REGISTER);
        nameRegister.put("$t7", RegisterFile.T7_REGISTER);
        nameRegister.put("$t8", RegisterFile.T8_REGISTER);
        nameRegister.put("$t9", RegisterFile.T9_REGISTER);
    }

    public static Instruction parse(String line) {
        String[] splitted = line.split(" ,");
        if (splitted.length < 3) {
            System.err.println("Syntax Error");
            return null;
        }
        String[] info = instructionNameData.get(splitted[0]);
        Instruction instruction = null;
        char instType = info[1].charAt(0);
        byte opcode = Byte.parseByte(info[2], 16);
        String funcode = info[3];
        Register dstReg, srcReg, targetReg;
        switch (instType) {
            case 'R':
                dstReg = getRegisterByName(splitted[1]);
                srcReg = getRegisterByName(splitted[2]);
                targetReg = splitted[3].charAt(0) == '$' ? getRegisterByName(splitted[3]) : null;
                byte shiftAmount = splitted[3].charAt(0) == '$' ? (byte) 0 : Byte.parseByte(splitted[3]);
                instruction = new RFormatInstruction(Instruction.State.IF, opcode, srcReg, dstReg, targetReg, shiftAmount, Byte.parseByte(funcode, 16));
                break;
            case 'I':
                srcReg = getRegisterByName(splitted[1]);
                targetReg = getRegisterByName(splitted[2]);
                short constAddressHolder = Short.parseShort(splitted[3]);
                instruction = new IFormatInstruction(Instruction.State.IF, opcode, srcReg, targetReg, constAddressHolder);
                break;
            case 'J':
                instruction = new JFormatInstruction(Instruction.State.IF, opcode, Integer.parseInt(splitted[1]));
                break;
            default:
                System.err.println("Unkown Instruction type '" + info[1] + "'");
        }
        return instruction;
    }

    /**
     * returns the register corresponding to the given register name ,
     * prints an error if register name is invalid
     *
     * @param regName
     * @return
     */
    private static Register getRegisterByName(String regName) {
        if (!regName.contains(regName)) {
            System.err.println("Syntax Error, Unknown Register Name " + regName);
            return null;
        }
        return nameRegister.get(regName);
    }

}
