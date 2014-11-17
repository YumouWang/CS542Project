package main;

import java.sql.SQLException;
import java.util.List;

import database.DBQuerier;
import entity.Club;
import entity.Player;

public class SearchMain {
	public static void main(String[] args) {
		List<Player> playerList = null;
		DBQuerier dbQuerier = new DBQuerier();
		Club club = null;
		try {
			//playerList = dbQuerier.getPlayerByPosition("Forward");
			//playerList = dbQuerier.getPlayerData(null, "Forward", 0, null, null);
			//playerList = dbQuerier.getPlayerByClub("real madrid");
			//playerList = dbQuerier.getPlayerByHeight(170, 175);
			playerList = dbQuerier.getPlayerByAge(20, 24);
			club = dbQuerier.getClubData("Real madrid");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Player player : playerList) {
			System.out.println(player.getName() + "," + player.getPosition());
		}
		System.out.println(club.getClubName() + "," + club.getHomeStadium());	
	}

}
