package eg.edu.guc.gui;

import javax.swing.JLabel;

import eg.edu.guc.registers.IFIDRegister;

public class IFIDLabels {
	public JLabel pc, instruction;

	public IFIDLabels(JLabel pc, JLabel inst) {
		this.pc = pc;
		this.instruction = inst;
	}

	public void reset() {
		pc.setText(IFIDRegister.getPc() + "");
		instruction.setText(Integer.toBinaryString(IFIDRegister
				.getInstruction()) + "");
	}
}
