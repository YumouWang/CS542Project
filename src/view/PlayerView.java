package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import common.Club;
import common.Constants;
import common.PlayerPosition;

import database.DBUpdater;
import entity.Player;

public class PlayerView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	private JTextField textFieldPlayerName;
	private JTextField textFieldAge;
	private JTextField textFieldPosition;
	private JTextField textFieldCountry;
	private JTextField textFieldClub;
	private JTextField textFieldHeight;
	private JTextField textFieldSquadNumber;
	private JLabel picLabel;
	private JButton btnUpdate;

	LaunchGUI launchGUI;

	/**
	 * @return the textFieldPlayerName
	 */
	public JTextField getTextFieldPlayerName() {
		return textFieldPlayerName;
	}

	/**
	 * @return the textFieldAge
	 */
	public JTextField getTextFieldAge() {
		return textFieldAge;
	}

	/**
	 * @return the textFieldPosition
	 */
	public JTextField getTextFieldPosition() {
		return textFieldPosition;
	}

	/**
	 * @return the textFieldCountry
	 */
	public JTextField getTextFieldCountry() {
		return textFieldCountry;
	}

	/**
	 * @return the textFieldClub
	 */
	public JTextField getTextFieldClub() {
		return textFieldClub;
	}

	/**
	 * @return the textFieldHeight
	 */
	public JTextField getTextFieldHeight() {
		return textFieldHeight;
	}

	/**
	 * @return the textFieldSquadNumber
	 */
	public JTextField getTextFieldSquadNumber() {
		return textFieldSquadNumber;
	}

	/**
	 * @param textFieldSquadNumber
	 *            the textFieldSquadNumber to set
	 */
	public void setTextFieldSquadNumber(JTextField textFieldSquadNumber) {
		this.textFieldSquadNumber = textFieldSquadNumber;
	}

	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LaunchGUI launchGUI = new LaunchGUI();
					PlayerView frame = new PlayerView(launchGUI);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public PlayerView(final LaunchGUI launchGUI) throws IOException {
		this.launchGUI = launchGUI;
		setTitle("Player Profile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 391, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPlayerName = new JLabel("Player Name", SwingConstants.CENTER);
		lblPlayerName.setBounds(10, 10, 77, 21);
		contentPane.add(lblPlayerName);

		JLabel lblPosition = new JLabel("Position", SwingConstants.CENTER);
		lblPosition.setBounds(10, 50, 77, 21);
		contentPane.add(lblPosition);

		JLabel labelAge = new JLabel("Age", SwingConstants.CENTER);
		labelAge.setBounds(200, 10, 67, 21);
		contentPane.add(labelAge);

		JLabel labelCountry = new JLabel("Country", SwingConstants.CENTER);
		labelCountry.setBounds(200, 50, 67, 21);
		contentPane.add(labelCountry);

		JLabel labelClub = new JLabel("Club", SwingConstants.CENTER);
		labelClub.setBounds(10, 90, 77, 21);
		contentPane.add(labelClub);

		JLabel labelHeight = new JLabel("Height(cm)", SwingConstants.CENTER);
		labelHeight.setBounds(200, 90, 67, 21);
		contentPane.add(labelHeight);

		JLabel labelSquadNumber = new JLabel("Squad Number");
		labelSquadNumber.setBounds(10, 130, 94, 21);
		contentPane.add(labelSquadNumber);

		textFieldPlayerName = new JTextField();
		textFieldPlayerName.setBounds(91, 10, 106, 21);
		textFieldPlayerName.setEditable(false);
		textFieldPlayerName.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(textFieldPlayerName);

		textFieldAge = new JTextField();
		textFieldAge.setBounds(279, 10, 77, 21);
		textFieldAge.setHorizontalAlignment(JTextField.CENTER);
		textFieldAge.setEditable(false);

		contentPane.add(textFieldAge);

		textFieldPosition = new JTextField();
		textFieldPosition.setBounds(91, 50, 106, 21);
		textFieldPosition.setHorizontalAlignment(JTextField.CENTER);
		textFieldPosition.setEditable(false);
		contentPane.add(textFieldPosition);

		textFieldCountry = new JTextField();
		textFieldCountry.setBounds(279, 50, 77, 21);
		textFieldCountry.setHorizontalAlignment(JTextField.CENTER);
		textFieldCountry.setEditable(false);
		contentPane.add(textFieldCountry);

		textFieldClub = new JTextField();
		textFieldClub.setBounds(91, 90, 106, 21);
		textFieldClub.setHorizontalAlignment(JTextField.CENTER);
		textFieldClub.setEditable(false);
		contentPane.add(textFieldClub);

		textFieldHeight = new JTextField();
		textFieldHeight.setBounds(279, 90, 77, 21);
		textFieldHeight.setHorizontalAlignment(JTextField.CENTER);
		textFieldHeight.setEditable(false);
		contentPane.add(textFieldHeight);

		textFieldSquadNumber = new JTextField();
		textFieldSquadNumber.setBounds(114, 130, 83, 21);
		textFieldSquadNumber.setHorizontalAlignment(JTextField.CENTER);
		textFieldSquadNumber.setEditable(false);
		contentPane.add(textFieldSquadNumber);

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(100, 200, Constants.BUTTON_WIDTH - 80,
				Constants.BUTTON_HEIGHT - 10);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));

		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textFieldPlayerName.getText().equals(null)) {
					// cannot update
				} else {
					// update
					String playerName = textFieldPlayerName.getText()
							.toString();
					int age = Integer.parseInt(textFieldAge.getText());
					String position = textFieldPosition.getText().toString();
					String country = textFieldCountry.getText().toString();
					String club = textFieldClub.getText().toString();
					int height = Integer.parseInt(textFieldHeight.getText());
					int squadNumber = Integer.parseInt(textFieldSquadNumber
							.getText());
					DBUpdater dbUpdater = new DBUpdater();
					try {
						dbUpdater.updatePlayer(playerName, position, age,
								country, squadNumber, club, height);

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});

		if (launchGUI.isAdmin) {
			contentPane.add(btnUpdate);
			btnUpdate.setVisible(true);
			textFieldPosition.setEditable(true);
			textFieldClub.setEditable(true);
			textFieldSquadNumber.setEditable(true);
		} else {
			btnUpdate.setVisible(false);
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void setPlayerView(Player player) {
		textFieldPlayerName.setText(player.getName());
		textFieldAge.setText(String.valueOf(player.getAge()));
		textFieldPosition.setText(player.getPosition());
		textFieldClub.setText(player.getClub());
		textFieldHeight.setText(String.valueOf(player.getHeight()));
		textFieldSquadNumber.setText(String.valueOf(player.getSquad_number()));
		textFieldCountry.setText(player.getCountry());
	}

	public void addPicture(String playerName) {
		String str = playerName.trim().replaceAll(" ", "").toLowerCase();
		BufferedImage playerPic = null;
		BufferedImage defaultPic = null;
		try {
			defaultPic = ImageIO.read(new File("pic/images.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		;
		try {
			playerPic = ImageIO.read(new File("pic/" + str + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		if (playerPic != null) {
			picLabel = new JLabel(new ImageIcon(playerPic));
			picLabel.setBounds(225, 125, 100, 120);
			getContentPane().add(picLabel);
		} else {
			picLabel = new JLabel(new ImageIcon(defaultPic));
			picLabel.setBounds(225, 125, 100, 120);
			picLabel.setBackground(Color.LIGHT_GRAY);
			picLabel.setOpaque(true);
			getContentPane().add(picLabel);
		}
	}

	public boolean isValidUpdate(String position, String club, int squadNumber) {
		boolean isValid = false;
		for (PlayerPosition p : PlayerPosition.values()) {
			System.out.println(p);
			if (p.name().equals(p)) {
				isValid = true;
			}
		}

		if (isValid) {
			for (Club c : Club.values()) {
				System.out.println(c);
				if (c.name().equals(club)) {
					isValid = true;
				}
			}

			if (isValid) {
				if (squadNumber > 0) {
					isValid = true;
				}
			}
		}
		return isValid;
	}
}
