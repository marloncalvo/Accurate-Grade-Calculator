
public class LoggingUtils {
	public static void log(String l){
		System.out.println("[DEBUG] " + l);
	}
	
	public static void log(String log, String...strings ){
		System.out.print("[DEBUG] " + log);
		for (String z : strings)
			System.out.print(z + " ");
		System.out.println();
	}
	
	public static void log(String...strings ){
		System.out.print("[DEBUG] ");
		for (String l : strings)
			System.out.print(l + " ");
		System.out.println();
	}
	
	public static void log(String l, boolean b){
		System.out.print("[DEBUG] "  + l + b);
		
	}
	
	public static void log(String l, double d){
		System.out.println("[DEBUG] " + l + d);
	}
}
