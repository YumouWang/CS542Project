package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;

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

import controller.ButtonController;
import controller.MouseController;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnSearch;
	ButtonController buttonController;
	MouseController mousecontroller;
	private JTable table;
	public Object[][] cellData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
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
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		buttonController = new ButtonController(this);
		mousecontroller = new MouseController(this, buttonController);

		textField = new JTextField();
		textField.setBounds(62, 32, 331, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addActionListener(buttonController);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(412, 31, 110, 30);
		btnSearch.addActionListener(buttonController);
		contentPane.add(btnSearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 110, 459, 269);
		contentPane.add(scrollPane);

		table = setTable();
		table.addMouseListener(mousecontroller);
		scrollPane.setViewportView(table);
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
}
