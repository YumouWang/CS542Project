package common;

public enum Club {
	Any("Any"), Real_Mardid("Real Madrid"), Liverpool("Liverpool");

	private String club;

	Club(String club) {
		this.club = club;
	}

	public String getClubName() {
		return club;
	}
}
