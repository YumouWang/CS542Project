package main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import parser.ClubParser;
import parser.GameParser;
import parser.PlayerParser;
import parser.PlayerStatisticsParser;
import parser.TeamPerformanceParser;
import database.DBUploader;
import entity.Club;
import entity.Game;
import entity.Player;

public class DBUploaderMain {
	public static void main(String[] args) {
		List<Player> playerList = new ArrayList<Player>();
		List<Club> clubList = new ArrayList<Club>();
		List<Game> gameList = new ArrayList<Game>();
		
		DBUploader dbUploader = new DBUploader();
		PlayerParser playerParser = new PlayerParser();
		playerList = playerParser.parse();
		
		ClubParser clubParser = new ClubParser();
		clubList = clubParser.parse();
		
		GameParser gameParser = new GameParser();
		gameList = gameParser.parse();
		
		TeamPerformanceParser teamPerformanceParser = new TeamPerformanceParser();
		
		PlayerStatisticsParser playerStatisticsParser = new PlayerStatisticsParser();
		
//		try {
//			dbUploader.insertPlayerData(playerList);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
//		try {
//			dbUploader.insertClubData(clubList);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		try {
			dbUploader.insertGameData(gameList);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
//		try {
//			dbUploader.insertTeamPerformance(teamPerformanceParser.parse());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
//		try {
//			dbUploader.insertPlayerStatistics(playerStatisticsParser.parse());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
}
