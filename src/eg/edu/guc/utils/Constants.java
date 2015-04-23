package eg.edu.guc.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

import eg.edu.guc.registers.Register;
import eg.edu.guc.registers.RegisterFile;

public class Constants {
	protected static BufferedReader reader;
	protected static Hashtable<String, String[]> instructionNameData;
	protected static Hashtable<String, Register> nameRegister;

	/**
	 * reads all instructions from csv file and adds them to the htbl
	 * instructions data goes like (name,type,opcode,funcode)
	 */
	protected static void readInstructionsData() {
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
	 * adds each Register in the registerFile class into the nameRegister htbl
	 */
	protected static void initializeNameRegisterHtbl() {
		nameRegister = new Hashtable<String, Register>();

		nameRegister.put("$a0", RegisterFile.A0_REGISTER);
		nameRegister.put("$a1", RegisterFile.A1_REGISTER);
		nameRegister.put("$a2", RegisterFile.A2_REGISTER);
		nameRegister.put("$a3", RegisterFile.A3_REGISTER);

		nameRegister.put("$ra", RegisterFile.RA_REGISTER);
		nameRegister.put("$fp", RegisterFile.FP_REGISTER);

		nameRegister.put("$s0", RegisterFile.S0_REGISTER);
		nameRegister.put("$s1", RegisterFile.S1_REGISTER);
		nameRegister.put("$s2", RegisterFile.S2_REGISTER);
		nameRegister.put("$s3", RegisterFile.S3_REGISTER);
		nameRegister.put("$s4", RegisterFile.S4_REGISTER);
		nameRegister.put("$s5", RegisterFile.S5_REGISTER);
		nameRegister.put("$s6", RegisterFile.S6_REGISTER);
		nameRegister.put("$s7", RegisterFile.S7_REGISTER);

		nameRegister.put("$sp", RegisterFile.SP_REGISTER);
		nameRegister.put("$gp", RegisterFile.GP_REGISTER);

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

}
