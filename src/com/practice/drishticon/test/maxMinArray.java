package com.practice.drishticon.test;

public class maxMinArray {
	public static void main(String args[]){
		int numbers[] = new int[]{3,9,6,2,4,1};
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int number : numbers){
			if(number >= max){
				max = number;
			}else if(number <= min){
				min = number;
			}
		}
		
		System.out.println("Max is "+max+" Min is "+min);
		
	}
}
