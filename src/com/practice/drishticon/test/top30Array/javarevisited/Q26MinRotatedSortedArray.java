package com.practice.drishticon.test.top30Array.javarevisited;

public class Q26MinRotatedSortedArray {

	public static void main(String args[]){
		
		int[] arr = new int[]{4,5,6,7,8,0,1,2};
		
		int min = findMinimum(0, arr.length-1, arr);
		System.out.println(min);
	}

	private static int findMinimum(int low, int end, int[] arr) {
		
		int mid = (low+end)/2;
		
		if(arr[mid-1]>arr[mid]){
			return arr[mid];
		}
		
		if(arr[mid]>arr[mid+1]){
			return arr[mid+1];
		}
		
		if(arr[end]>arr[mid]){
			findMinimum(low, mid-1, arr);
		}
		
		return findMinimum(mid+1, end, arr);
		
	}
}
