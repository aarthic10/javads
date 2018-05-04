package com.practice.datastructures.recursive.triangle;

public class FactorialApp {

	public static void main(String[] args) {
		int fact = factorial(5);
		System.out.println("Factorial is "+fact);
	}
	
	public static int factorial(int n){
		System.out.println("Calculating for "+n);
		if(n==0){
			System.out.println("Returning 1");
			return 1;
		}else{
			int temp =  n * factorial(n-1);
			System.out.println("Returning factorial of "+n+" = "+temp);
			return temp;
		}
	}

}
