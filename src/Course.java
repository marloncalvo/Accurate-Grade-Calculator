import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import datatypes.Weight;
import datatypes.Assignment;

public class Course {
	
	private HashMap<Weight, ArrayList<Assignment>> courseData;
	
	private double averageGrade;
	private final String courseName;

	public Course(String courseName, HashMap<Weight, ArrayList<Assignment>> courseData) {
		this.courseName = courseName;
		this.courseData = courseData;
		this.averageGrade = Calculations.calculateCourseAverage(this);
	}
	
	public double getAverageGrade() {
		return averageGrade;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public HashMap<Weight, ArrayList<Assignment>> getCourseDataMap() {
		return courseData;
	}
	
	public void toString(boolean fullData) {
		
		
		if(fullData) {
			if(!courseData.isEmpty()) {
				String[][] data;
				data = convertToString();
				printFormat(data);
				return;
			}
			else
				return;
		}
		
		String[] data = {String.valueOf(averageGrade), courseName};
		printFormat(data);		
	}
	
	public String[][] toStringArray(boolean fullData) {
		String[][] data = null;
		
		if(fullData) {
			if(!courseData.isEmpty())
				data = convertToString();
			else
				return null;
		}
		
		data = new String[][]{{String.valueOf(averageGrade), courseName}};
		return data;
	}
	
	private String[][] convertToString() {
		int numOfKeys = courseData.size();
		
		
		String[][] data = new String[numOfKeys][];
		int i = 0;
		for (Map.Entry<Weight, ArrayList<Assignment>> entry : courseData.entrySet()) {
			data[i] = new String[(entry.getValue().size()*2)+2];
			data[i][0] = entry.getKey().getName();
			data[i][1] = String.valueOf(entry.getKey().getPercentage());
			
			int k = 2;
			for(Iterator<Assignment> itr = entry.getValue().iterator(); itr.hasNext();) {
				Assignment aAssignment = itr.next();
				data[i][k++] = aAssignment.getName();
				data[i][k++] = String.valueOf(aAssignment.getGrade());
			}
			i++;
		}
		
		return data;
	}
	
	private void printFormat(String[][] string) {
		for(int i = 0; i < string.length; i++) {
			System.out.println(courseName);
			for(int k = 0; k < string[i].length; k++) {
				
				if(k<2) {
					if(k==0)
						System.out.printf("%s ", string[i][k]);
					else
						System.out.printf("%.2f%%:\n", Double.parseDouble(string[i][k])*100);
					continue;
				} else if (k%2 == 0) {
					System.out.printf("\t%s ", string[i][k]);
					continue;
				} else {
					System.out.printf("%.2f%%", Double.parseDouble(string[i][k])*100);
					continue;
				}

				
			}
			System.out.printf("\n");
		}
	}
	
	private void printFormat(String[] string) {
		System.out.printf("%s %.2f", string[0], Double.parseDouble(string[1]));
	}
}
