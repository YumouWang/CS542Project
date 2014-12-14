package view;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import common.Constants;
import controller.Login;

public class LoginView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CardLayout card;
	public static JPanel container;
	public LaunchGUI launchGUI;

	public JPanel contentPane;
	public JTextField textField_1;
	public JPasswordField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			LaunchGUI launchGUI = new LaunchGUI();

			public void run() {
				try {
					LoginView frame = new LoginView(launchGUI);
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
	public LoginView(final LaunchGUI launchGUI) {
		this.launchGUI = launchGUI;
		this.card = launchGUI.card;
		LoginView.container = LaunchGUI.container;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Constants.X, Constants.Y, Constants.PANEL_WIDTH,
				Constants.PANEL_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("Administrator Login",
				SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblLogin.setBounds(0, 66, Constants.PANEL_WIDTH,
				Constants.BUTTON_HEIGHT);
		// lblLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(lblLogin);

		JLabel lblUsername = new JLabel("Username", SwingConstants.CENTER);
		lblUsername.setBounds(140, 147, 86, Constants.BUTTON_HEIGHT - 5);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password", SwingConstants.CENTER);
		lblPassword.setBounds(140, 200, 86, Constants.BUTTON_HEIGHT - 5);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(lblPassword);

		textField_1 = new JTextField();
		textField_1.setBounds(260, 147, 167, Constants.BUTTON_HEIGHT - 5);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					verify();
				}
			}
		});

		textField_2 = new JPasswordField();
		textField_2.setBounds(260, 200, 167, Constants.BUTTON_HEIGHT - 5);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					verify();
				}
			}
		});

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(260, 260, Constants.BUTTON_WIDTH - 80,
				Constants.BUTTON_HEIGHT - 5);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(btnLogin);

		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				verify();
			}
		});

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(20, 10, Constants.BUTTON_WIDTH - 80,
				Constants.BUTTON_HEIGHT - 10);
		btnBack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(btnBack);

		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(container, "" + 2);
				launchGUI.setTitle("Version 1.0");
			}
		});

	}

	@SuppressWarnings("deprecation")
	public void verify() {
		String username = textField_1.getText().trim();
		String password = textField_2.getText().trim();
		if (Login.authenticate(username, password)) {
//			JOptionPane.showMessageDialog(null,
//					"! You have successfully logged in.", "Login",
//					JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null,
					"! You have successfully logged in.", "Login",
					JOptionPane.INFORMATION_MESSAGE);
			card.show(container, "" + 3);
			this.launchGUI.clubSearchView.updatable();;
			this.launchGUI.clubSearchView.clear();
			this.launchGUI.playerSearchView.clear();
			this.launchGUI.gameView.clear();
			launchGUI.setTitle("Version 1.0");
			
		} else {
			JOptionPane.showMessageDialog(null,
					"Administrator name and password do not match!", "ALERT!",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
