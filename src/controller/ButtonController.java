package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JTextField;

import view.MainGUI;
import database.DBQuerier;
import entity.Player;

public class ButtonController implements ActionListener {
	private MainGUI mainGUI;
	Collection<Player> playerList;

	public ButtonController(MainGUI mainGUI) {
		this.mainGUI = mainGUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = null;
		JTextField clickedTextField = null;
		if (e.getSource() instanceof JButton) {
			// click on Search button
			clickedButton = (JButton) e.getSource();
			if (clickedButton.equals(mainGUI.getBtnSearch())) {
				playerList = null;
				DBQuerier dbQuerier = new DBQuerier();
				try {
					playerList = dbQuerier.getPlayerData(null, null, 0, null,
							mainGUI.getTextField().getText());
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

		if (e.getSource() instanceof JTextField) {
			// press enter on search bar
			clickedTextField = (JTextField) e.getSource();
			if (clickedTextField.equals(mainGUI.getTextField())) {
				playerList = null;
				DBQuerier dbQuerier = new DBQuerier();
				try {
					playerList = dbQuerier.getPlayerData(null, null, 0, null,
							mainGUI.getTextField().getText());
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

		for (int rowNum = 0; rowNum < mainGUI.cellData.length; rowNum++) {
			mainGUI.getTable().setValueAt(null, rowNum, 0);
			mainGUI.getTable().setValueAt(null, rowNum, 1);
			// cellData[rowNum][0] = null;
			// cellData[rowNum][1] = null;
		}
		int i = 0;
		for (Player player : result) {
			// cellData[i][0] = word.getValue();
			// cellData[i][1] = ((Word) word).getType().toString();
			mainGUI.getTable().setValueAt(player.getSquad_number(), i, 0);
			mainGUI.getTable().setValueAt(player.getName().toString(), i, 1);
			i++;
		}
		mainGUI.getTable().updateUI();
	}

	public Collection<Player> getPlayerList() {
		return playerList;
	}
}
