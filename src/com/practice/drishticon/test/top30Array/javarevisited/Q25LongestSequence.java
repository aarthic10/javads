package com.practice.drishticon.test.top30Array.javarevisited;

import java.util.HashSet;
import java.util.Set;

public class Q25LongestSequence {

	public static void main(String args[]){
		int[] arr = new int[]{100, 4, 200, 1, 3, 2};
		
		Set<Integer> set = new HashSet<Integer>();
		for(int n: arr){
			set.add(n);
		}
		
		int result = 0;
		for(int i=0;i<arr.length;i++){
			
			if(!set.contains(arr[i]-1)){
				
				int j = arr[i];
				while(set.contains(j)){
					j++;
				}
				
				if(result< j-arr[i]){
					result  = j-arr[i];
				}
			}
			
		}
		System.out.println(result);
		
	}
}
