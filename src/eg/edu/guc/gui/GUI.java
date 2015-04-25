package eg.edu.guc.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import eg.edu.guc.mips.Mips;
import eg.edu.guc.registers.Register;
import eg.edu.guc.utils.Utilities;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5878820421093084909L;
	private Color backgroundColor = SystemColor.activeCaption;

	private Mips mips = new Mips();
	private Register[] registers = Utilities.getRegistersArray();
	private JLabel[][] registerValueLabels;

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

		initButtons();
		initPipelinedRegistersPanel();
		initRegistersPanel();
		initCodeArea();
		initConsoleArea();
	}

	private void initButtons() {
		JPanel btnsPanel = new JPanel();
		btnsPanel.setBackground(backgroundColor);
		GridBagConstraints gbc_btnsPanel = new GridBagConstraints();
		gbc_btnsPanel.insets = new Insets(5, 5, 5, 5);
		gbc_btnsPanel.fill = GridBagConstraints.BOTH;
		gbc_btnsPanel.gridwidth = 2;
		gbc_btnsPanel.gridx = 0;
		gbc_btnsPanel.gridy = 0;
		getContentPane().add(btnsPanel, gbc_btnsPanel);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 73, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.3, 0.3, 0.3, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.2, 0.2 };
		btnsPanel.setLayout(gbl_panel_1);

		JButton compileBtn = new JButton("   Compile  ");
		compileBtn.setFocusable(false);
		compileBtn.setForeground(SystemColor.inactiveCaptionBorder);
		compileBtn.setBackground(new Color(46, 139, 87));
		GridBagConstraints gbc_compileBtn = new GridBagConstraints();
		gbc_compileBtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_compileBtn.anchor = GridBagConstraints.NORTH;
		gbc_compileBtn.insets = new Insets(5, 5, 5, 5);
		gbc_compileBtn.gridx = 0;
		gbc_compileBtn.gridy = 0;
		btnsPanel.add(compileBtn, gbc_compileBtn);

		JButton runBtn = new JButton("    Run    ");
		runBtn.setFocusable(false);
		runBtn.setForeground(SystemColor.window);
		runBtn.setBackground(new Color(46, 139, 87));
		GridBagConstraints gbc_runBtn = new GridBagConstraints();
		gbc_runBtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_runBtn.insets = new Insets(5, 5, 5, 5);
		gbc_runBtn.gridx = 1;
		gbc_runBtn.gridy = 0;
		btnsPanel.add(runBtn, gbc_runBtn);

		JButton debugBtn = new JButton("    Debug   ");
		debugBtn.setFocusable(false);
		debugBtn.setBackground(SystemColor.controlDkShadow);
		GridBagConstraints gbc_debugBtn = new GridBagConstraints();
		gbc_debugBtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_debugBtn.insets = new Insets(5, 5, 5, 5);
		gbc_debugBtn.gridx = 2;
		gbc_debugBtn.gridy = 0;
		btnsPanel.add(debugBtn, gbc_debugBtn);
	}

	private void initPipelinedRegistersPanel() {
		JPanel pipelinedPanel = new JPanel();
		GridBagConstraints gbc_pipelinedPanel = new GridBagConstraints();
		gbc_pipelinedPanel.insets = new Insets(5, 5, 5, 5);
		gbc_pipelinedPanel.fill = GridBagConstraints.BOTH;
		gbc_pipelinedPanel.gridheight = 4;
		gbc_pipelinedPanel.gridx = 3;
		gbc_pipelinedPanel.gridy = 0;
		getContentPane().add(pipelinedPanel, gbc_pipelinedPanel);
	}

	private void initRegistersPanel() {
		JPanel registersPanel = new JPanel();
		registersPanel.setOpaque(true);
		registersPanel.setBackground(Color.black);
		GridBagConstraints gbc_registersPanel = new GridBagConstraints();
		gbc_registersPanel.insets = new Insets(5, 5, 5, 0);
		gbc_registersPanel.fill = GridBagConstraints.BOTH;
		gbc_registersPanel.gridheight = 4;
		gbc_registersPanel.gridx = 4;
		gbc_registersPanel.gridy = 0;
		getContentPane().add(registersPanel, gbc_registersPanel);
		registersPanel.setLayout(new GridLayout(0, 4, 1, 0));

		JPanel regNumsPanel = new JPanel();
		registersPanel.add(regNumsPanel);
		regNumsPanel.setLayout(new GridLayout(31, 0, 0, 1));

		JLabel numLabel = new JLabel("RegNumber");
		numLabel.setHorizontalAlignment(SwingConstants.CENTER);
		regNumsPanel.add(numLabel);

		JPanel regNamesPanel = new JPanel();
		registersPanel.add(regNamesPanel);
		regNamesPanel.setLayout(new GridLayout(31, 0, 0, 1));

		JLabel regLabel = new JLabel("RegName");
		regLabel.setHorizontalAlignment(SwingConstants.CENTER);
		regNamesPanel.add(regLabel);

		JPanel regDecPanel = new JPanel();
		registersPanel.add(regDecPanel);
		regDecPanel.setLayout(new GridLayout(31, 0, 0, 1));

		JLabel decLabel = new JLabel("DEC");
		decLabel.setHorizontalAlignment(SwingConstants.CENTER);
		regDecPanel.add(decLabel);

		JPanel regHexPanel = new JPanel();
		registersPanel.add(regHexPanel);
		regHexPanel.setLayout(new GridLayout(31, 0, 0, 1));

		JLabel hexLabel = new JLabel("HEX");
		hexLabel.setHorizontalAlignment(SwingConstants.CENTER);
		regHexPanel.add(hexLabel);

		registerValueLabels = new JLabel[2][32];
		for (int i = 0; i < 32; i++) {
			Register register = registers[i];
			if (register != null) {
				JLabel name = new JLabel(register.getName());
				name.setBackground(Color.gray);
				name.setForeground(Color.yellow);
				name.setOpaque(true);
				regNamesPanel.add(name);
				name.setHorizontalAlignment(SwingConstants.CENTER);
				JLabel num = new JLabel(register.getNumber() + "");
				num.setBackground(Color.gray);
				num.setOpaque(true);
				num.setHorizontalAlignment(SwingConstants.CENTER);
				regNumsPanel.add(num);
				JLabel dec = new JLabel(register.getData() + "");
				dec.setBackground(Color.gray);
				dec.setOpaque(true);
				dec.setHorizontalAlignment(SwingConstants.CENTER);
				regDecPanel.add(dec);
				JLabel hex = new JLabel(Integer.toHexString(register.getData())
						+ "");
				hex.setOpaque(true);
				hex.setBackground(Color.gray);
				hex.setHorizontalAlignment(SwingConstants.CENTER);
				regHexPanel.add(hex);
				registerValueLabels[0][i] = dec;
				registerValueLabels[1][i] = hex;
			}
		}
	}

	private void updateRegistersValues() {
		for (int i = 0; i < 32; i++) {
			if (registers[i] == null)
				continue;
			registerValueLabels[0][i].setText(registers[i].getData() + "1");
			registerValueLabels[1][i].setText(Integer.toHexString(registers[i]
					.getData()) + "");
		}
	}

	private void initCodeArea() {
		JScrollPane scrollPaneCode = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(5, 5, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		JTextArea codeTextArea = new JTextArea();
		codeTextArea.setFont(new Font("Times New Roman", Font.BOLD, 15));
		scrollPaneCode.setViewportView(codeTextArea);
		getContentPane().add(scrollPaneCode, gbc_scrollPane);
	}

	private void initConsoleArea() {
		JLabel lblConsole = new JLabel("    Console:");
		GridBagConstraints gbc_lblConsole = new GridBagConstraints();
		gbc_lblConsole.fill = GridBagConstraints.BOTH;
		gbc_lblConsole.insets = new Insets(0, 0, 5, 5);
		gbc_lblConsole.gridx = 0;
		gbc_lblConsole.gridy = 2;
		getContentPane().add(lblConsole, gbc_lblConsole);

		JScrollPane scrollPaneConsole = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(5, 5, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridwidth = 3;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 3;
		JTextArea consoleTextArea = new JTextArea();
		consoleTextArea.setEditable(false);
		scrollPaneConsole.setViewportView(consoleTextArea);
		getContentPane().add(scrollPaneConsole, gbc_scrollPane_1);

	}

}
