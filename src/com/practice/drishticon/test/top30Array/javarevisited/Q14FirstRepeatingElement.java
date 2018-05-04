package com.practice.drishticon.test.top30Array.javarevisited;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q14FirstRepeatingElement {

	public static void main(String args[]){
		printFirstRepeatList(new int[] {10, 5, 3, 4, 5,3, 6});
		printFirstRepeatSet(new int[] {10, 5, 3, 4, 3, 5, 6});
	}

	private static void printFirstRepeatSet(int[] nums) {
		int first = -1;
		
		Set<Integer> values = new HashSet<Integer>(nums.length);
		int size = nums.length-1;
		for(int i=size;i>=0;i--){
			if(!values.add(nums[i])){
				first = i;
			}
		}
		
		if(first!=-1){
			System.out.println(nums[first]);
		}
		
		
	}

	private static void printFirstRepeatList(int[] nums) {
		int first = -1;
		List<Integer> list = new ArrayList<Integer>();
		for(Integer n:nums){
			if(list.contains(n)){
				if(first==-1 || list.indexOf(n)<first){
					first = list.indexOf(n);
				}
			}else{
				list.add(n);
			}
		}
		System.out.println(list.get(first));
	}
}
