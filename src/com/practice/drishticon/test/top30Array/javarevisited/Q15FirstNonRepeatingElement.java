package com.practice.drishticon.test.top30Array.javarevisited;

import java.util.HashSet;
import java.util.Set;

public class Q15FirstNonRepeatingElement {

	public static void main(String args[]) {
		printFirstNonRepeatSet(new int[] { 11, 5, 3, 4, 4, 3, 5, 6 });
	}

	private static void printFirstNonRepeatSet(int[] nums) {

		Set<Integer> values = new HashSet<Integer>(nums.length);
		for (int i = 0; i < nums.length; i++) {
			if (!values.add(nums[i])) {
				values.remove(nums[i]);
			}
		}
		for (Integer value : values) {
			System.out.println(value);
			break;
		}
	}
	

}
