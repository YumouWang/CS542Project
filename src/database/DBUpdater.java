package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUpdater {
	public void updatePlayer(String playerName, String position, int age,
			String country, int squad_Number, String club, int height)
			throws SQLException {
		Connection conn = DBConnector.getInstance().getConn();

		String sql = "UPDATE player SET position = ?, age = ?, country = ?, squad_number = ?, club = ?, height = ? WHERE playername = ?";
		PreparedStatement pstatement = conn.prepareStatement(sql);
		
		pstatement.setString(1, addSpace(position)); // set parameter 1 position
		pstatement.setInt(2, age); // set parameter 2 age
		pstatement.setString(3, addSpace(country));
		pstatement.setInt(4, squad_Number);
		pstatement.setString(5, addSpace(club));
		pstatement.setInt(6, height);
		pstatement.setString(7, addSpace(playerName));
		pstatement.execute();
	}

	public void updateClub(String clubName, String homeStadium, String coach, int ranking) throws SQLException {
		Connection conn = DBConnector.getInstance().getConn();

		String sql = "UPDATE club SET homestadium = ?, coach = ?, ranking = ? WHERE clubname = ?";
		PreparedStatement pstatement = conn.prepareStatement(sql);
		
		pstatement.setString(1, addSpace(homeStadium)); // set parameter 1 homeStadium
		pstatement.setString(2, addSpace(coach)); // set parameter 2 coach
		pstatement.setInt(3, ranking);
		pstatement.setString(4, addSpace(clubName));
		pstatement.execute();
	}
	
	public static void main(String[] args) throws SQLException {
		DBUpdater d = new DBUpdater();
		d.updatePlayer("Cristiano Ronaldo", "Forward", 29, "Portugal", 7, "Real Madrid", 184);
	}

	public String addSpace(String str) {
		int length = str.length();
		for(int i = 0; i < 50 - length; i++) {
			str = str + " ";
		}	
		return str;
	}
	
	public String addSpace1(String str) {
		int length = str.length();
		for(int i = 0; i < 20 - length; i++) {
			str = str + " ";
		}	
		return str;
	}
}
