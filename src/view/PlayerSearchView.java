package view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
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

import common.Club;
import common.Constants;
import common.Country;
import common.PlayerAge;
import common.PlayerHeight;
import common.PlayerPosition;

import database.DBQuerier;
import entity.Player;

public class PlayerSearchView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	private JTextField textField;
	private JLabel lblName;
	private JLabel lblPosition;
	private JComboBox<String> comboBoxPosition;
	private JComboBox<String> comboBoxCountry;
	private JLabel lblHeight;
	private JComboBox<String> comboBoxHeight;
	private JComboBox<String> comboBoxAge;
	private JLabel lblAge;
	private JLabel lblClub;
	private JComboBox<String> comboBoxClub;
	public Object[][] cellData;
	private JTable table;
	public LaunchGUI launchGUI;
	public JButton btnBack;
	public CardLayout card;
	public static JPanel container;
	private List<Player> playerList;

	/**
	 * Create the frame.
	 */
	public PlayerSearchView(final LaunchGUI launchGUI) {
		this.launchGUI = launchGUI;
		this.card = launchGUI.card;
		PlayerSearchView.container = LaunchGUI.container;

		playerList = null;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// JLabel lblNewLabel = new JLabel("Player Search", JLabel.CENTER);
		// lblNewLabel.setBounds(5, 5, 90, 20);
		// contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(140, 40, 130, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		lblName = new JLabel("Name", JLabel.CENTER);
		lblName.setBounds(60, 40, 49, 20);
		lblName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(lblName);

		lblPosition = new JLabel("Position", JLabel.CENTER);
		lblPosition.setBounds(295, 40, 68, 20);
		lblPosition.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(lblPosition);

		comboBoxPosition = new JComboBox<String>();
		comboBoxPosition.setBounds(400, 40, 130, 20);
		contentPane.add(comboBoxPosition);

		comboBoxPosition.setModel(new javax.swing.DefaultComboBoxModel<String>(
				new String[] { PlayerPosition.Any.name(),
						PlayerPosition.Forward.name(),
						PlayerPosition.Midfield.name(),
						PlayerPosition.Defender.name(),
						PlayerPosition.Goalkeeper.name() }));

		JLabel label = new JLabel("Country", JLabel.CENTER);
		label.setBounds(60, 80, 60, 20);
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(label);

		comboBoxCountry = new JComboBox<String>();
		comboBoxCountry.setBounds(140, 80, 130, 21);
		contentPane.add(comboBoxCountry);

		comboBoxCountry.setModel(new javax.swing.DefaultComboBoxModel<String>(
				new String[] { Country.Any.getCountryName(),
						Country.Australia.getCountryName(),
						Country.Belgium.getCountryName(),
						Country.Brazil.getCountryName(),
						Country.Colombia.name(),
						Country.Costa_Rica.getCountryName(),
						Country.Cote_dIvoire.getCountryName(),
						Country.Croatia.getCountryName(),
						Country.England.getCountryName(),
						Country.France.getCountryName(),
						Country.Germany.getCountryName(),
						Country.Italy.getCountryName(),
						Country.Mexico.getCountryName(),
						Country.Portugal.getCountryName(),
						Country.Serbia.getCountryName(),
						Country.Slovakia.getCountryName(),
						Country.Spain.getCountryName(),
						Country.Wales.getCountryName() }));

		lblHeight = new JLabel("Height(cm)", JLabel.CENTER);
		lblHeight.setBounds(295, 80, 90, 20);
		lblHeight.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(lblHeight);

		comboBoxHeight = new JComboBox<String>();
		comboBoxHeight.setBounds(400, 80, 130, 21);
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
		lblAge.setBounds(60, 120, 54, 15);
		lblAge.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(lblAge);

		comboBoxAge = new JComboBox<String>();
		comboBoxAge.setBounds(140, 120, 130, 21);
		contentPane.add(comboBoxAge);

		comboBoxAge.setModel(new javax.swing.DefaultComboBoxModel<String>(
				new String[] { PlayerAge.Any.getPlayerAge(),
						PlayerAge.Age1.getPlayerAge(),
						PlayerAge.Age2.getPlayerAge(),
						PlayerAge.Age3.getPlayerAge(),
						PlayerAge.Age4.getPlayerAge(),
						PlayerAge.Age5.getPlayerAge() }));

		lblClub = new JLabel("Club", JLabel.CENTER);
		lblClub.setBounds(295, 120, 70, 20);
		lblClub.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(lblClub);

		comboBoxClub = new JComboBox<String>();
		comboBoxClub.setBounds(400, 120, 130, 21);
		contentPane.add(comboBoxClub);

		comboBoxClub.setModel(new javax.swing.DefaultComboBoxModel<String>(
				new String[] { "Any", "Real Madrid", "Liverpool" }));

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(235, 156, 93, 23);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(btnSearch);

		btnBack = new JButton("Back");
		btnBack.setBounds(20, 10, Constants.BUTTON_WIDTH - 80,
				Constants.BUTTON_HEIGHT - 10);
		btnBack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(btnBack);

		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				launchGUI.setTitle("Version 1.0");
				card.show(container, "" + 3);
			}
		});

		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchPlayer();
				}
			}
		});

		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchPlayer();
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 190, 470, 212);
		contentPane.add(scrollPane);

		table = setTable();
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getClickCount() == 2) {
					PlayerView playerView = new PlayerView();
					// JTable table = null;
					// table = (JTable) e.getSource();
					int row = table.getSelectedRow();
					if (table.getValueAt(row, 0) != null) {
						String selectedPlayerName = table.getValueAt(row, 1)
								.toString();
						if (row > -1) {
							for (Player player : playerList) {
								if (player.getName().trim()
										.equalsIgnoreCase(selectedPlayerName)) {
									System.out.println(player.getClub() + ","
											+ player.getName());
									playerView.getTextFieldPlayerName()
											.setText(player.getName().trim());
									playerView.getTextFieldAge().setText(
											String.valueOf(player.getAge())
													.trim());
									playerView.getTextFieldPosition().setText(
											player.getPosition().trim());
									playerView.getTextFieldClub().setText(
											player.getClub().trim());
									playerView.getTextFieldHeight().setText(
											String.valueOf(player.getHeight())
													.trim());
									playerView
											.getTextFieldSquadNumber()
											.setText(
													String.valueOf(
															player.getSquad_number())
															.trim());
									playerView.getTextFieldCountry().setText(
											player.getCountry().trim());
									playerView.setVisible(true);
								}
							}
						}
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		scrollPane.setViewportView(table);
	}

	private JTable setTable() {
		String[] columnNames = { "Club", "Player Name" };
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

	public void updateTable(List<Player> playerList) {

		List<Player> result = playerList;
		if (result.size() > 25) {
			result = result.subList(0, 25);
		}

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
			this.table.setValueAt(player.getClub().toString().trim(), i, 0);
			this.table.setValueAt(player.getName().toString().trim(), i, 1);
			i++;
		}
		this.table.updateUI();
		this.table.revalidate();
	}

	public void searchPlayer() {
		String inputHeight = null;
		String inputAge = null;
		String inputCountry = null;
		String inputPosition = null;
		String inputClub = null;

		if (comboBoxPosition.getSelectedItem()
				.equals(PlayerPosition.Any.name())) {
			inputPosition = null;
		} else {
			inputPosition = comboBoxPosition.getSelectedItem().toString();
		}

		if (comboBoxHeight.getSelectedItem().equals(PlayerHeight.Any.name())) {
			inputHeight = null;
		} else {
			inputHeight = comboBoxHeight.getSelectedItem().toString();
		}

		if (comboBoxCountry.getSelectedItem().equals(Country.Any.name())) {
			inputCountry = null;
		} else {
			inputCountry = comboBoxCountry.getSelectedItem().toString();
		}

		if (comboBoxAge.getSelectedItem().equals(PlayerAge.Any.name())) {
			inputAge = null;
		} else {
			inputAge = comboBoxAge.getSelectedItem().toString();
		}

		if (comboBoxClub.getSelectedItem().equals(Club.Any.getClubName())) {
			inputClub = null;
		} else {
			inputClub = comboBoxClub.getSelectedItem().toString();
		}

		DBQuerier dbQuerier = new DBQuerier();

		try {
			System.out.println("Height:" + inputHeight + ", Country:"
					+ inputCountry);
			playerList = dbQuerier.getPlayerData(textField.getText(),
					inputPosition, inputAge, inputCountry, inputClub,
					inputHeight);
			// playerList = dbQuerier.getPlayerData();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		updateTable(playerList);

		for (Player player : playerList) {
			System.out.println(player.getName() + "," + player.getClub());
		}
	}

	public void clear() {
		textField.setText(null);;
		comboBoxPosition.setSelectedIndex(0);
		comboBoxCountry.setSelectedIndex(0);
		comboBoxHeight.setSelectedIndex(0);
		comboBoxAge.setSelectedIndex(0);
		comboBoxClub.setSelectedIndex(0);
		for (int rowNum = 0; rowNum < this.cellData.length; rowNum++) {
			this.table.setValueAt(null, rowNum, 0);
			this.table.setValueAt(null, rowNum, 1);
		}
	}
}
