package eg.edu.guc.mips;

import java.util.ArrayList;
import java.util.LinkedList;

import eg.edu.guc.utils.Utilities;

public class Parser {
	/**
	 * modifies the given list by removing all the labels and inserting them
	 * into the hashtable
	 * 
	 * @param instructions
	 * @return
	 */
	public static ArrayList<String[]> parseInstructions(
			ArrayList<String> instructions) {
		int line = 0;
		ArrayList<String[]> res = new ArrayList<String[]>();
		for (String currInstruction : instructions) {
			res.add(parseInstruction(currInstruction, line));
			line++;
		}
		return res;
	}

	public static String[] parseInstruction(String currInstruction, int line) {
		LinkedList<String> instruction = removeSeprators(currInstruction
				.replace(' ', ',').split(","));
		if (instruction.get(0).endsWith(":")) {
			// this is a label
			Utilities.setLabelNumber(instruction.removeFirst(), line);
		}
		return null;
	}

	private static LinkedList<String> removeSeprators(String[] splitted) {
		LinkedList<String> res = new LinkedList<String>();
		for (String curr : splitted)
			if (!curr.isEmpty() && curr.charAt(0) != ' ')
				res.add(curr);

		return res;
	}
}
