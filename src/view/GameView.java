package view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import common.Constants;

import database.DBQuerier;

public class GameView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	private JLabel lblSearchGame;
	private JLabel lblHomeTeam;
	private JLabel lblAwayTeam;
	private JLabel lblDate;
	private JLabel lblTeamData;
	
	private JComboBox<String> comboBoxHomeTeam;
	private JComboBox<String> comboBoxAwayTeam;
	private JComboBox<String> comboBoxDate;
	private JButton btnSearch;
	private JButton btnBack;
	private JButton btnGameStatistics;
	private JButton btnPlayerStatistics;
	
	public CardLayout card;
	public static JPanel container;
	public LaunchGUI launchGUI;
	
	public JScrollPane jScrollPane;
	public JTable table;
	public Object cellData[][];
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			LaunchGUI launchGUI = new LaunchGUI();
			public void run() {
				try {
					GameView frame = new GameView(launchGUI);
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
	public GameView(final LaunchGUI launchGUI) {
		this.launchGUI = launchGUI;
		this.card = launchGUI.card;
		GameView.container = LaunchGUI.container;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Constants.X, Constants.Y, Constants.PANEL_WIDTH, Constants.PANEL_HEIGHT);
		
		
		contentPane = new JPanel();
		contentPane.setBounds(Constants.X, Constants.Y + 100, Constants.PANEL_WIDTH, Constants.PANEL_HEIGHT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(245, 100, 125, 28);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(btnSearch);
		
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DBQuerier dbQuerier = new DBQuerier();
				ResultSet rs = null;
				System.out.println("-------");
				try {
					if(comboBoxHomeTeam.getSelectedIndex() > -1) {
						rs = dbQuerier.getGameByTeam(comboBoxHomeTeam.getSelectedItem().toString().toLowerCase());
						System.out.println(comboBoxHomeTeam.getSelectedItem().toString().toLowerCase());
					}
					if(rs != null) {
						updateTable(rs);
					}
				} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
				}					
			}
		});
		
		btnGameStatistics = new JButton("Game Statistics");
		btnGameStatistics.setBounds(10, 305, 160, 25);
		btnGameStatistics.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(btnGameStatistics);
		
		btnGameStatistics.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				launchGUI.setTitle("Game Statistics");
				DBQuerier dbQuerier = new DBQuerier();
				ResultSet rs = null;
				int gameId = dbQuerier.getGameId("", "", "");
				try {
					if(comboBoxHomeTeam.getSelectedItem().toString() != "" ) {
						rs = dbQuerier.getTeamDataByGameId(gameId, comboBoxHomeTeam.getSelectedItem().toString());
					}
					if(rs != null) {
						launchGUI.gameStatistics.lblLeft1.setText(String.valueOf(rs.getInt(3)));
						launchGUI.gameStatistics.lblLeft2.setText(String.valueOf(rs.getInt(4)));
						launchGUI.gameStatistics.lblLeft3.setText(String.valueOf(rs.getInt(5)));
						launchGUI.gameStatistics.lblLeft4.setText(String.valueOf(rs.getInt(6)));
						launchGUI.gameStatistics.lblLeft5.setText(String.valueOf(rs.getInt(7)));
						launchGUI.gameStatistics.lblLeft6.setText(String.valueOf(rs.getInt(8)));
						launchGUI.gameStatistics.lblLeft7.setText(String.valueOf(rs.getInt(9)));
						launchGUI.gameStatistics.lblLeft8.setText(String.valueOf(rs.getInt(10)));
						launchGUI.gameStatistics.lblLeft9.setText(String.valueOf(rs.getInt(11)));
						launchGUI.gameStatistics.lblLeft10.setText(String.valueOf(rs.getInt(12)));
						launchGUI.gameStatistics.lblLeft11.setText(String.valueOf(rs.getInt(13)));
						launchGUI.gameStatistics.lblLeft12.setText(String.valueOf(rs.getInt(14)));
						launchGUI.gameStatistics.lblLeft13.setText(String.valueOf(rs.getInt(15)));
						launchGUI.gameStatistics.lblLeft14.setText(String.valueOf(rs.getInt(16)));
						launchGUI.gameStatistics.lblLeft15.setText(rs.getString(2));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					if(comboBoxAwayTeam.getSelectedItem().toString() != "" ) {
						rs = dbQuerier.getTeamDataByGameId(gameId, comboBoxAwayTeam.getSelectedItem().toString());
					}
					
					if(rs != null) {
						launchGUI.gameStatistics.lblRight1.setText(String.valueOf(rs.getInt(3)));
						launchGUI.gameStatistics.lblRight2.setText(String.valueOf(rs.getInt(4)));
						launchGUI.gameStatistics.lblRight3.setText(String.valueOf(rs.getInt(5)));
						launchGUI.gameStatistics.lblRight4.setText(String.valueOf(rs.getInt(6)));
						launchGUI.gameStatistics.lblRight5.setText(String.valueOf(rs.getInt(7)));
						launchGUI.gameStatistics.lblRight6.setText(String.valueOf(rs.getInt(8)));
						launchGUI.gameStatistics.lblRight7.setText(String.valueOf(rs.getInt(9)));
						launchGUI.gameStatistics.lblRight8.setText(String.valueOf(rs.getInt(10)));
						launchGUI.gameStatistics.lblRight9.setText(String.valueOf(rs.getInt(11)));
						launchGUI.gameStatistics.lblRight10.setText(String.valueOf(rs.getInt(12)));
						launchGUI.gameStatistics.lblRight11.setText(String.valueOf(rs.getInt(13)));
						launchGUI.gameStatistics.lblRight12.setText(String.valueOf(rs.getInt(14)));
						launchGUI.gameStatistics.lblRight13.setText(String.valueOf(rs.getInt(15)));
						launchGUI.gameStatistics.lblRight14.setText(String.valueOf(rs.getInt(16)));
						launchGUI.gameStatistics.lblRight15.setText(rs.getString(2));
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				card.show(container, "" + 8);
			}
		});
		
		btnPlayerStatistics = new JButton("Player Statistics");
		btnPlayerStatistics.setBounds(200, 305, 160, 25);
		btnPlayerStatistics.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(btnPlayerStatistics);
		
		btnPlayerStatistics.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		

		
		btnBack = new JButton("Back");
		btnBack.setBounds(20, 10, Constants.BUTTON_WIDTH - 80, Constants.BUTTON_HEIGHT - 10);
		btnBack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(btnBack);
		
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(container, "" + 3);
				launchGUI.setTitle("Version 1.0");
			}
		});
		
		lblSearchGame = new JLabel("Search Game", SwingConstants.CENTER);
		lblSearchGame.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblSearchGame.setBounds(245, 10, 125, 32);
		contentPane.add(lblSearchGame);
		
		lblHomeTeam = new JLabel("Home Team", SwingConstants.CENTER);
		lblHomeTeam.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblHomeTeam.setBounds(150, 40, 125, 32);
		contentPane.add(lblHomeTeam);
		
		lblAwayTeam = new JLabel("Away Team", SwingConstants.CENTER);
		lblAwayTeam.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblAwayTeam.setBounds(290, 40, 125, 32);
		contentPane.add(lblAwayTeam);
		
		lblDate = new JLabel("Date", SwingConstants.CENTER);
		lblDate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblDate.setBounds(430, 40, 125, 32);
		contentPane.add(lblDate);
		
		comboBoxHomeTeam = new JComboBox<String>();
		comboBoxHomeTeam.setBounds(160, 70, 103, 21);
		contentPane.add(comboBoxHomeTeam);
		comboBoxHomeTeam.setModel(new javax.swing.DefaultComboBoxModel<String>(
				new String[] { null, "Liverpool"}));
		
		comboBoxAwayTeam = new JComboBox<String>();
		comboBoxAwayTeam.setBounds(300, 70, 103, 21);
		comboBoxAwayTeam.setModel(new javax.swing.DefaultComboBoxModel<String>(
				new String[] { null, "Real Madrid"}));
		contentPane.add(comboBoxAwayTeam);
		
		comboBoxDate = new JComboBox<String>();
		comboBoxDate.setBounds(440, 70, 103, 21);
		contentPane.add(comboBoxDate);
		
