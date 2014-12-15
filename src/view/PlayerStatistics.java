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
import controller.Rating;
import database.DBQuerier;

public class PlayerStatistics extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public Object[][] cellData;
	private JTable table;

	public JButton btnBack;
	public LaunchGUI launchGUI;
	public CardLayout card;
	public static JPanel container;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LaunchGUI launchGUI = new LaunchGUI();
					PlayerStatistics frame = new PlayerStatistics(launchGUI);
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
	public PlayerStatistics(final LaunchGUI launchGUI) {
		this.launchGUI = launchGUI;
		this.card = launchGUI.card;
		PlayerStatistics.container = LaunchGUI.container;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Constants.X, Constants.Y, Constants.PANEL_WIDTH,
				Constants.PANEL_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnBack = new JButton("Back");
		btnBack.setBounds(20, 10, Constants.BUTTON_WIDTH - 80,
				Constants.BUTTON_HEIGHT - 10);
		btnBack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(btnBack);

		JLabel legendLabel = new JLabel(
				"<html>Legend:<br>GS:Goals scored ON:on target AS:Assists OF:Offsides FC:Fouls committed AP:Passes CP:completed PC:Pass completion RA:Rating</html>");
		legendLabel.setBounds(40, 365, 510, 50);
		legendLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		contentPane.add(legendLabel);

		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(container, "" + 6);
				launchGUI.setTitle("Version 1.0");
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 60, 510, 300);
		contentPane.add(scrollPane);

		table = setTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);
		table.getColumnModel().getColumn(4).setPreferredWidth(40);
		table.getColumnModel().getColumn(5).setPreferredWidth(40);
		table.getColumnModel().getColumn(6).setPreferredWidth(40);
		table.getColumnModel().getColumn(7).setPreferredWidth(40);
		table.getColumnModel().getColumn(8).setPreferredWidth(40);
		table.getColumnModel().getColumn(9).setPreferredWidth(40);
		table.getColumnModel().getColumn(10).setPreferredWidth(40);

		scrollPane.setViewportView(table);
	}

	private JTable setTable() {
		String[] columnNames = { "Club", "Player Name", "GS", "ON", "AS", "OF",
				"FC", "AP", "CP", "PC", "RA" };
		cellData = new String[60][12];
		int i;
		for (i = 0; i < 60; i++) {
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

	public void updateTable(ResultSet rs) {
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
					getTable().setValueAt(rs.getString(2).trim(), i, 0);
					getTable().setValueAt(rs.getString(4).trim(), i, 1);
					getTable().setValueAt(rs.getString(5).trim(), i, 2);
					getTable().setValueAt(rs.getString(6).trim(), i, 3);
					getTable().setValueAt(rs.getString(7).trim(), i, 4);
					getTable().setValueAt(rs.getString(8).trim(), i, 5);
					getTable().setValueAt(rs.getString(9).trim(), i, 6);
					getTable().setValueAt(rs.getString(10).trim(), i, 7);
					getTable().setValueAt(rs.getString(11).trim(), i, 8);
					getTable().setValueAt(rs.getString(12).trim(), i, 9);

					System.out.println(rs.getString(1).trim());
					System.out.println(rs.getString(2).trim());
					System.out.println(rs.getString(3).trim());
					System.out.println(rs.getString(4).trim());
					System.out.println(rs.getString(5).trim());
					System.out.println(rs.getString(6).trim());
					System.out.println(rs.getString(7).trim());
					System.out.println(rs.getString(8).trim());
					System.out.println(rs.getString(9).trim());
					System.out.println(rs.getString(10).trim());

					String team = rs.getString(2).trim();
					int squadNumber = Integer.parseInt(rs.getString(3).trim());
					int goalScored = Integer.parseInt(rs.getString(5).trim());
					int onTarget = Integer.parseInt(rs.getString(6).trim());
					int assists = Integer.parseInt(rs.getString(7).trim());
					int offsides = Integer.parseInt(rs.getString(8).trim());
					int foulsCommitted = Integer.parseInt(rs.getString(9)
							.trim());
					int passes = Integer.parseInt(rs.getString(10).trim());
					int completedPass = Integer.parseInt(rs.getString(11)
							.trim());
					float completion = Float
							.parseFloat(rs.getString(12).trim());

					DBQuerier dbQuerier = new DBQuerier();
					String position = dbQuerier.getPlayerPosition(team,
							squadNumber);
					System.out.println(team + "," + squadNumber + ","
							+ position);
					Rating rate = new Rating();
					String rating = rate.calculate(position, goalScored,
							onTarget, assists, offsides, foulsCommitted,
							passes, completedPass, completion);
					getTable().setValueAt(rating, i, 10);
					i++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getTable().updateUI();
		}
	}

	public JTable getTable() {
		return table;
	}

	public void clear() {
		for (int rowNum = 0; rowNum < this.cellData.length; rowNum++) {
			this.table.setValueAt(null, rowNum, 0);
			this.table.setValueAt(null, rowNum, 1);
			this.table.setValueAt(null, rowNum, 2);
			this.table.setValueAt(null, rowNum, 3);
			this.table.setValueAt(null, rowNum, 4);
			this.table.setValueAt(null, rowNum, 5);
			this.table.setValueAt(null, rowNum, 6);
			this.table.setValueAt(null, rowNum, 7);
			this.table.setValueAt(null, rowNum, 8);
			this.table.setValueAt(null, rowNum, 9);
			this.table.setValueAt(null, rowNum, 10);
		}
	}

}
