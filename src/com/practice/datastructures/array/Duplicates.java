package com.practice.datastructures.array;

import com.practice.drishticon.test.top30Array.javarevisited.removeDuplicatesInPlace;

public class Duplicates {

	public static void main(String[] args) {
		int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
		System.out.println(removeDuplicatesInPlace(nums));

	}

	public static int removeDuplicatesInPlace(int[] nums) {
        
        int i=0,j=1;
        while(i<nums.length && j<nums.length){
            if(nums[i] == nums[j]){
                j++;
            }else{
                nums[++i] = nums[j++];
            }
        }
        
        return i+1;
    }
}
