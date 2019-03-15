import java.util.Iterator;
import java.util.Set;

import datatypes.Weight;

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
	
	public static void log(String l, int i) {
		System.out.println("[DEBUG] " + l + i);
	}
	
	public static void log(String l, Set<Weight> set) { 

		for(Iterator<Weight> itr = set.iterator(); itr.hasNext(); )
			System.out.println("[DEBUG] " + itr.next().getPercentage());
	}
	
	public static void log(String[][] l) {
		
		for(int i = 0; i < l.length; i++) {
			for(int k = 0; k < l[i].length; k++) {
				LoggingUtils.log(l[i][k]);
			}
		}
		
		/*
		 * for(String[] a : l) { String text = ""; for(String b : a) {
		 * System.out.println(b + "-"); text += b + " "; } LoggingUtils.log(text); }
		 */
	}
}
