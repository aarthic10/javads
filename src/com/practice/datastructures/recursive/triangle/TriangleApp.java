package com.practice.datastructures.recursive.triangle;

public class TriangleApp {

	public static void main(String args[]){
		int total = total(3);
		System.out.println("Total is "+total);
	}
	
	public static int total(int n){
		System.out.println("Calculating for "+n);
		if(n==1){
			System.out.println("Returning total 1");
			return 1;
		}else{
			int temp = n + total(n-1);
			System.out.println("Returning total for "+n);
			return temp;
		}
		
	}
	
}
