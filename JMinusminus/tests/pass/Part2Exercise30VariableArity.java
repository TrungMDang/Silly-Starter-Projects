package pass;

import java.lang.Exception;

public class Part2Exercise30VariableArity {
	
	private int data;
	private int data2;

	
	public Part2Exercise30VariableArity() {
		data = 0;
		data2 = 0;
	}
	
	public Part2Exercise30VariableArity(int param) {
		data = param;
		data2 = 0;
	}
	
	public Part2Exercise30VariableArity(int param, int param2) {
		data = param;
		data2 = param2;
	}
	
	public static int normal() {
		int i = 0;
		return i;
	}
	
	public static int normal(int overload) {
		return overload++;
	}
	
	public static int normal(int overload, int overload2) {
		return overload + overload2;
	}
}

