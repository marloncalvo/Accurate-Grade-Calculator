import java.util.ArrayList;
import java.util.Map;

import datatypes.Assignment;
import datatypes.Weight;

public class Calculations {
	
	public static double calculateCourseAverage(Course course) {
		
		double earnedPoints = 0;
		double totalPoints = 0;
		
		for(Map.Entry<Weight, ArrayList<Assignment>> entry : course.getCourseDataMap().entrySet()) {
			double percentage = entry.getKey().getPercentage();
			
			earnedPoints += calculateWeightAverage(percentage, entry.getValue()) * percentage;
			totalPoints += percentage;
		}

		return earnedPoints/totalPoints;
	}
	
	

	private static double calculateWeightAverage(Double percentage, ArrayList<Assignment> courseData) {
		Double[] grades = getAssignmentGradesArray(courseData.toArray());
		
		return calculateAverage(percentage, grades);
	}
	
	private static double calculateAverage(Double percentage, Double[] grades) {
		
		double earnedPoints = 0;
		int counter = 0;
		
		for(Double score : grades) {
			earnedPoints += score;
			++counter;
		}
				
		// (((x + y + z)/numElements)*percentage
		earnedPoints = (earnedPoints/counter)*percentage;
	
		return earnedPoints/percentage;
	}
	
	private static Double[] getAssignmentGradesArray(Object[] assg) {
		int assgLength = assg.length;
		Double[] grades = new Double[assgLength];
		
		for(int i = 0; i < assgLength; i++)
			grades[i] = ((Assignment) assg[i]).getGrade();
		
		return grades;
	}

}
