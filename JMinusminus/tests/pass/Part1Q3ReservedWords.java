package pass;

import javax.swing.JButton;
import java.awt.event.ActionListener;;
import java.util.Scanner;
import java.lang.Exception;

/**
 * Test class to be run by the j-- compiler with modified Scanner to recognize
 * all reserved words.
 * 
 * NOTE: DO NOT RUN THIS CLASS. SYNTAX ERROR. ONLY USED IN SCANNING.
 * 
 * @version April 11, 2016
 * @author 	Trung Dang
 * 
 */
public class Part1Q3ReservedWords {
	
	int thisTest;
	
	public Part1Q3ReservedWords {
		this.thisTest = 0;
	}
	
	public static void main(String...args) {
		Object result = null;
		assert result != null;
		
		boolean trueOrFalse = true;
		
		int count = 0;
		while (trueOrFalse) {
			count++;
			if (count == 2) {
				trueOrFalse = false;
				break;
			} else {
				continue;
			}
		}
		
		byte aByte = 100;
		
		switch(trueOfFalse) {
		case true:
			System.out.println("True case");
			break;
		case false:
			System.out.println("False case");
			break;
		default:
			System.out.println("Not true or not false - weird case");
			break;
		}
		
		try { 
			
		} catch (Exception e) { 
			
		} finally { 
			
		}
		
		char aChar = 'a';
		
		do {
			aChar = 'b';
		} while (aChar = 'a')
			
		double aDouble = 1.0;
		
		if (aDouble instanceof Double) {
			System.out.println("An instance of Double.");
		}
		
		float aFloat = 1.0f;
		
		for (int i = 0; i < 2; i++) {
			aFloat += 1.0f;
		}
		
		long aLong = 1.0l;
		
		Scanner stdIn = new Scanner(System.in);
		stdIn.close();
		
		strictfp double aStrictFP;
		
		transient int aTransientType;

		volatile int aVolatileType;

	}
	
	abstract final class AbstractClass {
		super();
	}
	abstract void aMethod();
	
	enum enumeration {
		A, B, C;
	}
	
	private class privateClass extends JButton implements ActionListener {
		
	}
	
	interface AnInterface { 
		
	}

	native void aNativeMethod();
	
	private short privateMethod throws Exception {
		return 1;
	}
	
	protected void protectedMethod {
		throw new Exception();
	}
	
	synchronized void aSynchronizedMethod() { 

	}
	//break
	//byte
	//case
	//catch
	//char
	//class
	//const
	//continue
	//default
	//do
	//double
	//else
	//enum
	//extends
	//false 
	//final
	//finally
	//float
	//for
	//goto
	//if
	//implements
	//import
	//instanceof
	//int
	//interface
	//long
	//native
	//new
	//null
	//package
	//private
	//protected
	//public
	//return
	//short
	//static
	//strictfp
	//super
	//switch
	//synchronized
	//this
	//throw
	//throws
	//transient
	//try
	//void
	//volatile
	//while
	//true

}
