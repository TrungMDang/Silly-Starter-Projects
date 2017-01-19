package pass;

public class Part2Exercise25ForStatement {
	
	public static int basicFor() {
		int result = 0;
		for (int i = 0; i < 5; i++) {
			result += i;
		}
		return result;
	}
	
	public static int enhancedFor() {
		int[] array = {0, 1, 2, 3, 4};
		int result = 0;
		for (int i : array) {
			result += i;
		}
		return result;
	}
}
