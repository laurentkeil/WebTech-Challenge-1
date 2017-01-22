package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import main.FunctionalityFour;
import main.FunctionalityOne;
import main.FunctionalityThree;
import main.FunctionalityTwo;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame mainPanel;
	private JPanel contentPanel;

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 133, -73, 0 };
		gridBagLayout.rowHeights = new int[] { 20, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 4.9E-324 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		mainPanel.getContentPane().setLayout(gridBagLayout);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		gbc_panel.gridwidth = 3;
		mainPanel.getContentPane().add(panel, gbc_panel);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 2;
		gbc_panel_1.weighty = 9.0;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridy = 1;
		mainPanel.getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JButton btnAccueil_1 = new JButton("Home");
		btnAccueil_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setToAccueil();
			}
		});
		GridBagConstraints gbc_btnAccueil_1 = new GridBagConstraints();
		gbc_btnAccueil_1.fill = GridBagConstraints.BOTH;
		gbc_btnAccueil_1.insets = new Insets(3, 3, 5, 3);
		gbc_btnAccueil_1.gridx = 0;
		gbc_btnAccueil_1.gridy = 0;
		panel_1.add(btnAccueil_1, gbc_btnAccueil_1);

		JButton btnFct1 = new JButton("Functionality 1");
		btnFct1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setToFunctionnality(1);
			}
		});
		GridBagConstraints gbc_btnFct1 = new GridBagConstraints();
		gbc_btnFct1.fill = GridBagConstraints.BOTH;
		gbc_btnFct1.insets = new Insets(0, 3, 5, 3);
		gbc_btnFct1.weightx = 1.0;
		gbc_btnFct1.gridx = 0;
		gbc_btnFct1.gridy = 1;
		panel_1.add(btnFct1, gbc_btnFct1);

		JButton btnFct2 = new JButton("Functionality 2");
		btnFct2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setToFunctionnality(2);
			}
		});
		GridBagConstraints gbc_btnFct2 = new GridBagConstraints();
		gbc_btnFct2.insets = new Insets(0, 3, 5, 3);
		gbc_btnFct2.fill = GridBagConstraints.BOTH;
		gbc_btnFct2.gridx = 0;
		gbc_btnFct2.gridy = 2;
		panel_1.add(btnFct2, gbc_btnFct2);

		JButton btnFct3 = new JButton("Functionality 3");
		btnFct3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setToFunctionnality(3);
			}
		});
		GridBagConstraints gbc_btnFct3 = new GridBagConstraints();
		gbc_btnFct3.insets = new Insets(0, 3, 5, 3);
		gbc_btnFct3.fill = GridBagConstraints.BOTH;
		gbc_btnFct3.gridx = 0;
		gbc_btnFct3.gridy = 3;
		panel_1.add(btnFct3, gbc_btnFct3);

		JButton btnFct4 = new JButton("Functionality 4");
		btnFct4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setToFunctionnality(4);
			}
		});
		GridBagConstraints gbc_btnFct4 = new GridBagConstraints();
		gbc_btnFct4.insets = new Insets(0, 3, 5, 3);
		gbc_btnFct4.fill = GridBagConstraints.BOTH;
		gbc_btnFct4.gridx = 0;
		gbc_btnFct4.gridy = 4;
		panel_1.add(btnFct4, gbc_btnFct4);

		contentPanel = new JPanel();
		contentPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		contentPanel.setForeground(Color.BLACK);
		contentPanel.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridheight = 2;
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 1;
		gbc_panel_2.weightx = 8.0;
		gbc_panel_2.insets = new Insets(3, 3, 10, 50);

		mainPanel.getContentPane().add(contentPanel, gbc_panel_2);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0 };
		gbl_contentPanel.rowHeights = new int[] { 0 };
		gbl_contentPanel.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		setToAccueil();
		mainPanel.getContentPane().revalidate();
	}

	public void setToAccueil() {
		contentPanel.removeAll();
		JTextPane txtpnBienvenue = new JTextPane();
		txtpnBienvenue.setBorder(new EtchedBorder(EtchedBorder.RAISED, null,
				null));
		txtpnBienvenue.setBackground(new Color(245, 245, 245));
		txtpnBienvenue
				.setText("\r\n			Welcome	\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n	          2015 - University of Namur - Computer Science Faculty		\r\n");
		txtpnBienvenue.setEditable(false);
		contentPanel.add(txtpnBienvenue);
		contentPanel.revalidate();
		contentPanel.repaint();
	}

	public void setToFunctionnality(int funcNumber) {
		contentPanel.removeAll();

		GridBagConstraints gbc_btnAction = new GridBagConstraints();
		gbc_btnAction.fill = GridBagConstraints.NONE;
		gbc_btnAction.gridy = 0;
		gbc_btnAction.gridwidth = GridBagConstraints.REMAINDER;
		gbc_btnAction.weightx = 1.0;
		gbc_btnAction.anchor = GridBagConstraints.NORTHWEST;
		
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 1;
		gbc_textArea.gridwidth = GridBagConstraints.REMAINDER;
		gbc_textArea.weightx = 1.0;
		gbc_textArea.weighty = 1.0;


		String[] queries = { "Part 1 - Query 1", "Part 1 - Query 2", "Part 1 - Query 3", "Part 1 - Query 4",
				"Part 2 - Query 1","Part 2 - Query 2","Part 2 - Query 3" };
		JComboBox<String> queryList = new JComboBox<String>(queries);
		if (funcNumber == 3) {
			contentPanel.add(queryList);
			queryList.setSelectedIndex(0);
		}

		JButton actionButton;
		switch (funcNumber) {
		case 1:
			actionButton = new JButton("Validate documents");
			break;
		case 2:
			actionButton = new JButton("Integrate documents");
			break;
		case 3:
			actionButton = new JButton("Execute");
			break;
		case 4:
			actionButton = new JButton("Produce XHTML");
			break;
		default:
			actionButton = new JButton("Action");
			break;
		}
		contentPanel.add(actionButton, gbc_btnAction);
		JTextArea textArea;
		textArea = new JTextArea();
		textArea.setBackground(Color.white);
		textArea.setOpaque(true);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		JScrollPane jScroll = new JScrollPane (textArea);
		jScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				
		contentPanel.add(jScroll, gbc_textArea);

		actionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] args;
				switch (funcNumber) {
				case 1:
					args = new String[0];
					FunctionalityOne.main(args);
					FunctionalityOne.getValidation();
					textArea.setText(FunctionalityOne.getAnswer());
					break;
				case 2:
					args = new String[0];
					textArea.setText(FunctionalityTwo.main(args));
					if(FunctionalityTwo.getValidation()) {
						JOptionPane.showInputDialog("The intregration is completed and valid");
					} else {
						JOptionPane.showInputDialog("The integration is completed but not valid");
					
					}
					break;
				case 3:
					textArea.setText(FunctionalityThree.resetRes());
					int elt = queryList.getSelectedIndex()+1;
					String query = FunctionalityThree.getQuery(elt);
					textArea.setText(query);
					if(elt==6) {
						if(FunctionalityThree.getValidation()) {
							JOptionPane.showInputDialog("The result is also produced by XSLT into p2-q2-xslt.xml");
						} else {
							JOptionPane.showInputDialog("The result is not produced by XSLT");
						}
					}
					if(elt==7) {
						if(FunctionalityThree.getValidation()) {
							JOptionPane.showInputDialog("The result is also produced by XSLT into p2-q3-xslt.xml");
						} else {
							JOptionPane.showInputDialog("The result is not produced by XSLT");
						}
					}
					break;
				case 4:
					args = new String[0];
					textArea.setText(FunctionalityFour.main(args));
					JOptionPane.showInputDialog("The JSON file is produced --> JSON.txt");
					break;
				default:
					break;
				}

			}
		});

		contentPanel.revalidate();
		contentPanel.repaint();
	}

	private void initialize() {
		try {
			UIManager
					.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			try {
				UIManager.setLookAndFeel(UIManager
						.getCrossPlatformLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			}
		}
		mainPanel = new JFrame();
		mainPanel.setResizable(false);
		mainPanel.setTitle("Web Technologies Challenge 1");
		mainPanel.setBounds(200, 100, 1200, 700);
		mainPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0 };
		gridBagLayout.rowHeights = new int[] { 0 };
		gridBagLayout.columnWeights = new double[] {};
		gridBagLayout.rowWeights = new double[] {};
		mainPanel.getContentPane().setLayout(gridBagLayout);
	}

	public JFrame getMainPanel() {
		return mainPanel;
	}

}