package eg.edu.guc.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.SystemColor;

import javax.swing.JFrame;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5878820421093084909L;
	private Color backgroundColor = SystemColor.activeCaption;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		getContentPane().setBackground(backgroundColor);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 550);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 260, 35, 29, 178, 311 };
		gridBagLayout.rowHeights = new int[] { 41, 319, 19, 77, 0 };
		gridBagLayout.columnWeights = new double[] { 0.4, 0.4, 0.0, 0.4, 0.4,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.001, 0.5, 0.0, 0.4,
				Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);
	}

}
