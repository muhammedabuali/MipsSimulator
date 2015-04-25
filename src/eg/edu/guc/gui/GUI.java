package eg.edu.guc.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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

		initButtons();
		initPipelinedRegistersPanel();
		initRegistersPanel();
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
		GridBagConstraints gbc_registersPanel = new GridBagConstraints();
		gbc_registersPanel.insets = new Insets(5, 5, 5, 0);
		gbc_registersPanel.fill = GridBagConstraints.BOTH;
		gbc_registersPanel.gridheight = 4;
		gbc_registersPanel.gridx = 4;
		gbc_registersPanel.gridy = 0;
		getContentPane().add(registersPanel, gbc_registersPanel);
		registersPanel.setLayout(new GridLayout(0, 3, 0, 0));

		JPanel regNamesPanel = new JPanel();
		registersPanel.add(regNamesPanel);
		regNamesPanel.setLayout(new GridLayout(33, 0, 0, 0));

		JLabel regLabel = new JLabel("Register");
		regLabel.setHorizontalAlignment(SwingConstants.CENTER);
		regNamesPanel.add(regLabel);

		JPanel regNumsPanel = new JPanel();
		registersPanel.add(regNumsPanel);
		regNumsPanel.setLayout(new GridLayout(33, 0, 0, 0));

		JLabel numLabel = new JLabel("Number");
		numLabel.setHorizontalAlignment(SwingConstants.CENTER);
		regNumsPanel.add(numLabel);

		JPanel regValsPanel = new JPanel();
		registersPanel.add(regValsPanel);
		regValsPanel.setLayout(new GridLayout(33, 0, 0, 0));

		JLabel valLabel = new JLabel("Value");
		valLabel.setHorizontalAlignment(SwingConstants.CENTER);
		regValsPanel.add(valLabel);
	}


}
