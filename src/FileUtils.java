import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUtils {

	public static File loadFile(String fileLoc) {
		File inputFile = new File(fileLoc);
		return inputFile;
	}
	
}
