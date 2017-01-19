package pass;
/**
 * Test class to be run by the j-- compiler with modified Scanner to recognize
 * all representations of integers.
 * 
 * @version April 11, 2016
 * @author 	Trung Dang
 * 
 */
public class Part1Q6BonusIntegerLiterals {
	
	public static byte byteMessage() {
		byte a = 10;
		byte b = 20;
		return a + b;
	}
	public static short shortMessage() {
		short a = 10;
		short b = 20;
		return a + b;
	}
	public static float longMessage() {
		return 10L + 25l;
	}
	
	public static int hexMessage() {
		int hex = 0x1a;
		return hex;
	}
	public static int octalMessage() {
		int octal = 0010;
		return octal;
	}
	public static int binMessage() {
		int bin = 0b11010;
		return bin;
	}
	public static void main(String[] args) {
		System.out.println(Part1Q6BonusIntegerLiterals.byteMessage());
		System.out.println(Part1Q6BonusIntegerLiterals.shortMessage());
		System.out.println(Part1Q6BonusIntegerLiterals.longMessage());
		System.out.println(Part1Q6BonusIntegerLiterals.hexMessage());
		System.out.println(Part1Q6BonusIntegerLiterals.octalMessage());
		System.out.println(Part1Q6BonusIntegerLiterals.binMessage());
	}

}
