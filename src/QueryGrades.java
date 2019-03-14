import java.io.IOException;
import java.util.*;

public class QueryGrades {
	
	private static HashMap<Double, ArrayList<Double>> courseGrades;
	
	/**
	 * Reads grades from a file, and generates a GPA for that course
	 * 
	 * @param courseName - name for the course to calculate GPA
	 * @return GPA for that course
	 * @throws IOException
	 */
	public static double getCourseAverage(String courseName, Scanner scan) throws IOException {
					
		getGradesForCourse(courseName, scan);
		
		double avg = calculateCourseGradeAverage();
		
		LoggingUtils.log("AVG GRADE FOR COURSE: " + courseName + " = " + avg);
				
		return avg;
	}
	
	private static void getGradesForCourse(String courseName, Scanner scan) {

		courseGrades = new HashMap<Double, ArrayList<Double>>();
		while(scan.hasNext()) {
			String l = scan.nextLine(); 
						
			if(l.contains(courseName)) {
				while(scan.hasNext(".%") || scan.hasNext("..%") || scan.hasNext("...%")) {
					//loop starts here, check for a percentage
					//then adds all corresponding grades for that percentage 
					//in array list
					l = scan.nextLine();
					double percent = Double.parseDouble(l.substring(0, l.length()-1));
										
					ArrayList<Double> singleBlockGrades = new ArrayList<Double>();
					
					//loop for every double for a certain percentage
					while(scan.hasNextDouble()) {
						l = scan.nextLine();
						singleBlockGrades.add(Double.parseDouble(l));
					}
					courseGrades.put(percent, singleBlockGrades);
					//loop ends here
				}
				if (courseGrades.isEmpty()) {	
					System.err.println("FORMATTING ERROR! CHECK FILE FOR ANY MISTAKES.");
				}
				return;
			}
			
			
		}
		
		if (courseGrades.isEmpty()) {	
			System.err.println("Course " + courseName + " not found!");	
		}
		
		return;
	}
	
	/*private static boolean doesStringContainCourse(String l, String courseName) {
		if(l.contains(courseName))
			return true;
		return false;
	}*/
	
	private static double calculateCourseGradeAverage() {
		
		double totalPossiblePoints = 0;
		double totalPercentage = 0;
		
		for(Map.Entry<Double, ArrayList<Double>> entry : courseGrades.entrySet()) {
			int counter = 0;
			double earnedPoints = 0;
			for(Double score : entry.getValue()) {
				earnedPoints += score;
				++counter;
			}
			earnedPoints /= counter;
			totalPossiblePoints += (earnedPoints * (entry.getKey() / 100));
			totalPercentage += entry.getKey();
		}
		
		
		return totalPossiblePoints/(totalPercentage/100);
	}
}