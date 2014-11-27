package view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import common.Constants;

import controller.ButtonController;
import controller.MouseController;

public class ClubSearchView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField textField;
	private JButton btnSearch;
	ButtonController buttonController;
	MouseController mousecontroller;
	private JTable table;
	public Object[][] cellData;
	public CardLayout card;
	public static JPanel container;
	public JButton btnBack;
	public JPanel panel;
	public LaunchGUI launchGUI;
	public JLabel label;
	private JLabel labelClubName;
	private JLabel labelHomeStadium;
	private JLabel labelCoach;
	private JLabel labelRanking;
	private JTextField textFieldClubName;
	private JTextField textFieldHomeStaduim;
	private JTextField textFieldCoach;
	private JTextField textFieldRanking;
	private JButton btnUpdate;
	/**
	 * @return the textFieldClubName
	 */
	public JTextField getTextFieldClubName() {
		return textFieldClubName;
	}

	/**
	 * @return the textFieldHomeStaduim
	 */
	public JTextField getTextFieldHomeStaduim() {
		return textFieldHomeStaduim;
	}

	/**
	 * @return the textFieldCoach
	 */
	public JTextField getTextFieldCoach() {
		return textFieldCoach;
	}

	/**
	 * @return the textFieldRanking
	 */
	public JTextField getTextFieldRanking() {
		return textFieldRanking;
	}
	
	/**
	 * @return the btnUpdate
	 */
	public JButton getBtnUpdate() {
		return btnUpdate;
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		LaunchGUI launchGUI = new LaunchGUI();
		ClubSearchView clubSearchView = new ClubSearchView(launchGUI);
		clubSearchView.add(container);
		clubSearchView.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public ClubSearchView(LaunchGUI launchGUI) {
		
		this.launchGUI = launchGUI;
		this.card = launchGUI.card;
		ClubSearchView.container = LaunchGUI.container;
//		card = new CardLayout();
//		container = new JPanel();
//		container.setLayout(card);
		
//		panel = new JPanel();
//		panel.setLayout(null);
//		btnTest = new JButton("Test");
//		btnTest.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
//		btnTest.setBounds(Constants.BUTTON_STARTX, 90, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
//		panel.add(btnTest);
		//panel = launchGUI.panel2;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		buttonController = new ButtonController(this);
		mousecontroller = new MouseController(this, buttonController);

		label = new JLabel("Club Search", SwingConstants.CENTER);
		label.setBounds(62, 40, Constants.BUTTON_WIDTH - 70, Constants.BUTTON_HEIGHT);
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(170, 40, 220, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addActionListener(buttonController);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(412, 40, 110, 30);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnSearch.addActionListener(buttonController);
		contentPane.add(btnSearch);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(20, 10, Constants.BUTTON_WIDTH - 80, Constants.BUTTON_HEIGHT - 10);
		btnBack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnBack.addActionListener(buttonController);
		contentPane.add(btnBack);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 190, 481, 200);
		contentPane.add(scrollPane);
		
		table = setTable();
		table.addMouseListener(mousecontroller);
		scrollPane.setViewportView(table);
		
		labelClubName = new JLabel("Club Name", JLabel.CENTER);
		labelClubName.setBounds(62, 90, 70, 25);
		labelClubName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(labelClubName);
		
		textFieldClubName = new JTextField();
		textFieldClubName.setBounds(150, 90, 120, 25);
		textFieldClubName.setHorizontalAlignment(JTextField.CENTER);
		textFieldClubName.setEditable(false);
		contentPane.add(textFieldClubName);		
		
		labelHomeStadium = new JLabel("Home Stadium", JLabel.CENTER);
		labelHomeStadium.setBounds(300, 90, 100, 25);
		labelHomeStadium.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(labelHomeStadium);
		
		textFieldHomeStaduim = new JTextField();
		textFieldHomeStaduim.setBounds(420, 90, 120, 25);
		textFieldHomeStaduim.setEditable(false);
		textFieldHomeStaduim.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(textFieldHomeStaduim);
		
		labelCoach = new JLabel("Coach", JLabel.CENTER);
		labelCoach.setBounds(62, 140, 70, 25);
		labelCoach.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(labelCoach);
		
		textFieldCoach = new JTextField();
		textFieldCoach.setBounds(150, 140, 120, 25);
		textFieldCoach.setEditable(false);
		textFieldCoach.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(textFieldCoach);
		
		labelRanking = new JLabel("Club Ranking", JLabel.CENTER);
		labelRanking.setBounds(300, 140, 100, 25);
		labelRanking.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(labelRanking);
		
		textFieldRanking = new JTextField();
		textFieldRanking.setBounds(420, 140, 120, 25);
		textFieldRanking.setEditable(false);
		textFieldRanking.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(textFieldRanking);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(500, 10, Constants.BUTTON_WIDTH - 80, Constants.BUTTON_HEIGHT - 10);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnUpdate.addActionListener(buttonController);

		contentPane.add(btnUpdate);
		btnUpdate.setVisible(false);
	}

	/**
	 * @param btnUpdate the btnUpdate to set
	 */
	public void setBtnUpdate(JButton btnUpdate) {
		this.btnUpdate = btnUpdate;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public JTextField getTextField() {
		return textField;
	}

	private JTable setTable() {
		String[] columnNames = { "Player Number", "Player Name" };
		cellData = new String[25][2];
		int i;
		for (i = 0; i < 25; i++) {
			cellData[i][0] = null;
			cellData[i][1] = null;
		}
		DefaultTableModel model = new DefaultTableModel(cellData, columnNames) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};

		return new JTable(model) {
			private static final long serialVersionUID = 1L;

			@Override
			public Dimension getPreferredScrollableViewportSize() {
				return getPreferredSize();
			}

			DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
			{
				renderCenter.setHorizontalAlignment(SwingConstants.CENTER);
			}

			@Override
			public TableCellRenderer getCellRenderer(int arg0, int arg1) {
				return renderCenter;
			}
		};
	}

	public JTable getTable() {
		return table;
	}
	
	public void updatable() {
		btnUpdate.setVisible(true);
		textFieldClubName.setEditable(true);
		textFieldHomeStaduim.setEditable(true);
		textFieldCoach.setEditable(true);
		textFieldRanking.setEditable(true);
	}
	
	public void unUpdatable() {
		btnUpdate.setVisible(false);
		textFieldClubName.setEditable(false);
		textFieldHomeStaduim.setEditable(false);
		textFieldCoach.setEditable(false);
		textFieldRanking.setEditable(false);
	}
	
	public void clear() {
		textField.setText(null);
		textFieldClubName.setText(null);
		textFieldHomeStaduim.setText(null);
		textFieldCoach.setText(null);
		textFieldRanking.setText(null);
		for (int rowNum = 0; rowNum < this.cellData.length; rowNum++) {
			this.getTable().setValueAt(null, rowNum, 0);
			this.getTable().setValueAt(null, rowNum, 1);
			this.getTable().updateUI();
		}
	}
}
