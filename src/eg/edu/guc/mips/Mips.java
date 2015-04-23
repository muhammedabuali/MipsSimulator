package eg.edu.guc.mips;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import eg.edu.guc.registers.IFIDRegister;
import eg.edu.guc.utils.Utilities;

public class Mips {
	private ArrayList<String> instructions;
	private ArrayList<String[]> parsedInstrutions;

	/**
	 * Reading a file containing a mips instructions
	 *
	 * @param file
	 * @throws IOException
	 */
	private void readProgram(File file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		instructions = new ArrayList<String>();
		String line;
		while ((line = reader.readLine()) != null)
			instructions.add(line);
		reader.close();
		parsedInstrutions = Parser.parseInstructions(instructions);
	}

	/**
	 * Fetching an instruction from the loaded instructions
	 */
	public int fetch() {
		int instruction = getInstructionBitStream(instructions.get(Components
				.getPC()));

		IFIDRegister.setInstruction(instruction);
		IFIDRegister.setPc(Components.incrementPC());

		return instruction;
	}

	/**
	 * Converting an instruction to equivalent bits
	 * 
	 * @param instructionaa
	 * @return
	 */
	public int getInstructionBitStream(String[] instruction) {
		// TODO Convert instruction to the appropriate bitstream
		String[] instructionData = Utilities
				.getInstructionDataByName(instruction[0].toString());

		String instName = instructionData[0];
		String instType = instructionData[1];
		String instOpCode = instructionData[2];
		String instFunCode = instructionData[3];

		if (instType.equals("R")) {
			return getRInstructionBitStream(instName, instOpCode, instFunCode,
					instruction[1].toString(), instruction[2].toString(),
					instruction[3].toString());
		} else if (instType.equals("I")) {
			return getIInstructionBitStream(instName, instOpCode,
					instruction[1].toString(), instruction[2].toString(),
					instruction.length == 4 ? instruction[3].toString() : "");
		} else if (instType.equals("J")) {
			return getJInstructionBitStream(instName, instOpCode,
					instruction[1].toString());
		}

		return -1;
	}

	private Object[] removeSeprators(String[] splitted) {
		LinkedList<String> res = new LinkedList<String>();
		for (String curr : splitted)
			if (!curr.isEmpty() && curr.charAt(0) != ' ')
				res.add(curr);

		return res.toArray();
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
			String instFunctionCode, String destReg, String srcReg,
			String targetReg) {
		int opCode = Integer.parseInt(instOpCode, 16);
		int funCode = Integer.parseInt(instFunctionCode, 16);
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
			String targetReg, String srcReg, String immediate) {
		int opCode = Integer.parseInt(instOpCode, 16);
		int targetRegNum = Utilities.getRegisterByName(targetReg).getNumber();
		int srcRegNum = 0;
		int constant = 0;
		if (immediate.length() > 0) {
			srcRegNum = Utilities.getRegisterByName(srcReg).getNumber();
			constant = Integer.parseInt(immediate);
		} else {
			// lw or sw or lb or sb
			constant = Integer
					.parseInt(srcReg.substring(0, srcReg.indexOf('(')));
			srcReg = srcReg.substring(srcReg.indexOf("(") + 1,
					srcReg.indexOf(")"));
			srcRegNum = Integer.parseInt(srcReg);
		}
		return (opCode << 26) | (srcRegNum << 21) | (targetRegNum << 16)
				| (constant);
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
		int opCode = Integer.parseInt(instOpCode, 16);
		int constant = Utilities.getLabelNumber(target);
		return (opCode << 26) | (constant);
	}

}
