package common;

public enum Club {
	Any("Any"), Real_Mardid("Real Madrid"), Liverpool("Liverpool"), Barcelona("Barcelona"), Paris("Paris");

	private String club;

	Club(String club) {
		this.club = club;
	}

	public String getClubName() {
		return club;
	}
}
