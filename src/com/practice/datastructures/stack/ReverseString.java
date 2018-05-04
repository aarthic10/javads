package com.practice.datastructures.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString {

	

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	public static void main(String args[]) throws IOException {

		String input;
		while (true) {
			System.out.println("Enter a string:");
			System.out.flush();
			input = getString();
			if (input.equals("")) {
				break;
			}

			StackChar stack = new StackChar(input.length());
			char[] inputArray = input.toCharArray();
			for(char inputChar:inputArray){
				stack.push(inputChar);
			}
			
			while (!stack.isEmpty()) {
				System.out.print(stack.pop());
			}
			System.out.println();
		}

		
	}

}
