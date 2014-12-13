package cleaner;

public class DataClean {
	public String CleanPercentValue(String value) {
		if (value.contains("%")) {
			value = value.replace("%", "");
			if (value.matches("-*\\d+\\.?\\d*")) {
				double dd = Double.parseDouble(value) / 100;
				value = Float.toString((float) dd);
				return value;
			} else {
				return "-1";
			}
		} else {
			return value;
		}
	}
}
