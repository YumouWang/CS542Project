package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBQuerier;

public class Login {
	public static boolean authenticate(String username, String password) {
		DBQuerier dbQuerier = new DBQuerier();
		ResultSet rs = null;
		try {
			rs = dbQuerier.getLoginInfo(username, String.valueOf(password.hashCode()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int count = 0;
		try {
			while (rs.next()) {
			  count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count == 1) {
			return true;
		}
		return false;
	}
	
	public static void main(String args[]){
	      String Str = new String("password");
	      System.out.println("Hashcode for Str :" +  String.valueOf(Str.hashCode()));
	   }
}
