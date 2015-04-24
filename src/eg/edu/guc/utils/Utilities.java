package eg.edu.guc.utils;

import eg.edu.guc.registers.Register;

public class Utilities {

	public static Register getRegisterByName(String regName) {
		if (Constants.nameRegister == null)
			Constants.initializeNameRegisterHtbl();
		if (Constants.nameRegister.containsKey(regName))
			return Constants.nameRegister.get(regName);
		System.err.println("Register " + regName
				+ " was not found in the Registers table");
		return null;
	}

	public static Register getRegisterByNumber(int regNum) {
		if (Constants.numberRegister == null)
			Constants.initializeNumberRegisterHtbl();
		if (Constants.numberRegister.containsKey(regNum))
			return Constants.numberRegister.get(regNum);
		System.err.println("Register number " + regNum
				+ " was not found in the Registers table");
		return null;
	}

	public static String[] getInstructionDataByName(String instName) {
		if (Constants.instructionNameData == null)
			Constants.readInstructionsData();
		if (Constants.instructionNameData.containsKey(instName))
			return Constants.instructionNameData.get(instName);
		System.err.println("Unknown Instruction " + instName);
		return null;
	}

	public static int getLabelNumber(String label) {
		// TODO Auto-generated method stub
		if (Constants.labelNameNumber.containsKey(label))
			return Constants.labelNameNumber.get(label);
		System.err.println("Label name " + label
				+ " was not found in the table");
		return -1;
	}
	public static int getSubset(int originalNumber,int start , int end)//some one please recheck the logic
	{
		int mask = 0;
		for (int i = start; i <= end ; i++) {
			mask += Math.pow(2,i);
		}
		return (originalNumber & mask) >> start;
	}
	public static void setLabelNumber(String label, int number) {
		Constants.labelNameNumber.put(label, number);
	}

}
