package view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
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
	private JPanel contentPane;
	public Object[][] cellData;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerStatistics frame = new PlayerStatistics();
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
	public PlayerStatistics() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Constants.X, Constants.Y, Constants.PANEL_WIDTH,
				Constants.PANEL_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 90, 510, 312);
		contentPane.add(scrollPane);

		table = setTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
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
		String[] columnNames = { "Club", "Player Name", "GS", "ON", "OFF", "AS", "OF", "FC", "FS", "AP", "CP", "PC" };
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

}
