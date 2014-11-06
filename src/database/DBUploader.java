package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import entity.Player;

public class DBUploader {
	public boolean insertPlayerData(List<Player> playerList) throws SQLException {
		Connection conn = DBConnector.getInstance().getConn();
		boolean isDataValid = false;
		for(Player player : playerList) {
			isDataValid = isDataValid(player);
			if(isDataValid){
				String playerName = player.getName();
				String position = player.getPosition();
				int age = player.getAge();
				String country = player.getCountry();
				int squad_number = player.getSquad_number();
				String club = player.getClub();
				int height = player.getHeight();
				
				String sql = "insert into player values(?, ?, ?, ?, ?, ?, ?) ";
				PreparedStatement pstatement = conn.prepareStatement(sql);
				pstatement.setString(1, playerName); // set parameter 1 (playerName)
				pstatement.setString(2, position); // set parameter 2 (position)
				pstatement.setInt(3, age);
				pstatement.setString(4, country);
				pstatement.setInt(5, squad_number);
				pstatement.setString(6, club);
				pstatement.setInt(7, height);
				pstatement.execute();
				
			} else {
				System.out.println("Invalid data!");
				
			}	
		}
		return true;
	}

	public static boolean isDataValid(Player player){
		return !player.getClub().isEmpty() && !(player.getSquad_number() == 0);
	}

}
