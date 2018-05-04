package com.practice.drishticon.test.top30Array.javarevisited;

public class Q17SmallesPosInteger {

	public static void main(String args[]){
		printSmallestInteger(new int[]{1,2,3,4,7,11});
	}

	private static void printSmallestInteger(int[] nums) {
		int res = 1;
		for(int i=0;i<nums.length && nums[i]<=res;i++){
			res = res+nums[i];
		}
		System.out.println(res);
	}
}
