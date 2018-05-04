package com.practice.drishticon.test.top30Array.javarevisited;

public class Q13CommonThreeSortedArrays {
	private static int arr1[] = new int[] { 1, 5, 10, 20, 40, 80 };
	private static int arr2[] = new int[] { 6, 7, 20, 80, 100 };
	private static int arr3[] = new int[] { 3, 4, 15, 20, 30, 70, 80, 120 };

	public static void main(String args[]) {
		printCommonElements(arr1.length, arr2.length, arr3.length);
	}

	private static void printCommonElements(int arr1Size, int arr2Size, int arr3Size) {
		int i = 0;
		int j = 0;
		int k = 0;

		while (i < arr1Size && j < arr2Size && k < arr3Size) {
			if(arr1[i]==arr2[j]&& arr2[j]==arr3[k]){
				System.out.println(arr1[i]);
				i++;
				j++;
				k++;
			}
			else if(arr1[i]<arr2[j]){
				i++;
			}else if(arr2[j]<arr3[k]){
				j++;
			}else{
				k++;
			}

		}

	}

}
