package main;

import parser.ClubParser;
import entity.Club;

public class ClubParserMain {
	public static void main(String[] args) {
		ClubParser clubParser = new ClubParser();
		
		for(Club club : clubParser.parse()) {
			System.out.println(club.getClubName() + "," + club.getHomeStadium() + "," + club.getCoach() + "," + club.getRanking());	
		}	
	}
}
