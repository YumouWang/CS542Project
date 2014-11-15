package common;

public enum Country {
	Any("Any"), Portugal("Portugal"), France("France"), Mexico("Mexico"), Spain(
			"Spain"), Croatia("Croatia"), Wales("Wales"), Colombia("Colombia"), Germany(
			"Germany"), Brazil("Brazil"), Costa_Rica("Costa Rica");

	private String country;

	Country(String country) {
		this.country = country;
	}

	public String getCountryName() {
		return country;
	}
}
