package fail;

/*
 * Test for Part 3 Exercise 4.1.
 * Only one public type declaration is allowed in each file.
 * Having more than 1 public class in a file is an error.
 */
public class Part3Exercise41OnlyOnePublicTypeDeclaration {
	public static void main(String[] args) {
		
	}
}

/*
 * This class cannot be declared since there is only 1 public class in a 
 * java file.
 */
public class failClass {
	public static void main(String[] args) {
		
	}

}
