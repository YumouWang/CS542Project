package controller;

public class Login {
	public static boolean authenticate(String username, String password) {
		// hardcoded username and password
		if (username.equals("") && password.equals("")) {
			return true;
		}
		return false;
	}
	
	public static void main(String args[]){
	      String Str = new String("password");
	      System.out.println("Hashcode for Str :" + Str.hashCode() );
	   }
}
