package com.practice.lambda.unit1;

public class TypeInferenceLambda {

	public static void main(String args[]){
		
		//Lambda variable
		StringLengthLambda stringLength  = text -> text.length();
		System.out.println("Length is "+stringLength.getLength("Hello World"));
		
		//Lambda as parameter
		printLambda(s -> s.length(), "Test");
		
	}
	
	public static void printLambda(StringLengthLambda sLambda, String s){
		System.out.println("Printing Lambda length value "+sLambda.getLength(s));
	}
	
}

interface StringLengthLambda{
	int getLength(String value);
}
