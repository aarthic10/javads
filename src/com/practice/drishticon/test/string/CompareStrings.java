package com.practice.drishticon.test.string;

public class CompareStrings {

	public static void main(String[] args) {
		compareToStrings();
		substringIntern();
	}

	private static void compareToStrings() {
		String s1 = "apple";
		String s2 = "banana";
		
		/*Compares lexicographically.
		 * Similar to dictionary
		 * 
		 * */
		//Returns -1 since apple comes before banana
		System.out.println(s1.compareTo(s2));
		
		//Returns 1 since banana comes after apple
		System.out.println(s2.compareTo(s1));
		
		//Returns 0 since both are equal
		System.out.println(s1.compareTo(s1));
	}

	private static void substringIntern() {
		String s1 = new String("apple");
		//Intern() creates a value in literal pool
		String s2 = s1.intern();
		
	}

}
