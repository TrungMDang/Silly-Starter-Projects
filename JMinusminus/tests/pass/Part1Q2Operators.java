package pass;
/**
 * Test class to be run by the j-- compiler with modified Scanner to recognize
 * all operators in Java.
 * 
 * @version April 11, 2016
 * @author 	Trung Dang
 * 
 */

public class Part1Q2Operators {
	
	public static int postfix() {
		int a = 1;
		a++;
		int b = 1;
		b--;
		return a + b;
	}
	
	public static int unary() {
		boolean b = false;
		int a = 1;
		--a;
		++a;
		b = !b;
		return a;
	}
	
	public static String multiplicative() {
		return 1 * 2 + " " + 4 / 2 + " " + 3 % 5;
	}
	public static String additive() {
		return 1 + 1 + " " + (2 - 1);
	}
	
	
	public static String shift() {
		return (10 << 2) + " " + (10 >> 2) + " " + (10 >>> 2);
	}
	
	public static String relational() {
		return 10 <= 20;//(10 > 20) + " " + (10 < 20) + " " + (10 >= 11) + " " + (10 <= 10);
	}
	public static boolean instanceOfRelational() {
		int a = 0;
		boolean result = a instanceof Integer;
		return result;
	}
	
	public static String equality() {
		return (10 == 10) + " " + (10 != 10);
	}
	
	public static int bitwiseAnd() {
		int a = 0;
		a = 60 & 13;
		return a;
	}
	
	public static int bitwiseExclusiveOR() {
		int a = 0;
		a = 60 ^ 13;
		return a;
	}
	
	public static int bitwiseInclusiveOR() {
		int a = 0;
		a = 6|13;
		return a;
	}
	
	public static String logicalAND() {
		boolean a = true;
		boolean b = false;
		return (a && b) + " " + (a || b);
	}
	
	public static Boolean logicalOR() {
		boolean a = true;
		boolean b = false;
		a = a || !b;
		return a;
	}
	
	public static boolean ternary() {
		int a = 0, b = 1;
		return (a <= b) ? true : false;
	}
	
	public static String assignment() {
		StringBuffer sb = new StringBuffer();
		int a = 10, b = 20, c = 0;

		sb.append("c += a: " + (c += a) + "\n");
		sb.append("c -= a: " + (c -= a) + "\n");
		sb.append("c *= a: " + (c *= a) + "\n");
		sb.append("c /= a: " + (c /= a) + "\n");
		sb.append("c %= a: " + (c %= a) + "\n");
		sb.append("c <<= a: " + (c <<= a) + "\n");
		sb.append("c >>= a: " + (c >>= a) + "\n");
		sb.append("c &= a: " + (c &= a) + "\n");
		sb.append("c ^= a: " + (c ^= a) + "\n");
		sb.append("c |= a: " + (c |= a) + "\n");
		return sb.toString();
	}
}
