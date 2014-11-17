package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

import view.ClubSearchView;
import view.PlayerView;
import entity.Player;

public class MouseController extends MouseAdapter {
	ClubSearchView mainGUI;
	ButtonController buttonController;

	public MouseController(ClubSearchView mainGUI, ButtonController buttonController) {
		this.mainGUI = mainGUI;
		this.buttonController = buttonController;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		PlayerView playerView = new PlayerView();
		// playerView.dispose();
		if (e.getClickCount() == 2) {

			JTable table = null;
			table = (JTable) e.getSource();
			int row = table.getSelectedRow();
			if(table.getValueAt(row, 0) != null) {
				String selectedPlayerNumber = table.getValueAt(row, 0).toString();
				if (row > -1) {
					for (Player player : buttonController.getPlayerList()) {
						if (player.getSquad_number() == Integer
								.parseInt(selectedPlayerNumber)) {
							System.out.println(player.getClub() + ","
									+ player.getName());
							playerView.getTextFieldPlayerName().setText(
									player.getName());
							playerView.getTextFieldAge().setText(
									String.valueOf(player.getAge()));
							playerView.getTextFieldPosition().setText(
									player.getPosition());
							playerView.getTextFieldClub().setText(player.getClub());
							playerView.getTextFieldHeight().setText(
									String.valueOf(player.getHeight()));
							playerView.getTextFieldSquadNumber().setText(
									String.valueOf(player.getSquad_number()));
							playerView.getTextFieldCountry().setText(
									player.getCountry());
							playerView.setVisible(true);
						}
					}
				}
			}
		}
	}
}
