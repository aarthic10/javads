package com.practice.lambda.unit2;

import java.util.function.IntBinaryOperator;

public class IntBinaryOperatorFunInterface {

	public static void main(String args[]){
	
		int[] numbers = {1,2,3,4,5};
		int key = 2;
		process(numbers, key, (a,b) -> a+b);
	}

	private static void process(int[] numbers, int key, IntBinaryOperator intBinaryOpr) {
		for(int n:numbers){
			System.out.println(intBinaryOpr.applyAsInt(n, key));
		}
	}
	
}
