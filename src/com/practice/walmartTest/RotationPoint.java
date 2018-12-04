package com.practice.walmartTest;



public class RotationPoint {

	public static void main(String[] args) {
		int[] arr = new int[] {5, 6, 7, 8, 9, 10, 1, 2, 3};
		
		int n = arr.length; 
	       int key = 9; 
	       System.out.println("Index of the element is : "
	                      + pivotedBinarySearch(arr, n, key)); 
	}
	
	public static int pivotedBinarySearch(int[] arr, int size, int key) {
		
		int pivot = findPivot(arr, 0, size -1);
		
		System.out.println("Pivot position is "+pivot);
		if(pivot == -1) {
			return binarySearch(arr,0,size-1, key);
		}
		
		if(arr[0] <= key) {
			return binarySearch(arr, 0, pivot-1, key);
		}else {
			return binarySearch(arr, pivot+1, size-1, key);
		}
		
		
	}
	
	public static int binarySearch(int[] arr, int start, int end, int key) {
		
		int mid = (start + end) / 2;
		
		if(arr[mid] == key) {
			return mid;
		}
		
		if(start >= end) {
			return -1;
		}
		
		if(arr[mid] > key) {
			return binarySearch(arr, start, mid-1, key);
		}else {
			return binarySearch(arr, mid+1, end, key);
			
		}
		
	}
	
	public static int findPivot(int[] arr, int lowerBound, int upperBound) {
		
		if(lowerBound > upperBound) {
			return -1;
		}
		
		if(lowerBound == upperBound) {
			return lowerBound;
		}
		
		int mid = (lowerBound + upperBound) / 2;
		
		if(arr[mid] > arr[mid+1]) {
			return mid;
		} 
		
		if(arr[mid-1] > arr[mid]) {
			return (mid-1);
		}
		
		if(arr[lowerBound] >= arr[mid]) {
			return findPivot(arr, lowerBound, mid-1);
		}else {
			return findPivot(arr, mid+1, upperBound);
		}
		
	}
	
}
