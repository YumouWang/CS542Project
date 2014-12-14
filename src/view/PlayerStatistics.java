package view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		btnBack.setBounds(20, 10, Constants.BUTTON_WIDTH - 80, Constants.BUTTON_HEIGHT - 10);
		btnBack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(btnBack);
		
		JLabel legendLabel = new JLabel("<html>Legend:<br>GS:Goals scored ON:on target OFF:off target AS:Assists OF:Offsides FC:Fouls committed FS:Fouls suffered AP:Passes CP:completed PC:Pass completion RA:Rating</html>");
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
		table.getColumnModel().getColumn(11).setPreferredWidth(40);
		scrollPane.setViewportView(table);
	}
	
	private JTable setTable() {
		String[] columnNames = { "Club", "Player Name", "GS", "ON", "OFF", "AS", "OF", "FC", "AP", "CP", "PC", "RA"};
		cellData = new String[25][12];
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
			this.table.setValueAt(null, rowNum, 11);
		}
	}

}
