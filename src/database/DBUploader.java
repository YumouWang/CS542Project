package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import parser.PlayerStatisticsParser;
import parser.TeamPerformanceParser;
import entity.Club;
import entity.Game;
import entity.Player;

public class DBUploader {
	public boolean insertPlayerData(List<Player> playerList)
			throws SQLException {
		Connection conn = DBConnector.getInstance().getConn();
		boolean isDataValid = false;
		for (Player player : playerList) {
			isDataValid = isDataValid(player);
			if (isDataValid) {
				String playerName = player.getName();
				String position = player.getPosition();
				int age = player.getAge();
				String country = player.getCountry();
				int squad_number = player.getSquad_number();
				String club = player.getClub();
				int height = player.getHeight();

				String sql = "insert into player values(?, ?, ?, ?, ?, ?, ?) ";
				PreparedStatement pstatement = conn.prepareStatement(sql);
				pstatement.setString(1, playerName); // set parameter 1
														// (playerName)
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

	public static boolean isDataValid(Player player) {
		return !player.getClub().isEmpty() && !(player.getSquad_number() == 0);
	}

	public static boolean isDataValid(Club club) {
		return !club.getClubName().isEmpty();
	}

	public static boolean isDataValid(Game game) {
		return true;
	}

	public boolean insertClubData(List<Club> clubList) throws SQLException {
		Connection conn = DBConnector.getInstance().getConn();
		boolean isDataValid = false;
		for (Club club : clubList) {
			isDataValid = isDataValid(club);
			if (isDataValid) {
				String clubName = club.getClubName();
				String homeStadium = club.getHomeStadium();
				String coach = club.getCoach();
				int ranking = club.getRanking();

				String sql = "insert into club values(?, ?, ?, ?) ";
				PreparedStatement pstatement = conn.prepareStatement(sql);
				pstatement.setString(1, clubName); // set parameter 1
													// (playerName)
				pstatement.setString(2, homeStadium); // set parameter 2
														// (position)
				pstatement.setString(3, coach);
				pstatement.setInt(4, ranking);
				pstatement.execute();
			} else {
				System.out.println("Invalid data!");
			}
		}
		return true;
	}

	public boolean insertGameData(List<Game> gameList) throws SQLException {
		Connection conn = DBConnector.getInstance().getConn();
		boolean isDataValid = false;
		for (Game game : gameList) {
			isDataValid = isDataValid(game);
			if (isDataValid) {
				int GameId = game.getGameId();
				String HomeTeam = game.getHomeTeam();
				String AwayTeam = game.getAwayTeam();
				String date = game.getDate();

				String sql = "insert into game values(?, ?, ?, ?) ";
				PreparedStatement pstatement = conn.prepareStatement(sql);
				pstatement.setInt(1, GameId); // set parameter 1 (playerName)
				pstatement.setString(2, HomeTeam); // set parameter 2 (position)
				pstatement.setString(3, AwayTeam);
				pstatement.setString(4, date);
				pstatement.execute();

			} else {
				System.out.println("Invalid data!");

			}
		}
		return true;
	}

	public boolean insertTeamPerformance(
			List<List<String>> teamPerformanceList) throws SQLException {
		Connection conn = DBConnector.getInstance().getConn();
		for (List<String> teamPerformance : teamPerformanceList) {
			System.out.println(teamPerformance.get(0) + "---");
			System.out.println(teamPerformance.get(1) + "---");
			System.out.println(teamPerformance.get(2) + "---");

			// System.out.println(gameId + "," + team);
			String sql = "insert into teamPerformance values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			PreparedStatement pstatement = conn.prepareStatement(sql);
			pstatement.setInt(1, Integer.parseInt(teamPerformance.get(0))); // set parameter 1 
			pstatement.setString(2, teamPerformance.get(1)); // set parameter 2 
			pstatement.setInt(3, Integer.parseInt(teamPerformance.get(2)));
			pstatement.setInt(4, Integer.parseInt(teamPerformance.get(3)));
			pstatement.setInt(5, Integer.parseInt(teamPerformance.get(4)));
			pstatement.setInt(6, Integer.parseInt(teamPerformance.get(5)));
			pstatement.setInt(7, Integer.parseInt(teamPerformance.get(6)));
			pstatement.setInt(8, Integer.parseInt(teamPerformance.get(7)));
			pstatement.setInt(9, Integer.parseInt(teamPerformance.get(8)));
			pstatement.setInt(10, Integer.parseInt(teamPerformance.get(9)));
			pstatement.setInt(11, Integer.parseInt(teamPerformance.get(10)));
			pstatement.setInt(12, Integer.parseInt(teamPerformance.get(11)));
			pstatement.setInt(13, Integer.parseInt(teamPerformance.get(12)));
			pstatement.setInt(14, Integer.parseInt(teamPerformance.get(13)));
			pstatement.setInt(15, Integer.parseInt(teamPerformance.get(14)));
			pstatement.setInt(16, Integer.parseInt(teamPerformance.get(15)));
			pstatement.execute();
		}
		return true;
	}
	
	public boolean insertPlayerStatistics(List<List<String>> playerStatisticsList) throws SQLException {
		Connection conn = DBConnector.getInstance().getConn();
		for (List<String> playerStatistics : playerStatisticsList) {

			// System.out.println(gameId + "," + team);
			String sql = "insert into PlayerStatistics values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			PreparedStatement pstatement = conn.prepareStatement(sql);
			pstatement.setInt(1, Integer.parseInt(playerStatistics.get(0))); // set parameter 1
			pstatement.setString(2, playerStatistics.get(1)); // set parameter 2
			pstatement.setInt(3, Integer.parseInt(playerStatistics.get(2)));
			pstatement.setString(4, playerStatistics.get(3));
			pstatement.setInt(5, Integer.parseInt(playerStatistics.get(4)));
			pstatement.setInt(6, Integer.parseInt(playerStatistics.get(5)));
			pstatement.setInt(7, Integer.parseInt(playerStatistics.get(6)));
			pstatement.setInt(8, Integer.parseInt(playerStatistics.get(7)));
			pstatement.setInt(9, Integer.parseInt(playerStatistics.get(8)));
			pstatement.setInt(10, Integer.parseInt(playerStatistics.get(9)));
			pstatement.setInt(11, Integer.parseInt(playerStatistics.get(10)));
			pstatement.setFloat(12, Float.parseFloat(playerStatistics.get(11)));
			pstatement.execute();
		}
		return true;
	}

	public static void main(String[] args) throws SQLException {
		TeamPerformanceParser t = new TeamPerformanceParser();
		System.out.println(t.parse().size());
		
		PlayerStatisticsParser p = new PlayerStatisticsParser();
		System.out.println(p.parse().size() + "//");
		for(List<String> list : p.parse()) {
			for(String str : list) {
				System.out.print(str + ",");
			}
			System.out.println();
		}
	}

}
