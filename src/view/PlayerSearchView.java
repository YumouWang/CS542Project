package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
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

import common.Country;
import common.PlayerHeight;
import common.PlayerPosition;
import database.DBQuerier;
import entity.Player;

public class PlayerSearchView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblName;
	private JLabel lblPosition;
	private JComboBox<String> comboBoxPosition;
	private JComboBox<String> comboBoxCountry;
	private JLabel lblHeight;
	private JComboBox<String> comboBoxHeight;
	private JLabel lblAge;
	public Object[][] cellData;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerSearchView frame = new PlayerSearchView();
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
	public PlayerSearchView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Player Search", JLabel.CENTER);
		lblNewLabel.setBounds(5, 5, 90, 20);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(84, 40, 130, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		lblName = new JLabel("Name", JLabel.CENTER);
		lblName.setBounds(25, 40, 49, 20);
		contentPane.add(lblName);

		lblPosition = new JLabel("Position", JLabel.CENTER);
		lblPosition.setBounds(235, 40, 68, 20);
		contentPane.add(lblPosition);

		comboBoxPosition = new JComboBox<String>();
		comboBoxPosition.setBounds(308, 40, 122, 20);
		contentPane.add(comboBoxPosition);

		comboBoxPosition.setModel(new javax.swing.DefaultComboBoxModel<String>(
				new String[] { PlayerPosition.Any.name(),
						PlayerPosition.Forward.name(),
						PlayerPosition.Midfielder.name(),
						PlayerPosition.Defender.name(),
						PlayerPosition.Goalkeeper.name() }));

		JLabel label = new JLabel("Country", JLabel.CENTER);
		label.setBounds(25, 80, 47, 20);
		contentPane.add(label);

		comboBoxCountry = new JComboBox<String>();
		comboBoxCountry.setBounds(84, 80, 130, 21);
		contentPane.add(comboBoxCountry);

		comboBoxCountry.setModel(new javax.swing.DefaultComboBoxModel<String>(
				new String[] { Country.Any.getCountryName(),
						Country.Brazil.getCountryName(),
						Country.Colombia.name(),
						Country.Costa_Rica.getCountryName(),
						Country.Croatia.getCountryName(),
						Country.France.getCountryName(),
						Country.Germany.getCountryName(),
						Country.Mexico.getCountryName(),
						Country.Portugal.getCountryName(),
						Country.Spain.getCountryName(),
						Country.Wales.getCountryName() }));

		lblHeight = new JLabel("Height(cm)", JLabel.CENTER);
		lblHeight.setBounds(235, 80, 68, 20);
		contentPane.add(lblHeight);

		comboBoxHeight = new JComboBox<String>();
		comboBoxHeight.setBounds(308, 80, 122, 21);
		contentPane.add(comboBoxHeight);

		comboBoxHeight.setModel(new javax.swing.DefaultComboBoxModel<String>(
				new String[] { PlayerHeight.Any.getPlayerHeight(),
						PlayerHeight.Height1.getPlayerHeight(),
						PlayerHeight.Height2.getPlayerHeight(),
						PlayerHeight.Height3.getPlayerHeight(),
						PlayerHeight.Height4.getPlayerHeight(),
						PlayerHeight.Height5.getPlayerHeight(),
						PlayerHeight.Height6.getPlayerHeight() }));

		lblAge = new JLabel("Age", JLabel.CENTER);
		lblAge.setBounds(20, 120, 54, 15);
		contentPane.add(lblAge);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(211, 156, 93, 23);
		contentPane.add(btnSearch);
		
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputHeight = null;
				int inputAge = 0;
				String inputCountry = null;
				String inputPosition = null;
				String inputClub = null;
				
				if (comboBoxHeight.getSelectedItem() == PlayerHeight.Any) {
					inputHeight = "";
				} else {
					inputHeight = comboBoxHeight.getSelectedItem().toString();
				}

				if (comboBoxCountry.getSelectedItem() == Country.Any) {
					inputCountry = "";
				} else {
					inputCountry = comboBoxCountry.getSelectedItem().toString();
				}
				
				
				DBQuerier dbQuerier = new DBQuerier();
				List<Player> playerList = null;
				try {
					System.out.println("Height:" + inputHeight + ", Country:" + inputCountry);
					playerList = dbQuerier.getPlayerData(textField.getText(),
							null, 0, inputCountry, inputClub);
//					playerList = dbQuerier.getPlayerData();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				updateTable(playerList);
				
				for(Player player : playerList) {
					System.out.println(player.getName() + "," + player.getClub());
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 189, 459, 212);
		contentPane.add(scrollPane);

		table = setTable();
		scrollPane.setViewportView(table);
	}

	private JTable setTable() {
		String[] columnNames = { "Club", "Player Name" };
		cellData = new String[20][2];
		int i;
		for (i = 0; i < 20; i++) {
			cellData[i][0] = "hehe";
			cellData[i][1] = "1";
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
	
	public void updateTable(Collection<Player> playerList) {

		Collection<Player> result = playerList;

		for (int rowNum = 0; rowNum < this.cellData.length; rowNum++) {
			this.table.setValueAt(null, rowNum, 0);
			this.table.setValueAt(null, rowNum, 1);
			// cellData[rowNum][0] = null;
			// cellData[rowNum][1] = null;
		}
		int i = 0;
		for (Player player : result) {
			// cellData[i][0] = word.getValue();
			// cellData[i][1] = ((Word) word).getType().toString();
			this.table.setValueAt(player.getClub().toString(), i, 0);
			this.table.setValueAt(player.getName().toString(), i, 1);
			i++;
		}
		this.table.updateUI();
		this.table.revalidate();
	}
}
