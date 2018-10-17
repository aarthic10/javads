package com.practice.drishticon.test.top30Array.javarevisited;

public class Q1MissingNumber {

	public static void main(String args[]){
		int[] a1 = new int[]{1,2,3,5,6};
		int n = 6;
		int expectedSum = (n*(n+1))/2;
		int actualSum = 0;
		
		for(int num : a1){
			actualSum += num;
		}
		
		int missingNum = expectedSum - actualSum;
		
		if(missingNum!=0){
			System.out.println("Missing Number is "+missingNum);
		}else{
			System.out.println("No number is missing");
		}
		
		
	}
	
}
