package com.practice.walmartTest;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
	
	public static void main(String args[]) {
		//ArrayList<ArrayList<Integer>> result= subsets(new int[]{1,2,3});
		mySubsets(new int[]{1,2,3});
		
	}
	
	
	public static void mySubsets(int[] S) {
		if(S == null) {
			System.out.println("Null array");
		}
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		for(int num : S) {
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
			
			for(ArrayList<Integer> resultValue : result) {
				temp.add(new ArrayList<Integer>(resultValue));
			}
			
			for(ArrayList<Integer> tempValue : temp) {
				tempValue.add(num);
			}
			
			ArrayList<Integer> single = new ArrayList<Integer>();
			single.add(num);
			temp.add(single);
		
			result.addAll(temp);
			
		}
		
		System.out.println(result);
	}
	
	
	
	
	
	
	

	public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
		if (S == null)
			return null;
	 
		Arrays.sort(S);
	 
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	 
		for (int i = 0; i < S.length; i++) {
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
	 
			//get sets that are already in result
			for (ArrayList<Integer> a : result) {
				temp.add(new ArrayList<Integer>(a));
			}
	 
			//add S[i] to existing sets
			for (ArrayList<Integer> a : temp) {
				a.add(S[i]);
			}
	 
			//add S[i] only as a set
			ArrayList<Integer> single = new ArrayList<Integer>();
			single.add(S[i]);
			temp.add(single);
	 
			result.addAll(temp);
		}
	 
		//add empty set
		result.add(new ArrayList<Integer>());
	 
		return result;
	}
}
