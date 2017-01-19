package pass;

public class Part2Exercise26SwitchStatement {
	
	public static int switchStatement() {
		int result = 0, a = 5;
		int i = 10;
		switch(i) {
			case 0:
				result = 1;
				break;
			case a: {
				result = 50; 
				break;
			}
			default:
				result = 100;
				break;
		}
	}
}

