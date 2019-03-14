import java.util.ArrayList;

public class Course {
	private final double averageGrade;
	private final String courseName;
	
	public Course(String courseName, double averageGrade) {
		this.courseName = courseName;
		this.averageGrade = averageGrade;
	}
	
	public double getGrade() {
		return averageGrade;
	}
	
	public String getCourseName() {
		return courseName;
	}
}
