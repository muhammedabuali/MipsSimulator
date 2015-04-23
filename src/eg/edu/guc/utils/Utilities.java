package eg.edu.guc.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

import eg.edu.guc.registers.Register;
import eg.edu.guc.registers.RegisterFile;

public class Utilities {

	public static Register getResgisterByName(String regName) {
		if (Constants.nameRegister == null)
			Constants.initializeNameRegisterHtbl();
		if (Constants.nameRegister.contains(regName))
			return Constants.nameRegister.get(regName);
		System.err.println("Register " + regName
				+ " was not found in the Registers table");
		return null;
	}

	public static String[] getInstructionDataByName(String instName) {
		if (Constants.instructionNameData == null)
			Constants.readInstructionsData();
		if (Constants.instructionNameData.contains(instName))
			return Constants.instructionNameData.get(instName);
		System.err.println("Unknown Instruction " + instName);
		return null;
	}

}
