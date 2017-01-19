
package pass;

/******* Nested Comment *****/***********/*********/*/

import java.lang.System;

/* Multiline comment in one line.*/
/**
 * Test class to be run by the j-- compiler with modified Scanner to recognize
 * multiple line comment.
 * 
 * @version April 11, 2016
 * @author 	Trung Dang
 * 
 */
public class Part1Q1MultiLineComment {
	/*
	 * Second multiline comment.
	 * public static void main(String[] args) {
	 * 		System.out.println("Multiline comment recognizer failed!");
	 * }
	 */
	/*******************
	 *                 *
	 * Fancy comment   *
	 * 
	 *********************/
	public static String message() {
		//A comment
		return "Multiline comment with modified Scanner.java...";
	}
	/**
	 * First multiline comment.
	 * public static void main(String[] args) {
	 * 		System.out.println("Multiline comment recognizer failed!");
	 * }
	 */
	public static void main(String[] args) {
		 System.out.println(Part1Q1MultiLineComment.message());
		/* Multiline comment in one line.*/
	}	
}