//		lblTeamData= new JLabel("Game Statistics", SwingConstants.CENTER);
//		lblTeamData.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
//		lblTeamData.setBounds(245, 100, 125, 28);
//		contentPane.add(lblTeamData);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 150, 481, 100);
		contentPane.add(scrollPane);
		
		table = setTable();
		scrollPane.setViewportView(table);
	}
	
	
	
	private JTable setTable() {
		String[] columnNames = { "Home Team", "Away Team", "Date of Game" };
		cellData = new String[10][3];
		int i;
		for (i = 0; i < 10; i++) {
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
	
	public void updateTable(ResultSet rs) {
		System.out.println("update table" + rs.equals(null));
		if (rs.equals(null)) {
			for (int rowNum = 0; rowNum < cellData.length; rowNum++) {
				getTable().setValueAt(null, rowNum, 0);
				getTable().setValueAt(null, rowNum, 1);
				getTable().updateUI();
			}
		} else {
			for (int rowNum = 0; rowNum < cellData.length; rowNum++) {
				getTable().setValueAt(null, rowNum, 0);
				getTable().setValueAt(null, rowNum, 1);
				getTable().setValueAt(null, rowNum, 2);
			}
			int i = 0;
			try {
				while (rs.next()) {
					getTable().setValueAt(rs.getString(2), i, 0);
					getTable().setValueAt(rs.getString(3), i, 1);
					getTable().setValueAt(rs.getString(4), i, 2);
					i++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			getTable().updateUI();
		}
	}
	public void clear() {
		
		
	}
}
