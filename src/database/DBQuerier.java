package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import common.PlayerAge;
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

	public List<Player> getPlayerData(String name, String position, String age,
			String country, String club, String height) throws SQLException {
		List<Player> playerList = new LinkedList<Player>();
		PreparedStatement pstatement = null;
		Connection conn = DBConnector.getInstance().getConn();
		String sql = "select * from player";
		pstatement = conn.prepareStatement(sql);
		pstatement.execute();

		ResultSet rs = pstatement.getResultSet();
		/*
		 * index 1 : Player name index 2 : Player position index 3 : Player age
		 * index 4 : Player country index 5 : player squad number index 6 :
		 * player club index 7 : player height
		 */
		while (rs.next()) {
			if (isEqual(name, rs.getString(1))
					&& isEqual(position, (rs.getString(2)))
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
		if (height == null && age == null) {
			return playerList;
		} else if (height != null && age == null) {
			int intHeights[] = splitHeight(height);
			playerList = getPlayerByHeight(intHeights[0], intHeights[1],
					playerList);
			return playerList;
		} else if (height == null && age != null) {
			int intAges[] = splitAge(age);
			playerList = getPlayerByAge(intAges[0], intAges[1], playerList);
			return playerList;
		} else {
			int intHeights[] = splitHeight(height);
			playerList = getPlayerByHeight(intHeights[0], intHeights[1],
					playerList);
			int intAges[] = splitAge(age);
			playerList = getPlayerByAge(intAges[0], intAges[1], playerList);
			return playerList;
		}
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
		pstatement.setString(1, addSpace(club));
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

	public List<Player> getPlayerByHeight(int minHeight, int maxHeight,
			List<Player> playerList) {
		List<Player> temp = new LinkedList<Player>();
		for (Player player : playerList) {
			if (player.getHeight() >= minHeight
					&& player.getHeight() <= maxHeight) {
				temp.add(player);
			}
		}
		return temp;
	}

	public List<Player> getPlayerByAge(int minAge, int maxAge,
			List<Player> playerList) {
		List<Player> temp = new LinkedList<Player>();
		for (Player player : playerList) {
			if (player.getAge() >= minAge && player.getAge() <= maxAge) {
				temp.add(player);
			}
		}
		return temp;
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
	
	public String getPlayerPosition(String club, int squadNumber) throws SQLException {
		String position = null;
		Connection conn = DBConnector.getInstance().getConn();
		String sql = "select position from player where club = ? and squad_number = ?";
		PreparedStatement pstatement = conn.prepareStatement(sql);
		pstatement.setString(1, addSpace(club));
		pstatement.setInt(2, squadNumber);
		pstatement.execute();

		ResultSet rs = pstatement.getResultSet();
		while (rs.next()) {
			position = rs.getString(1);
		}
		return position;
	}

	public double getClubAverageAge(String club) throws SQLException {
		double averageAge = 0;
		PreparedStatement pstatement = null;
		Connection conn = DBConnector.getInstance().getConn();
		String sql = "select club, avg(age) from player group by club";
		pstatement = conn.prepareStatement(sql);
		pstatement.execute();

		ResultSet rs = pstatement.getResultSet();
		/*
		 * index 1 : Club name index 2 : Players average age
		 */
		while (rs.next()) {
			if (rs.getString(1).trim().equalsIgnoreCase(club)) {
				averageAge = (double) (Math.round(rs.getDouble(2) * 100) / 100.0);
			}
		}
		return averageAge;
	}

	public double getClubAverageHeight(String club) throws SQLException {
		double averageHeight = 0;
		PreparedStatement pstatement = null;
		Connection conn = DBConnector.getInstance().getConn();
		String sql = "select club, avg(height) from player group by club";
		pstatement = conn.prepareStatement(sql);
		pstatement.execute();

		ResultSet rs = pstatement.getResultSet();
		/*
		 * index 1 : Club name index 2 : Players average height
		 */
		while (rs.next()) {
			if (rs.getString(1).trim().equalsIgnoreCase(club)) {
				averageHeight = (double) (Math.round(rs.getDouble(2) * 100) / 100.0);
			}
		}
		return averageHeight;
	}

	public Club getClubData(String clubName) throws SQLException {
		Club club = null;
		Connection conn = DBConnector.getInstance().getConn();
		String sql = "select * from club where clubname = ?";
		
		PreparedStatement pstatement = conn.prepareStatement(sql);
		pstatement.setString(1, addSpace(clubName));
		pstatement.executeQuery();

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

	public int getGameId(String homeTeam, String awayTeam, String gameDate) throws SQLException {
		int gameId = 0;
		Connection conn = DBConnector.getInstance().getConn();
		String sql = "select GameId from game where homeTeam = ? and awayTeam = ? and gameDate = ?";
		PreparedStatement pstatement = conn.prepareStatement(sql);
		pstatement.setString(1, addSpace(homeTeam));
		pstatement.setString(2, addSpace(awayTeam));
		pstatement.setString(3, addSpaceToDate(gameDate));
		pstatement.execute();

		ResultSet rs = pstatement.getResultSet();
		if (rs.next()) {
			gameId = rs.getInt(1);
		}
		return gameId;
	}

	public ResultSet getTeamDataByGameId(int id, String team)
			throws SQLException {
		Connection conn = DBConnector.getInstance().getConn();
		String sql = "select * from teamPerformance where gameId = ? and team = ?";
		PreparedStatement pstatement = conn.prepareStatement(sql);
		pstatement.setInt(1, id);
		pstatement.setString(2, addSpace(team));
		pstatement.execute();

		ResultSet rs = pstatement.getResultSet();

		return rs;
	}

	public ResultSet getGameByTeam(String team) throws SQLException {
		Connection conn = DBConnector.getInstance().getConn();
		String sql = "select * from game where HomeTeam = ? or AwayTeam = ?";
		PreparedStatement pstatement = conn.prepareStatement(sql);
		pstatement.setString(1, addSpace(team));
		pstatement.setString(2, addSpace(team));
		pstatement.execute();

		ResultSet rs = pstatement.getResultSet();

		return rs;
	}
	
	public ResultSet getPlayerStatisticsByGameId(int gameId) throws SQLException {
		Connection conn = DBConnector.getInstance().getConn();
		String sql = "select * from PlayerStatistics where gameId = ?";
		PreparedStatement pstatement = conn.prepareStatement(sql);
		pstatement.setInt(1, gameId);
		pstatement.execute();

		ResultSet rs = pstatement.getResultSet();
		return rs;
	}
	
	public ResultSet getLoginInfo(String username, String password) throws SQLException {
		Connection conn = DBConnector.getInstance().getConn();
		String sql = "select * from Admin where username = ? and password = ?";
		PreparedStatement pstatement = conn.prepareStatement(sql);
		pstatement.setString(1, username);
		pstatement.setString(2, password);
		pstatement.execute();
		ResultSet rs = pstatement.getResultSet();
		return rs;
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

	public List<Player> intersection(List<Player> playerList1,
			List<Player> playerList2) {
		List<Player> list = new LinkedList<Player>();
		for (Player player : playerList1) {
			if (playerList2.contains(player)) {
				list.add(player);
			}
		}
		return list;
	}

	public int[] splitHeight(String height) {
		String minHeight;
		String maxHeight;
		String[] heights = new String[2];
		int[] intHeights = new int[2];
		if (height.equals(PlayerHeight.Height1.getPlayerHeight())) {
			heights = height.split("\\<");
			minHeight = "0";
			maxHeight = heights[1];
			intHeights[0] = Integer.parseInt(minHeight);
			intHeights[1] = Integer.parseInt(maxHeight.trim()) - 1;

		} else if (height.equals(PlayerHeight.Height6.getPlayerHeight())) {
			heights = height.split("\\>");
			minHeight = heights[1];
			maxHeight = "250";
			intHeights[0] = Integer.parseInt(minHeight.trim()) + 1;
			intHeights[1] = Integer.parseInt(maxHeight);
		} else {
			heights = height.split("\\~");
			minHeight = heights[0].trim();
			maxHeight = heights[1].trim();
			intHeights[0] = Integer.parseInt(minHeight);
			intHeights[1] = Integer.parseInt(maxHeight);
		}
		return intHeights;
	}

	public int[] splitAge(String age) {
		String minAge;
		String maxAge;
		String[] ages = new String[2];
		int[] intAges = new int[2];
		if (age.equals(PlayerAge.Age1.getPlayerAge())) {
			ages = age.split("\\<");
			minAge = "0";
			maxAge = ages[1];
			intAges[0] = Integer.parseInt(minAge);
			intAges[1] = Integer.parseInt(maxAge.trim()) - 1;

		} else if (age.equals(PlayerAge.Age5.getPlayerAge())) {
			ages = age.split("\\>");
			minAge = ages[1];
			maxAge = "250";
			intAges[0] = Integer.parseInt(minAge.trim()) + 1;
			intAges[1] = Integer.parseInt(maxAge);
		} else {
			ages = age.split("\\~");
			minAge = ages[0].trim();
			maxAge = ages[1].trim();
			intAges[0] = Integer.parseInt(minAge);
			intAges[1] = Integer.parseInt(maxAge);
		}
		return intAges;
	}
	
	public String addSpace(String str) {
		int length = str.length();
		for(int i = 0; i < 50 - length; i++) {
			str = str + " ";
		}	
		return str;
	}
	
	public String addSpaceToDate(String str) {
		int length = str.length();
		for(int i = 0; i < 20 - length; i++) {
			str = str + " ";
		}	
		return str;
	}
	
	public void test() throws SQLException {
		Connection conn = DBConnector.getInstance().getConn();
		String sql = "select * from game";
		PreparedStatement pstatement = conn.prepareStatement(sql);
//		pstatement.setString(1, username);
//		pstatement.setString(2, password);
		pstatement.execute();
		ResultSet rs = pstatement.getResultSet();
		while(rs.next()) {
			System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) + rs.getString(4) + "!!");
		}
	}
	
	public static void main(String[] args) throws SQLException {
		String str = "Barcelona";
		DBQuerier d = new DBQuerier();
		Club club = null;
		ResultSet rs = null;
		try {
			rs = d.getGameByTeam(str);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(rs.next()) {
			System.out.println(rs.getInt(1));
		}
		
		d.test();

	}
	
}
