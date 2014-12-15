package controller;

import common.PlayerPosition;

public class Rating {
	public String calculate(String position, int goalScored, int onTarget, int assists, int offsides, int foulsCommitted, int passes, int completedPass, float completion) {
		if(passes < 10) {
			return "0";
		}
		float rating = 6;
		if(position.equals(PlayerPosition.Goalkeeper.name())) {
			rating = 8;
		} else if (position.equals(PlayerPosition.Defender.name())) {
			rating = (float) (rating + goalScored + assists + foulsCommitted * 0.2 + (completion - 0.8) * 5);
		} else if (position.equals(PlayerPosition.Midfield.name())) {
			rating = (float) (rating + goalScored + assists * 1.2 + foulsCommitted * 0.1 + (completion - 0.85) * 10);
		} else {
			rating = (float) (rating + goalScored * 1.2 + assists * 1 + (completion - 0.8) * 5);
		}
		if(rating > 10) {
			return "10";
		}
		return String.format("%.2f", rating);
	}

}
