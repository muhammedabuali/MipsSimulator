package eg.edu.guc.mips;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import eg.edu.guc.registers.IFIDRegister;
import eg.edu.guc.utils.Utilities;

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

		while ((instructions[line++] = reader.readLine()) != null) {
		}
		reader.close();
	}

	/**
	 * Fetching an instruction from the loaded instructions
	 */
	public int fetch() {
		int instruction = getInstructionBitStream(instructions[Components
				.getPC()]);

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
		// TODO Convert instruction to the appropriate bitstream
		instruction = instruction.replace(',', ' ');
		String[] instructionSplitted = instruction.split(" ");

		String[] instructionData = Utilities
				.getInstructionDataByName(instructionSplitted[0]);

		String instName = instructionData[0];
		String instType = instructionData[1];
		String instOpCode = instructionData[2];
		String instFunCode = instructionData[3];

		if (instType.equals("R")) {
			return getRInstructionBitStream(instName, instOpCode, instFunCode,
					instructionSplitted[1], instructionSplitted[2],
					instructionSplitted[3]);
		} else if (instType.equals("I")) {
			return getIInstructionBitStream(instName, instOpCode, instFunCode,
					instructionSplitted[1], instructionSplitted[2]);
		} else if (instType.equals("J")) {
			return getJInstructionBitStream(instName, instOpCode,
					instructionSplitted[1]);
		}

		return -1;
	}

	/**
	 * retruns Integer that represents the given R Type Instruction
	 * 
	 * 
	 * [B31-26, B25-21, B20-16, B15-11, B10-6, B5-0]
	 *
	 * [opcode, register s, register t, register d, shift amount, function]
	 */
	private int getRInstructionBitStream(String instName, String instOpCode,
			String instFunCode, String destReg, String srcReg, String targetReg) {
		// TODO Auto-generated method stub
		int opCode = Integer.parseInt(instOpCode, 16);
		int funCode = Integer.parseInt(instFunCode, 16);
		int destRegNum = Utilities.getRegisterByName(destReg).getNumber();
		int srcRegNum = Utilities.getRegisterByName(srcReg).getNumber();
		int targetRegNum = 0;
		int shiftamount = 0;
		if (targetReg.charAt(0) == '$') {
			targetRegNum = Utilities.getRegisterByName(targetReg).getNumber();
		} else {
			shiftamount = Integer.parseInt(targetReg, 16);
		}
		return (opCode << 26) | (srcRegNum << 21) | (targetRegNum << 16)
				| (destRegNum << 11) | (shiftamount << 6) | (funCode);
	}

	/**
	 * retruns Integer that represents the given I Type Instruction
	 * 
	 * [B31-26, B25-21, B20-16, B15-0]
	 * 
	 * [opcode, register s, register t, immediate]
	 * 
	 */
	private int getIInstructionBitStream(String instName, String instOpCode,
			String srcReg, String targetReg, String immediate) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * retruns Integer that represents the given J Type Instruction
	 * 
	 * [B31-26, B25-0]
	 * 
	 * [opcode, target]
	 * 
	 */
	private int getJInstructionBitStream(String instName, String instOpCode,
			String target) {
		// TODO Auto-generated method stub
		return 0;
	}

}
