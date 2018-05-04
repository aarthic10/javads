package com.practice.drishticon.test.top30Array.javarevisited;

public class Q11KthSmallestLargestNumber {
	public static void main(String args[]){
		printSmallestNumber(new int[]{64, 30, 30, 56, 74, 49, 63, 72, 73, 25, 87, 17, 22, 20, 32, 23},6);
		findKthSmallest(new int[]{64, 30, 30, 56, 74, 49, 63, 72, 73, 25, 87, 17, 22, 20, 32, 23},6);
		//System.out.println(" "+findKthLargest(new int[]{64, 30, 30, 56, 74, 49, 63, 72, 73, 25, 87, 17, 22, 20, 32, 23},5));
	}

	private static void findKthSmallest(int[] nums, int i) {
		
		display(nums);
		System.out.println(getKth(i, nums, 0, nums.length-1));
	}

	/*
	 * Using part selection sort
	 */
	private static void printSmallestNumber(int[] numbers,int k) {
		int inner = 0;
		int minPos = 0;
		int temp = 0;
		for(;inner<k;inner++){
			minPos = inner;
			for(int outer=inner;outer<numbers.length;outer++){
				if(numbers[outer]< numbers[minPos]){
					minPos = outer;
				}
			}
			temp = numbers[inner];
			numbers[inner] = numbers[minPos];
			numbers[minPos] = temp;
		}
		System.out.println("Min value is "+numbers[k-1]);
	}
	
	
	public static int findKthLargest(int[] nums, int k) {
		display(nums);
		if (k < 1 || nums == null) {
			return 0;
		}
	 System.out.println("k = "+(nums.length - k+1));
		return getKth(nums.length - k +1, nums, 0, nums.length - 1);
	}
	 
	private static void display(int[] nums) {
		for(int num: nums){
			System.out.print(num+" ");
		}
		System.out.println();
		
	}

	public static int getKth(int k, int[] nums, int start, int end) {
	 
		int pivot = nums[end];
	 
		int left = start;
		int right = end;
	 
		while (true) {
	 
			while (nums[left] < pivot && left < right) {
				left++;
			}
	 
			while (nums[right] >= pivot && right > left) {
				right--;
			}
	 
			if (left == right) {
				break;
			}
	 
			swap(nums, left, right);
		}
	 
		swap(nums, left, end);
	 
		if (k == left + 1) {
			return pivot;
		} else if (k < left + 1) {
			return getKth(k, nums, start, left - 1);
		} else {
			return getKth(k, nums, left + 1, end);
		}
	}
	 
	public static void swap(int[] nums, int n1, int n2) {
		int tmp = nums[n1];
		nums[n1] = nums[n2];
		nums[n2] = tmp;
	}
}
