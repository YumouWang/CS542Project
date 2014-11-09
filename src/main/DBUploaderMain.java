package main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import parser.PlayerParser;
import database.DBUploader;
import entity.Player;

public class DBUploaderMain {
	public static void main(String[] args) {
		List<Player> playerList = new ArrayList<Player>();
		DBUploader dbUploader = new DBUploader();
		PlayerParser playerParser = new PlayerParser();
		playerList = playerParser.parse();
		
		try {
			dbUploader.insertPlayerData(playerList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
