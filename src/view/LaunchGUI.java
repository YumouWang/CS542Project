package view;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import common.Constants;

public class LaunchGUI extends JFrame implements MouseListener {

	public CardLayout card;
	public static JPanel container;
	public static JPanel panel1;
	public static JPanel panel2;
	public JLabel label;
	public JButton btAdmin;
	public JButton btUser;
	public JButton btSearchPlayer;
	public JButton btSearchClub;
	public JButton btViewGmResult;
	public JButton btBacktoPrev;

	/**
	 * Initialize the contents of the frame.
	 */
	public LaunchGUI() {
		
		setTitle("Version 1.0");

		card = new CardLayout();
		container = new JPanel();
		container.setLayout(card);
		panel1 = new JPanel();
		panel1.setLayout(null);
		panel2 = new JPanel();
		panel2.setLayout(null);
		
		label = new JLabel("Soccer Player&Club&Game Information And Player Rate System", SwingConstants.CENTER);
		label.setBounds(20, 50, 550, 25);
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		panel1.add(label);

		btAdmin = new JButton("Administrator");
		btAdmin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btAdmin.setBounds(Constants.BUTTON_STARTX, 150, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		panel1.add(btAdmin);
		btAdmin.addMouseListener(this);
		
		btUser = new JButton("User");
		btUser.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btUser.setBounds(Constants.BUTTON_STARTX, 220, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		panel1.add(btUser);
		btUser.addMouseListener(this);

		btSearchPlayer = new JButton("Search Player");
		btSearchPlayer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btSearchPlayer.setBounds(Constants.BUTTON_STARTX, 90, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		panel2.add(btSearchPlayer);
		btSearchPlayer.addMouseListener(this);

		btSearchClub = new JButton("Search Club");
		btSearchClub.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btSearchClub.setBounds(Constants.BUTTON_STARTX, 150, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		panel2.add(btSearchClub);
		btSearchClub.addMouseListener(this);

		btViewGmResult = new JButton("View Game Result");
		btViewGmResult.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btViewGmResult.setBounds(Constants.BUTTON_STARTX, 210, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		panel2.add(btViewGmResult);
		btViewGmResult.addMouseListener(this);
		
		btBacktoPrev = new JButton("Back");
		btBacktoPrev.setBounds(20, 10, Constants.BUTTON_WIDTH - 80, Constants.BUTTON_HEIGHT - 10);
		btBacktoPrev.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		panel2.add(btBacktoPrev);
		btBacktoPrev.addMouseListener(this);
		
		setBounds(Constants.X, Constants.Y, Constants.PANEL_WIDTH, Constants.PANEL_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		container.add(panel1, "2");
		container.add(panel2, "3");
		
		ClubSearchView clubSearchView = new ClubSearchView(this);
		container.add(clubSearchView.contentPane, "4");
		
		PlayerSearchView playerSearchView = new PlayerSearchView(this);
		container.add(playerSearchView.contentPane, "5");
		
		GameView gameView = new GameView(this);
		container.add(gameView.contentPane, "6");
		card.show(container, "2");
	}

	public void mouseClicked(MouseEvent e) {

		if (e.getSource() == btAdmin) {
			System.out.println("button Admin pressed ");
			card.show(container, "" + 3);
		}

		if (e.getSource() == btUser) {
			System.out.println("button User pressed ");
			card.show(container, "" + 3);
		}
		
		if (e.getSource() == btBacktoPrev) {
			System.out.println("button Back to pressed ");
			card.show(container, "" + 2);
		}
		
		if (e.getSource() == btSearchPlayer){
			System.out.println("button Search Player pressed ");
			card.show(container, "" + 5);
			this.setTitle("Player Search");
		}
		
		if (e.getSource() == btSearchClub){
			System.out.println("button Search Club pressed ");
			card.show(container, "" + 4);
			this.setTitle("Club Search");
		}
		
		if (e.getSource() == btViewGmResult){
			System.out.println("button View Game Result pressed ");
			card.show(container, "" + 6);
			this.setTitle("Game Result");
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * Launch the Application GUI
	 */
	public static void main(String[] args) {

		LaunchGUI launchGUI = new LaunchGUI();
		launchGUI.add(container);
		launchGUI.setVisible(true);
	}


}
