package com.practice.lambda.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandling {

	public static void main(String args[]){
	
		int[] numbers = {1,2,3,4,5};
		int key = 0;
		
		process(numbers, key, wrapperLambda((a,b) -> System.out.println(a/b)));
	}

	private static void process(int[] numbers, int key, BiConsumer<Integer,Integer> biConsumer) {
		for(int n:numbers){
			biConsumer.accept(n, key);
		}
	}
	
	/* Wrapper method that takes in a lambda and returns the same lambda after handling the exception.
	 * This is an elegant way to handle exceptions in lambda. 
	*/
	private static BiConsumer<Integer,Integer> wrapperLambda(BiConsumer<Integer,Integer> consumer){
		return (a, b) -> {
			try {
				consumer.accept(a, b);
			} catch (ArithmeticException e) {
				e.printStackTrace();
			}

		};
	}
}
