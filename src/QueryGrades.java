import java.io.IOException;
import java.util.*;

import datatypes.Assignment;
import datatypes.Weight;

public class QueryGrades {
	
	private static HashMap<Weight, ArrayList<Assignment>> courseGrades;
	
	/**
	 * Reads grades from a file, and generates a GPA for that course
	 * 
	 * @param courseName - name for the course to calculate GPA
	 * @return GPA for that course
	 * @throws IOException
	 */
	
	public static HashMap<Weight, ArrayList<Assignment>> getDataForCourse(String courseName, Scanner scan) {
		
		courseGrades = new HashMap<Weight, ArrayList<Assignment>>();
		
		while(scan.hasNext()) {
			String l = scan.nextLine(); 

			if(l.contains(courseName)) {
				while(scan.hasNext(".%") || scan.hasNext("..%") || scan.hasNext("...%")) {
					//loop starts here, check for a percentage
					//then adds all corresponding grades for that percentage 
					//in array list
					l = scan.nextLine();
					String[] category = FileUtils.seperateInputText(l, "-");
					
					ArrayList<Assignment> singleBlockGrades = new ArrayList<Assignment>();
					
					//loop for every double for a certain percentage
					while(scan.hasNextDouble()) {
						l = scan.nextLine();
						String[] string = FileUtils.seperateInputText(l, "-");
						
						singleBlockGrades.add(new Assignment(Double.parseDouble((string[0]))/100, string[1]));
					}
					courseGrades.put(new Weight(FileUtils.parseDouble(category[0])/100, category[1]), singleBlockGrades);
					return courseGrades;
					//loop ends here
				}
				if (courseGrades.isEmpty()) {
					System.err.println("Course " + courseName + " not found!");	
				}
			}
		}
		
		System.err.println("FORMATTING ERROR! CHECK FILE FOR ANY MISTAKES.");
		LoggingUtils.log("RETURNING NULL");
		return null;
	}
}