package datatypes;

public class Weight {
	private Double percentage;
	private String name;
	
	public Weight(Double percentage, String name) {
		this.percentage = percentage;
		this.name = name;
	}
	
	public Double getPercentage() {
		return percentage;
	}
	
	public String getName() {
		return name;
	}
}
