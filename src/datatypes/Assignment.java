package datatypes;

public class Assignment {
	private Double grade;
	private String name;
	
	public Assignment(Double grade, String name) {
		this.grade = grade;
		this.name = name;
	}
	
	public Double getGrade() {
		return grade;
	}
	
	public String getName() {
		return name;
	}
}
