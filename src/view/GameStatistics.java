package view;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import common.Constants;

public class GameStatistics extends JFrame {
	
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lbl8;
	private JLabel lbl9;
	private JLabel lbl10;
	private JLabel lbl11;
	private JLabel lbl12;
	private JLabel lbl13;
	private JLabel lbl14;
	private JLabel lbl15;
	
	public JLabel lblLeft1;
	public JLabel lblLeft2;
	public JLabel lblLeft3;
	public JLabel lblLeft4;
	public JLabel lblLeft5;
	public JLabel lblLeft6;
	public JLabel lblLeft7;
	public JLabel lblLeft8;
	public JLabel lblLeft9;
	public JLabel lblLeft10;
	public JLabel lblLeft11;
	public JLabel lblLeft12;
	public JLabel lblLeft13;
	public JLabel lblLeft14;
	public JLabel lblLeft15;
	
	public JLabel lblRight1;
	public JLabel lblRight2;
	public JLabel lblRight3;
	public JLabel lblRight4;
	public JLabel lblRight5;
	public JLabel lblRight6;
	public JLabel lblRight7;
	public JLabel lblRight8;
	public JLabel lblRight9;
	public JLabel lblRight10;
	public JLabel lblRight11;
	public JLabel lblRight12;
	public JLabel lblRight13;
	public JLabel lblRight14;
	public JLabel lblRight15;
	
	public JButton btnBack;
	public LaunchGUI launchGUI;
	public CardLayout card;
	public static JPanel container;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LaunchGUI launchGUI = new LaunchGUI();
					GameStatistics frame = new GameStatistics(launchGUI);
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
	public GameStatistics(final LaunchGUI launchGUI) {
		this.launchGUI = launchGUI;
		this.card = launchGUI.card;
		GameStatistics.container = LaunchGUI.container;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Constants.X, Constants.Y, Constants.PANEL_WIDTH, Constants.PANEL_HEIGHT);
		
		setContentPane(contentPane);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(20, 10, Constants.BUTTON_WIDTH - 80, Constants.BUTTON_HEIGHT - 10);
		btnBack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(btnBack);
		
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(container, "" + 6);
				launchGUI.setTitle("Game Result");
			}
		});
	
		
		lbl1= new JLabel("Goals scored", SwingConstants.CENTER);
		lbl1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lbl1.setBounds(245, 90, 125, 20);
		contentPane.add(lbl1);

		lbl2= new JLabel("Possession (%)", SwingConstants.CENTER);
		lbl2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lbl2.setBounds(245, 110, 125, 20);
		contentPane.add(lbl2);

		lbl3= new JLabel("Total attempts", SwingConstants.CENTER);
		lbl3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lbl3.setBounds(245, 130, 125, 20);
		contentPane.add(lbl3);
		
		lbl4= new JLabel("on target", SwingConstants.CENTER);
		lbl4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lbl4.setBounds(245, 150, 125, 20);
		contentPane.add(lbl4);
		
		lbl5= new JLabel("off target", SwingConstants.CENTER);
		lbl5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lbl5.setBounds(245, 170, 125, 20);
		contentPane.add(lbl5);
		
		lbl6= new JLabel("blocked", SwingConstants.CENTER);
		lbl6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lbl6.setBounds(245, 190, 125, 20);
		contentPane.add(lbl6);
		
