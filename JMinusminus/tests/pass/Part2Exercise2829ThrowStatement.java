package pass;

import java.lang.Exception;

public class Part2Exercise2829ThrowStatement {
	
	public static int throwStatement() throws Exception {
		int i = 0;
		if (i == 0) {
			throw new Exception();
		} else {
			i = 5;
		}
		return i;
	}
}

