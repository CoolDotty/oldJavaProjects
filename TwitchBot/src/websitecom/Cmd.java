package websitecom;

public class Cmd {
	
	private Cmd() {
		
	}
	
	public static final String timeout = ".timeout "; //[user] or [target] [seconds]
	public static String ban 	 = ".ban ";
	public static String unban 	 = ".unban ";
	public static String slow 	 = ".slow "; // [seconds]
	public static String unslow  = ".unslow";
	public static String clear 	 = ".clear";
	public static String r9k 	 = ".r9kbeta";
	public static String r9koff  = ".r9kbetaoff";
	public static String promote = ".mod "; // [user]
	public static String demote  = ".unmod "; // [user]
}
