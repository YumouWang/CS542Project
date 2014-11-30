package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

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
		PlayerView playerView = null;
		try {
			playerView = new PlayerView();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
							playerView.setPlayerView(player);
							playerView.addPicture(player.getName());
							playerView.setVisible(true);
						}
					}
				}
			}
		}
	}
}
