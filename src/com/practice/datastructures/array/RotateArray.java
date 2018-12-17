package com.practice.datastructures.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateArray {

	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,4,5,6,7};
		int k = 3;
		rotate(nums, k);

	}

	public static void rotate(int[] nums, int k) {
		int len = nums.length;
        while(k > 0) {
        	int lastElem = nums[len - 1];
        	
        	for(int i=len-1; i>0; i--) {
        		nums[i] = nums[i-1];
        	}
        	nums[0] = lastElem;
        	k--;
        }
        
       
        
        Arrays.stream(nums).forEach((int a) -> System.out.print(a+" "));
    }
}
