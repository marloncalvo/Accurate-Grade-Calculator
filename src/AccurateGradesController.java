import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AccurateGradesController {
			
	public static void main (String[] args) {
		
		//open file
		File inputFile = FileUtils.loadFile("C:\\Users\\marlon\\Documents\\grades.txt");
		
		//create file scanner
		Scanner scan = loadScanner(inputFile);
		
		//get courses to load
		String[] courseNames = scan.hasNextLine() ? scan.nextLine().split("\\s+") : null;
		
		if(courseNames == null) {
			LoggingUtils.log("COURSES NOT FOUND, IS FILE EMPTY?");
			return;
		}
		
		for(int i = 0; i < courseNames.length; i++)
			courseNames[i].trim();
		
		
		LoggingUtils.log("COURSES FOUND: ", courseNames);
		
		//create course objs
		ArrayList<Course> courses = new ArrayList<Course>();
		
		for(String course : courseNames) {
			//LoggingUtils.log(course);
			courses.add(new Course(course, QueryGrades.getDataForCourse(course, scan)));
		}
		
		courses.get(0).toString(true);
		courses.get(1).toString(true);
	}
	
	
	private static Scanner loadScanner(File inputFile) {
		Scanner scan = null;
		
		try {
			scan = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			LoggingUtils.log("FILE NOT FOUND");
			e.printStackTrace();
			return null;
		}
		
		LoggingUtils.log("FILE FOUND");
		return scan;
	}

}
