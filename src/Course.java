import java.util.ArrayList;

public class Course {
	private final double grade;
	private final String courseName;
	
	public Course(String courseName, double grade) {
		this.courseName = courseName;
		this.grade = grade;
	}
	
	public double getGrade() {
		return grade;
	}
	
	public String getCourseName() {
		return courseName;
	}
}
