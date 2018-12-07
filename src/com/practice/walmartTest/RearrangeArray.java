package com.practice.walmartTest;

public class RearrangeArray {

	static void rearrange(int[] arr, int n) {
		int outer = 0, temp;

		for (int inner = 0; inner < n; inner++) {
			if (arr[inner] < 0) {
				if (inner != outer) {
					temp = arr[inner];
					arr[inner] = arr[outer];
					arr[outer] = temp;

				}
				outer++;
			}
		}
	}

	static void printArray(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	// Driver code
	public static void main(String args[]) {
		int arr[] = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
		int n = arr.length;

		rearrange(arr, n);
		printArray(arr, n);
	}
}
