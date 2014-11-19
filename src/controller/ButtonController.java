package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JTextField;

import view.ClubSearchView;
import database.DBQuerier;
import entity.Club;
import entity.Player;

public class ButtonController implements ActionListener {
	private ClubSearchView clubSearchView;
	Collection<Player> playerList;
	Club club;

	public ButtonController(ClubSearchView clubSearchView) {
		this.clubSearchView = clubSearchView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DBQuerier dbQuerier = new DBQuerier();
		JButton clickedButton = null;
		JTextField clickedTextField = null;
		if (e.getSource() instanceof JButton) {
			// click on Search button
			clickedButton = (JButton) e.getSource();
			if (clickedButton.equals(clubSearchView.getBtnSearch())) {
				// update club information
				club = null;
				try {
					club = dbQuerier.getClubData(clubSearchView.getTextField()
							.getText());
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				if(club != null) {
					clubSearchView.getTextFieldClubName().setText(
							club.getClubName());
					clubSearchView.getTextFieldHomeStaduim().setText(
							club.getHomeStadium());
					clubSearchView.getTextFieldCoach().setText(club.getCoach());
					clubSearchView.getTextFieldRanking().setText(
							String.valueOf(club.getRanking()));
				} else {
					clubSearchView.getTextFieldClubName().setText(null);
					clubSearchView.getTextFieldHomeStaduim().setText(null);
					clubSearchView.getTextFieldCoach().setText(null);
					clubSearchView.getTextFieldRanking().setText(null);
				}
				
				// update player list table
				playerList = null;
				// playerList.clear();
				try {
					playerList = dbQuerier.getPlayerByClub(clubSearchView
							.getTextField().getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				for (Player player : playerList) {
					System.out.println(player.getName() + ","
							+ player.getSquad_number());
				}
				updateTable(playerList);
			}
		}

		if (e.getSource() instanceof JButton) {
			// click on Back button
			clickedButton = (JButton) e.getSource();
			if (clickedButton.equals(clubSearchView.btnBack)) {
				clubSearchView.card.show(ClubSearchView.container, "" + 3);
				clubSearchView.launchGUI.setTitle("Version 1.0");
			}
		}

		if (e.getSource() instanceof JTextField) {
			// press enter on search bar
			clickedTextField = (JTextField) e.getSource();
			if (clickedTextField.equals(clubSearchView.getTextField())) {
				// update club information
				club = null;
				try {
					club = dbQuerier.getClubData(clubSearchView.getTextField()
							.getText());
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				if(club != null) {
					clubSearchView.getTextFieldClubName().setText(
							club.getClubName());
					clubSearchView.getTextFieldHomeStaduim().setText(
							club.getHomeStadium());
					clubSearchView.getTextFieldCoach().setText(club.getCoach());
					clubSearchView.getTextFieldRanking().setText(
							String.valueOf(club.getRanking()));
				} else {
					clubSearchView.getTextFieldClubName().setText(null);
					clubSearchView.getTextFieldHomeStaduim().setText(null);
					clubSearchView.getTextFieldCoach().setText(null);
					clubSearchView.getTextFieldRanking().setText(null);
				}

				// update player list table
				playerList = null;
				try {
					playerList = dbQuerier.getPlayerByClub(clubSearchView
							.getTextField().getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				for (Player player : playerList) {
					System.out.println(player.getName() + ","
							+ player.getSquad_number());
				}
				updateTable(playerList);
			}
		}
	}

	public void updateTable(Collection<Player> playerList) {

		Collection<Player> result = playerList;
		if (result.size() == 0) {
			for (int rowNum = 0; rowNum < clubSearchView.cellData.length; rowNum++) {
				clubSearchView.getTable().setValueAt(null, rowNum, 0);
				clubSearchView.getTable().setValueAt(null, rowNum, 1);
				clubSearchView.getTable().updateUI();
			}
		} else {
			for (int rowNum = 0; rowNum < clubSearchView.cellData.length; rowNum++) {
				clubSearchView.getTable().setValueAt(null, rowNum, 0);
				clubSearchView.getTable().setValueAt(null, rowNum, 1);
				// cellData[rowNum][0] = null;
				// cellData[rowNum][1] = null;
			}
			int i = 0;
			for (Player player : result) {
				// cellData[i][0] = word.getValue();
				// cellData[i][1] = ((Word) word).getType().toString();
				clubSearchView.getTable().setValueAt(player.getSquad_number(),
						i, 0);
				clubSearchView.getTable().setValueAt(
						player.getName().toString(), i, 1);
				i++;
			}
			clubSearchView.getTable().updateUI();
		}
	}

	public Collection<Player> getPlayerList() {
		return playerList;
	}
}
