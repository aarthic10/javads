package com.practice.walmartTest;

public class MergeSort {
	
	public static void mergeSort(int[] array, int leftStart, int rightEnd) {
		if(leftStart >= rightEnd) {
			return;
		}
		
		int mid = (leftStart + rightEnd)/2;
		mergeSort(array, leftStart, mid); //sort left half of array
		mergeSort(array, mid+1, rightEnd); //sort right half of array
		mergeHalves(array,leftStart,rightEnd);
		
	}
	
	public static void mergeHalves(int[]array, int leftStart, int rightEnd) {
		
		int[] temp = new int[array.length];
		int mid = (leftStart + rightEnd) / 2;
		int rightStart = mid + 1;
		
		int left = leftStart;
		int right = rightStart;
		int tempIndex = leftStart;
		
		while(left <= mid && right <= rightEnd) {
			if(array[left] <= array[right]) {
				temp[tempIndex] = array[left++];
			}else {
				temp[tempIndex] = array[right++];
			}
			tempIndex++;
		}
		
		System.arraycopy(array, left, temp, tempIndex, mid - left + 1);
		System.arraycopy(array, right, temp, tempIndex, rightEnd - right + 1);
		System.arraycopy(temp, leftStart, array, leftStart, rightEnd - leftStart + 1);
		
	}

	public static void main(String args[]) {
		int[] test = new int[] { 64,21,33,70,12,85,44,3,99,0,108,36 };
		mergeSort(test, 0, test.length - 1);
		for(int value : test) {
			System.out.print(value+" ");
		}
	}
}
