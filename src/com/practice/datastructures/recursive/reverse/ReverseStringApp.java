package com.practice.datastructures.recursive.reverse;

import java.util.HashSet;
import java.util.Set;

public class ReverseStringApp {

	static char[] recursiveString = new char[100];
	static int lastPosition;

	public static void main(String args[]) {
		char[] reverseString = reverse("hello aarthi");

		System.out.println(reverseString);

		String origString = "hello aarthi";
		recursiveString = origString.toCharArray();
		lastPosition = recursiveString.length - 1;
		recursiveReverse(0);
		
	}

	/*
	 * My Logic :) start from left and keep swapping first and last. Then swap
	 * second and second to last. keep going till the mid value.
	 */

	public static char[] reverse(String s) {
		char[] arr = s.toCharArray();
		int size = arr.length - 1;

		for (int i = 0; i <= size / 2; i++) {
			char temp = arr[i]; // first value to temp
			arr[i] = arr[size - i]; // first swapped with last
			arr[size - i] = temp; // last assigned first value.
		}

		return arr;
	}

	public static void recursiveReverse(int pos) {

		if (pos > (lastPosition / 2)) {
			System.out.println(recursiveString);
			return;
		} else {			
			char temp = recursiveString[pos];
			recursiveString[pos] = recursiveString[lastPosition - pos]; 
			recursiveString[lastPosition - pos] = temp;
			
			recursiveReverse(++pos);
		}

	}
}
