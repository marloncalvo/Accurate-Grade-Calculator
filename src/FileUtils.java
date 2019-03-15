import java.io.File;

public class FileUtils {

	/**
	 * Loads file 
	 * @param File Absolute Path String
	 * @return File pointing to path
	 */
	public static File loadFile(String fileLoc) {
		File inputFile = new File(fileLoc);
		return inputFile;
	}
	
	/**
	 * Seperates text into TIMES number of elements
	 * @param String to seperate
	 * @param Regex to seperate String by
	 * @return Array of Seperated Strings
	 */
	public static String[] seperateInputText(String l, String regex) {
		String[] string = l.split(regex);
		for (int i = 0; i < string.length; i++)
			string[i] = trimEnds(string[i]);
		return string;
	}
	
	public static Double parseDouble(String d) {
		d = d.substring(0, d.indexOf("%"));
		return Double.parseDouble(d);
	}
	
	/**
	 * Removes trailing and leading whitespace
	 * @param string
	 * @return String with trailing and leading whitespace removed
	 */
	private static String trimEnds(String string) {
		char[] charArray = string.toCharArray();
		String newString = "";
		
		int i = -1, k = charArray.length;
		while(Character.isWhitespace(charArray[++i]));
		while(Character.isWhitespace(charArray[--k]));

		for (; i <= k; i++) {
			
			newString += charArray[i];
		}
		
		return newString;
	}
	
}
