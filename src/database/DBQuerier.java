package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import common.PlayerHeight;

import entity.Club;
import entity.Player;

public class DBQuerier {
	public List<Player> getPlayerData() throws SQLException {
		List<Player> playerList = new LinkedList<Player>();

		Connection conn = DBConnector.getInstance().getConn();
		Statement statement = conn.createStatement();

		String sql = "select * from player";
		statement.execute(sql);

		ResultSet rs = statement.getResultSet();
		playerList = resultSetToPlayerList(rs);
		return playerList;
	}

	public List<Player> getPlayerData(String name, String position, int age,
			String country, String club, String height) throws SQLException {
		List<Player> playerList = new LinkedList<Player>();
		PreparedStatement pstatement = null;
		Connection conn = DBConnector.getInstance().getConn();
		if (height == null) {
			String sql = "select * from player";
			pstatement = conn.prepareStatement(sql);
			pstatement.execute();

			ResultSet rs = pstatement.getResultSet();
			/*
			 * index 1 : Player name index 2 : Player position index 3 : Player
			 * age index 4 : Player country index 5 : player squad number index
			 * 6 : player club index 7 : player height
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
		} else {
			String minHeight;
			String maxHeight;
			if (height.equals(PlayerHeight.Height1.getPlayerHeight())) {
				String[] heights = height.split("\\<");
				minHeight = "0";
				maxHeight = heights[1].trim();
				System.out.println(minHeight + "," + maxHeight);
				playerList = getPlayerByHeight(Integer.parseInt(minHeight),
						Integer.parseInt(maxHeight));
			} else if (height.equals(PlayerHeight.Height6.getPlayerHeight())) {
				String[] heights = height.split("\\>");
				minHeight = heights[1].trim();
				maxHeight = "250";
				System.out.println(minHeight + "," + maxHeight);
				playerList = getPlayerByHeight(Integer.parseInt(minHeight),
						Integer.parseInt(maxHeight));
			} else {
				String[] heights = height.split("\\~");
				minHeight = heights[0].trim();
				maxHeight = heights[1].trim();
				System.out.println(minHeight + "," + maxHeight);
				playerList = getPlayerByHeight(Integer.parseInt(minHeight),
						Integer.parseInt(maxHeight));
			}
		}
		return playerList;
	}

	public List<Player> getPlayerByPosition(String position)
			throws SQLException {
		List<Player> playerList = new LinkedList<Player>();
		Connection conn = DBConnector.getInstance().getConn();
		String sql = "select * from player where position = ?";
		PreparedStatement pstatement = conn.prepareStatement(sql);
		pstatement.setString(1, position);
		pstatement.execute();

		ResultSet rs = pstatement.getResultSet();
		playerList = resultSetToPlayerList(rs);
		return playerList;
	}

	public List<Player> getPlayerByClub(String club) throws SQLException {
		List<Player> playerList = new LinkedList<Player>();
		Connection conn = DBConnector.getInstance().getConn();
		String sql = "select * from player where club = ?";
		PreparedStatement pstatement = conn.prepareStatement(sql);
		pstatement.setString(1, club.toLowerCase());
		pstatement.execute();

		ResultSet rs = pstatement.getResultSet();
		playerList = resultSetToPlayerList(rs);
		return playerList;
	}

	public List<Player> getPlayerByHeight(int minHeight, int maxHeight)
			throws SQLException {
		List<Player> playerList = new LinkedList<Player>();
		Connection conn = DBConnector.getInstance().getConn();
		String sql = "select * from player where height > ? and height < ?";
		PreparedStatement pstatement = conn.prepareStatement(sql);
		pstatement.setInt(1, minHeight - 1);
		pstatement.setInt(2, maxHeight + 1);
		pstatement.execute();

		ResultSet rs = pstatement.getResultSet();
		playerList = resultSetToPlayerList(rs);
		return playerList;
	}

	public List<Player> getPlayerByAge(int minAge, int maxAge)
			throws SQLException {
		List<Player> playerList = new LinkedList<Player>();
		Connection conn = DBConnector.getInstance().getConn();
		String sql = "select * from player where age > ? and age < ?";
		PreparedStatement pstatement = conn.prepareStatement(sql);
		pstatement.setInt(1, minAge);
		pstatement.setInt(2, maxAge);
		pstatement.execute();

		ResultSet rs = pstatement.getResultSet();
		playerList = resultSetToPlayerList(rs);
		return playerList;
	}

	public Club getClubData(String clubName) throws SQLException {
		Club club = null;
		Connection conn = DBConnector.getInstance().getConn();
		String sql = "select * from club where clubname = ?";
		PreparedStatement pstatement = conn.prepareStatement(sql);
		pstatement.setString(1, clubName);
		pstatement.execute();

		ResultSet rs = pstatement.getResultSet();
		if (rs.next()) {
			String name = rs.getString(1);
			String homeStadium = rs.getString(2);
			String Coach = rs.getString(3);
			int Ranking = rs.getInt(4);
			club = new Club(name, homeStadium, Coach, Ranking);
		}
		return club;
	}

	public boolean isEqual(String str1, String str2) {
		if (str1 == null) {
			return true;
		} else {
			if (str2.toLowerCase().contains(str1.toLowerCase())
					|| str2.equalsIgnoreCase(str1)) {
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

	public List<Player> resultSetToPlayerList(ResultSet rs) throws SQLException {
		List<Player> playerList = new LinkedList<Player>();
		/*
		 * index 1 : Player name index 2 : Player position index 3 : Player age
		 * index 4 : Player country index 5 : player squad number index 6 :
		 * player club index 7 : player height
		 */
		while (rs.next()) {
			String playerName = rs.getString(1);
			String playerPosition = rs.getString(2);
			int playerAge = rs.getInt(3);
			String playerCountry = rs.getString(4);
			int playerSquad_number = rs.getInt(5);
			String playerClub = rs.getString(6);
			int playerHeight = rs.getInt(7);
			Player player = new Player(playerName, playerPosition, playerAge,
					playerCountry, playerSquad_number, playerClub, playerHeight);
			playerList.add(player);
		}
		return playerList;
	}
}
