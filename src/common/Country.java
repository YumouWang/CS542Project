package common;

public enum Country {
	Any("Any"), Portugal("Portugal"), France("France"), Mexico("Mexico"), Spain(
			"Spain"), Croatia("Croatia"), Wales("Wales"), Colombia("Colombia"), Germany(
			"Germany"), Brazil("Brazil"), Costa_Rica("Costa Rica"), Serbia(
			"Serbia"), England("England"), Italy("Italy"), Slovakia("Slovakia"), Australia(
			"Australia"), Belgium("Belgium"), Cote_dIvoire("Cote dIvoire");

	private String country;

	Country(String country) {
		this.country = country;
	}

	public String getCountryName() {
		return country;
	}
}
