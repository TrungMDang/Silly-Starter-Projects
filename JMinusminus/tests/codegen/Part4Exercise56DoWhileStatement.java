package codegen;

import java.lang.System;

public class Part4Exercise56DoWhileStatement {
	public static void main(String[] args) {
		int i = 5, sum = 10;
		do {
			System.out.println(i);
			sum = sum + i;
			i = i - 1;
		} while (i > 2);
	}
}
