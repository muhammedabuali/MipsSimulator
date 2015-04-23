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
		ArrayList<String[]> res = new ArrayList<String[]>();
		int line = 0;
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
			Utilities.setLabelNumber(instruction.removeFirst(), line);
		}
		String[] res = new String[instruction.size()];
		int i = 0;
		for (String str : instruction)
			res[i++] = str;
		return res;
	}

	private static LinkedList<String> removeSeprators(String[] splitted) {
		LinkedList<String> res = new LinkedList<String>();
		for (String curr : splitted)
			if (!curr.isEmpty() && curr.charAt(0) != ' ')
				res.add(curr);

		return res;
	}
}
