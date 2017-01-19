package pass;

import java.io.PrintWriter;
import java.lang.Exception;

public class Part2Exercise27TryCatchStatement {

	public static void tryCatch() {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter("OutFile.txt"));
			for (int i = 0; i < 10; i++) {
				out.println("Value at: " + i + " = " + list.get(i));
			}
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Caught IndexOutOfBoundsException: "
					+  e.getMessage());

		} catch (IOException e) {
			System.err.println("Caught IOException: " +  e.getMessage());
		} finally {
			if (out != null) {
				System.out.println("Closing PrintWriter");
				out.close();
			} else {
				System.out.println("PrintWriter not open");
			}
		}
	}
}

