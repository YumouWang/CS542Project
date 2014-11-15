package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import entity.Player;

public class DBQuerier {
	public List<Player> getPlayerData() throws SQLException {
		List<Player> playerList = new LinkedList<Player>();

		Connection conn = DBConnector.getInstance().getConn();
		Statement statement = conn.createStatement();

		String sql = "select * from player";
		statement.execute(sql);

		ResultSet rs = statement.getResultSet();

		/*
		 * index 1 : Player name 
		 * index 2 : Player position 
		 * index 3 : Player age 
		 * index 4 : Player country 
		 * index 5 : player club
		 */
		while (rs.next()) {
			String name = rs.getString(1);
			String position = rs.getString(2);
			int age = rs.getInt(3);
			String country = rs.getString(4);
			int squad_number = rs.getInt(5);
			String club = rs.getString(6);
			int height = rs.getInt(7);
			Player player = new Player(name, position, age, country,
					squad_number, club, height);
			playerList.add(player);
		}
		return playerList;
	}

	public List<Player> getPlayerData(String name, String position, int age,
			String country, String club) throws SQLException {
		List<Player> playerList = new LinkedList<Player>();
		Connection conn = DBConnector.getInstance().getConn();
		String sql = "select * from player";
		PreparedStatement pstatement = conn.prepareStatement(sql);
		pstatement.execute();

		ResultSet rs = pstatement.getResultSet();
		/*
		 * index 1 : Player name 
		 * index 2 : Player position 
		 * index 3 : Player age 
		 * index 4 : Player country 
		 * index 5 : player club
		 */
		while (rs.next()) {
			if (isEqual(name, rs.getString(1))
					&& isEqual(position, (rs.getString(2)))
					&& isEqual(age, rs.getInt(3))
					&& isEqual(country, rs.getString(4))
					&& isEqual(club, rs.getString(6))) {
				String playerName = rs.getString(1);
				String playerPosition = rs.getString(2);
				int playerAge = rs.getInt(3);
				String playerCountry = rs.getString(4);
				int playerSquad_number = rs.getInt(5);
				String playerClub = rs.getString(6);
				int playerHeight = rs.getInt(7);
				Player player = new Player(playerName, playerPosition,
						playerAge, playerCountry, playerSquad_number,
						playerClub, playerHeight);
				playerList.add(player);
			}
		}
		return playerList;
	}

	public boolean isEqual(String str1, String str2) {
		if (str1 == null) {
			return true;
		} else {
			if (str2.contains(str1)) {
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean isEqual(int int1, int int2) {
		if (int1 == 0) {
			return true;
		} else {
			if (int1 == int2) {
				return true;
			} else {
				return false;
			}
		}
	}
}