//		lbl7= new JLabel("against woodwork", SwingConstants.CENTER);
//		lbl7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
//		lbl7.setBounds(245, 250, 125, 20);
//		contentPane.add(lbl7);
		
		lbl8= new JLabel("Corners", SwingConstants.CENTER);
		lbl8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lbl8.setBounds(245, 210, 125, 20);
		contentPane.add(lbl8);
		
		lbl9= new JLabel("Offsides", SwingConstants.CENTER);
		lbl9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lbl9.setBounds(245, 230, 125, 20);
		contentPane.add(lbl9);
		
		lbl10= new JLabel("Yellow cards", SwingConstants.CENTER);
		lbl10.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lbl10.setBounds(245, 250, 125, 20);
		contentPane.add(lbl10);
		
		lbl11= new JLabel("Red Cards", SwingConstants.CENTER);
		lbl11.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lbl11.setBounds(245, 270, 125, 20);
		contentPane.add(lbl11);
		
		lbl12= new JLabel("Fouls committed", SwingConstants.CENTER);
		lbl12.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lbl12.setBounds(245, 290, 125, 20);
		contentPane.add(lbl12);
		
		lbl13= new JLabel("Fouls suffered", SwingConstants.CENTER);
		lbl13.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lbl13.setBounds(245, 310, 125, 20);
		contentPane.add(lbl13);
		
		lbl14= new JLabel("Passes", SwingConstants.CENTER);
		lbl14.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lbl14.setBounds(245, 330, 125, 20);
		contentPane.add(lbl14);
		
		lbl15= new JLabel("completed", SwingConstants.CENTER);
		lbl15.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lbl15.setBounds(245, 350, 125, 20);
		contentPane.add(lbl15);
		
		lblLeft15 = new JLabel("Home Team", SwingConstants.CENTER);
		lblLeft15.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblLeft15.setBounds(60, 60, 125, 28);
		lblLeft15.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblLeft15);
		
		lblLeft1 = new JLabel();
		lblLeft1.setBounds(90, 90, 65, 20);
		lblLeft1.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblLeft1);
		
		lblLeft2 = new JLabel();
		lblLeft2.setBounds(90, 110, 65, 20);
		lblLeft2.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblLeft2);
		
		lblLeft3 = new JLabel();
		lblLeft3.setBounds(90, 130, 65, 20);
		lblLeft3.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblLeft3);
		
		lblLeft4 = new JLabel();
		lblLeft4.setBounds(90, 150, 65, 20);
		lblLeft4.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblLeft4);
		
		lblLeft5 = new JLabel();
		lblLeft5.setBounds(90, 170, 65, 20);
		lblLeft5.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblLeft5);
		
		lblLeft6 = new JLabel();
		lblLeft6.setBounds(90, 190, 65, 20);
		lblLeft6.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblLeft6);
		
		lblLeft7 = new JLabel();
		lblLeft7.setBounds(90, 210, 65, 20);
		lblLeft7.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblLeft7);
		
		lblLeft8 = new JLabel();
		lblLeft8.setBounds(90, 230, 65, 20);
		lblLeft8.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblLeft8);
		
		lblLeft9 = new JLabel();
		lblLeft9.setBounds(90, 250, 65, 20);
		lblLeft9.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblLeft9);
		
		lblLeft10 = new JLabel();
		lblLeft10.setBounds(90, 270, 65, 20);
		lblLeft10.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblLeft10);
		
		lblLeft11 = new JLabel();
		lblLeft11.setBounds(90, 290, 65, 20);
		lblLeft11.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblLeft11);
		
		lblLeft12 = new JLabel();
		lblLeft12.setBounds(90, 310, 65, 20);
		lblLeft12.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblLeft12);
		
		lblLeft13 = new JLabel();
		lblLeft13.setBounds(90, 330, 65, 20);
		lblLeft13.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblLeft13);
		
		lblLeft14 = new JLabel();
		lblLeft14.setBounds(90, 350, 65, 20);
		lblLeft14.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblLeft14);
		
		lblRight15 = new JLabel("Away Team", SwingConstants.CENTER);
		lblRight15.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblRight15.setBounds(430, 60, 125, 28);
		lblRight15.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblRight15);
		
		lblRight1 = new JLabel();
		lblRight1.setBounds(460, 90, 65, 20);
		lblRight1.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblRight1);
		
		lblRight2 = new JLabel();
		lblRight2.setBounds(460, 110, 65, 20);
		lblRight2.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblRight2);
		
		lblRight3 = new JLabel();
		lblRight3.setBounds(460, 130, 65, 20);
		lblRight3.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblRight3);
		
		lblRight4 = new JLabel();
		lblRight4.setBounds(460, 150, 65, 20);
		lblRight4.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblRight4);
		
		lblRight5 = new JLabel();
		lblRight5.setBounds(460, 170, 65, 20);
		lblRight5.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblRight5);
		
		lblRight6 = new JLabel();
		lblRight6.setBounds(460, 190, 65, 20);
		lblRight6.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblRight6);
		
		lblRight7 = new JLabel();
		lblRight7.setBounds(460, 210, 65, 20);
		lblRight7.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblRight7);
		
		lblRight8 = new JLabel();
		lblRight8.setBounds(460, 230, 65, 20);
		lblRight8.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblRight8);
		
		lblRight9 = new JLabel();
		lblRight9.setBounds(460, 250, 65, 20);
		lblRight9.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblRight9);
		
		lblRight10 = new JLabel();
		lblRight10.setBounds(460, 270, 65, 20);
		lblRight10.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblRight10);
		
		lblRight11 = new JLabel();
		lblRight11.setBounds(460, 290, 65, 20);
		lblRight11.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblRight11);
		
		lblRight12 = new JLabel();
		lblRight12.setBounds(460, 310, 65, 20);
		lblRight12.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblRight12);
		
		lblRight13 = new JLabel();
		lblRight13.setBounds(460, 330, 65, 20);
		lblRight13.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblRight13);
		
		lblRight14 = new JLabel();
		lblRight14.setBounds(460, 350, 65, 20);
		lblRight14.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(lblRight14);
		
	}
	
	public void clear() {
		
	}

}
