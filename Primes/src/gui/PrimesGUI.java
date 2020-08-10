package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import primes.PrimesProgram;
import primes.PrimesProgram.ProgramMode;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * Graphical User Interface for checking primes.
 * Contains fields for input and output.
 * You're able to check if a number is a prime 
 * or you can find primes between two integers.
 * @author Monjin
 * @version 1.1, 17.7.2014
 * @version 1.2 16.10.2014
 */
public class PrimesGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField startNumber;
	private JTextField endNumber;
	private JButton findButton;
	private JPanel panel_2;
	private JTextField oneNumber;
	private JButton checkButton;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextArea resultArea;
	private JButton btnExit;
	private JLabel label;
	private JLabel label_1;
	private JMenuBar menuBar;
	private JMenu mnHelp;
	private JMenuItem mntmInformation;
	private JMenuItem mntmHelp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimesGUI frame = new PrimesGUI();
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
	public PrimesGUI() {
		setTitle("Primes");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 400);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnHelp = new JMenu("Help?");
		menuBar.add(mnHelp);
		
		mntmInformation = new JMenuItem("Information");
		
		/**
		 * 
		 */
		mntmInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(PrimesGUI.this,
						"Graphical User Interface for checking primes.\n" +
						"Contains fields for input and output.\n" +
						"You're able to check if a number is a prime \n" +
						"or you can find primes between two integers.\n\n" +
						"created by Petri Monola\n" +
						"version 1.2, 16.10.2014 ",
						"Information", JOptionPane.PLAIN_MESSAGE);
			}
		});
		mnHelp.add(mntmInformation);
		
		mntmHelp = new JMenuItem("How to use");
		mntmHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(PrimesGUI.this,
						"Search for prime numbers between\n"
						+"two numbers by inserting the number,\n"
						+ "from which you want to start, under the\n"
						+ "field where it says 'starting number'.\n"
						+ "Insert the number, to which you want\n"
						+ "the search to end, under the field where\n"
						+ "it says 'ending number' and the press\n "
						+ "'Find primes!'\n"
						+ "To check a single primes primality,\n"
						+ "input the number under 'Single prime'\n"
						+ "and press 'Check prime!'.\n\n"
						+ "Negative numbers are not accepted.\n"
						+ "Inputs are for integers only.\n" 
						+ "Other symbols besides numbers are not acceptable.\n\n"
						+ "Try to search a small amount of numbers at one time\n"
						+ "instead of searching, for example, between\n"
						+ "one and a hundred million. That way the\n"
						+ "program stays fast.\n\n"
						+ "Enjoy!",
						"Help", JOptionPane.PLAIN_MESSAGE);
			}
		});
		mnHelp.add(mntmHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		resultArea = new JTextArea();
		resultArea.setEditable(false);
		scrollPane.setViewportView(resultArea);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{95, 0};
		gbl_panel_1.rowHeights = new int[]{27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		lblNewLabel_1 = new JLabel("Starting number:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		startNumber = new JTextField();
		GridBagConstraints gbc_startNumber = new GridBagConstraints();
		gbc_startNumber.fill = GridBagConstraints.BOTH;
		gbc_startNumber.insets = new Insets(0, 0, 5, 0);
		gbc_startNumber.gridx = 0;
		gbc_startNumber.gridy = 1;
		panel_1.add(startNumber, gbc_startNumber);
		startNumber.setColumns(10);
		
		lblNewLabel = new JLabel("Ending number:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		endNumber = new JTextField();
		GridBagConstraints gbc_endNumber = new GridBagConstraints();
		gbc_endNumber.fill = GridBagConstraints.BOTH;
		gbc_endNumber.insets = new Insets(0, 0, 5, 0);
		gbc_endNumber.gridx = 0;
		gbc_endNumber.gridy = 3;
		panel_1.add(endNumber, gbc_endNumber);
		endNumber.setColumns(10);
		
		findButton = new JButton("Find primes!");
		
		/**
		 * When find button is pressed, this starts finding operation.
		 */
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PrimesProgram pp = new PrimesProgram(ProgramMode.FIND_PRIMES);
				pp.setResultArea(resultArea);
				pp.setFindPrimesRange(startNumber.getText(), endNumber.getText());
				Thread thread = new Thread(pp);
				thread.start();
			}
		});
		GridBagConstraints gbc_findButton = new GridBagConstraints();
		gbc_findButton.fill = GridBagConstraints.BOTH;
		gbc_findButton.insets = new Insets(0, 0, 5, 0);
		gbc_findButton.gridx = 0;
		gbc_findButton.gridy = 4;
		panel_1.add(findButton, gbc_findButton);
		
		label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 5;
		panel_1.add(label, gbc_label);
		
		lblNewLabel_2 = new JLabel("Single prime:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 6;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		oneNumber = new JTextField();
		GridBagConstraints gbc_oneNumber = new GridBagConstraints();
		gbc_oneNumber.fill = GridBagConstraints.BOTH;
		gbc_oneNumber.insets = new Insets(0, 0, 5, 0);
		gbc_oneNumber.gridx = 0;
		gbc_oneNumber.gridy = 7;
		panel_1.add(oneNumber, gbc_oneNumber);
		oneNumber.setColumns(10);
		
		checkButton = new JButton("Check prime!");
		GridBagConstraints gbc_checkButton = new GridBagConstraints();
		gbc_checkButton.fill = GridBagConstraints.BOTH;
		gbc_checkButton.insets = new Insets(0, 0, 5, 0);
		gbc_checkButton.gridx = 0;
		gbc_checkButton.gridy = 8;
		panel_1.add(checkButton, gbc_checkButton);
		
		/**
		 * When single prime check -button is pressed, this starts the
		 * checking operation.
		 */
		checkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PrimesProgram pp = new PrimesProgram(ProgramMode.SINGLE_PRIME);
				pp.setResultArea(resultArea);
				Thread thread = new Thread(pp);
				thread.start();
			}
		});
		
		label_1 = new JLabel("");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.fill = GridBagConstraints.BOTH;
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 9;
		panel_1.add(label_1, gbc_label_1);
		
		btnExit = new JButton("Exit");
		
		/**
		 * When exit is pressed, program will close.
		 */
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.anchor = GridBagConstraints.NORTH;
		gbc_btnExit.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnExit.gridx = 0;
		gbc_btnExit.gridy = 11;
		panel_1.add(btnExit, gbc_btnExit);
		
		panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.EAST);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
	}

}
