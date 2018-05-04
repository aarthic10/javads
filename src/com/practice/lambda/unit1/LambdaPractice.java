package com.practice.lambda.unit1;

public class LambdaPractice {

	public static void main(String args[]){		
		
		Greeting helloWorldGreeting = () -> System.out.println("Hello World");
		helloWorldGreeting.perform();
		
		AddOperation addOp = (a, b) -> a+b;
		System.out.println("Sum is "+addOp.add(4, 5));
	}
	
}

@FunctionalInterface
interface Greeting {
	void perform();
}

interface AddOperation{
	int add(int a, int b);
}