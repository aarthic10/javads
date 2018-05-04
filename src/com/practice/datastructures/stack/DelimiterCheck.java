package com.practice.datastructures.stack;

public class DelimiterCheck {

	public static void main(String args[]) {
		String input = "a{b(c]d}e";
		char[] inputArray = input.toCharArray();
		StackChar openingDelimiter = new StackChar(input.length());

		for (char inputValue : inputArray) {
			switch (inputValue) {
			case '{':
			case '[':
			case '(':
				openingDelimiter.push(inputValue);
				break;
			case '}':
			case ']':
			case ')':
				if (!openingDelimiter.isEmpty()) {
					char openingChar = openingDelimiter.pop();
					if ((openingChar == '{' && inputValue == '}') || (openingChar == '[' && inputValue == ']')
							|| (openingChar == '(' && inputValue == ')')) {
						System.out.println("Opening Delimeter '"+openingChar+"' and Closing Delimeter '"+inputValue+"' Match");
					} else {
						System.out.println("Opening Delimeter '"+openingChar+"' and Closing Delimeter '"+inputValue+"'Does not Match");
					}
				}
				break;
			
			default:
				break;

			}
		}
	}

}
