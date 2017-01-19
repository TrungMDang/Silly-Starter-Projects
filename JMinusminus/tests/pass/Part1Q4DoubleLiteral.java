package pass;
/**
 * Test class to be run by the j-- compiler with modified Scanner to recognize
 * double precision literal such as 2.5
 * 
 * @version April 11, 2016
 * @author 	Trung Dang
 * 
 */
public class Part1Q4DoubleLiteral {
	
	public static double message() {
		return 10.5 + 20.5 + 0.5 + 1.5 + 2.55 + 3.45;
	}
	public static void main(String[] args) {
		System.out.println(Part1Q4DoubleLiteral.message());
	}
}
