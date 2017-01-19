package pass;
/**
 * Test class to be run by the j-- compiler with modified Scanner to recognize
 * all literals in Java.
 * 
 * @version April 11, 2016
 * @author 	Trung Dang
 * 
 */
public class Part1Q5AllLiterals {

	public static float floatMessage() {
		return 2.0F;
	
	}
	
	public static boolean booleanMessage() {
		boolean b = true;
		boolean f = false;
		return b && f;
	}
	public static long longMessage() {
		return 20L + 30l;
	}
	
	public static void main(String[] args) {
		System.out.println(Part1Q5AllLiterals.floatMessage());
		System.out.println(Part1Q5AllLiterals.longMessage());
		System.out.println(Part1Q5AllLiterals.booleanMessage());
		

	}

}
