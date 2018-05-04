package com.practice.drishticon.test.top30Array.javarevisited;

class Qn18AlternateRearrangeArray {
	// Utility function to right rotate all elements
	// between [outofplace, cur]
	void rightrotate(int arr[], int n, int outofplace, int cur) {
		int tmp = arr[cur];
		for (int i = cur; i > outofplace; i--)
			arr[i] = arr[i - 1];
		arr[outofplace] = tmp;
	}

	void rearrange(int arr[], int n) {
		int outofplace = -1;

		for (int i = 0; i < n; i++) {
			if (outofplace >= 0) {
				// find the item which must be moved into the out-of-place
				// entry if out-of-place entry is positive and current
				// entry is negative OR if out-of-place entry is negative
				// and current entry is negative then right rotate
				//
				// [...-3, -4, -5, 6...] --> [...6, -3, -4, -5...]
				// ^ ^
				// | |
				// outofplace --> outofplace
				//
				if (((arr[i] >= 0) && (arr[outofplace] < 0)) || ((arr[i] < 0) && (arr[outofplace] >= 0))) {
					rightrotate(arr, n, outofplace, i);

					// the new out-of-place entry is now 2 steps ahead
					if (i - outofplace > 2)
						outofplace = outofplace + 2;
					else
						outofplace = -1;
				}
			}

			// if no entry has been flagged out-of-place
			if (outofplace == -1) {
				// check if current entry is out-of-place
				if (((arr[i] >= 0) && ((i % 2) == 0)) || ((arr[i] < 0) && (i % 2) == 1))
					outofplace = i;
			}
		}
	}

	// A utility function to print an array 'arr[]' of size 'n'
	void printArray(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");
	}

	private void myRearrageArray(int[] arr, int size) {
		int misplaced = -1;

		for (int i = 0; i < size; i++) {

			if (misplaced >= 0) {
				if ((arr[i] < 0 && arr[misplaced] >= 0) || (arr[i] >= 0 && arr[misplaced] < 0)) {
					rightrotate(arr, size, misplaced, i);

					if (i - misplaced > 2) {
						misplaced = misplaced + 2;
					} else {
						misplaced = -1;
					}
				}
			}

			if (misplaced == -1) {
				if ((arr[i] > 0 && i % 2 == 0) || (arr[i] < 0 && i % 2 != 0)) {
					misplaced = i;
				}
			}
		}

	}

	public static void main(String[] args) {
		Qn18AlternateRearrangeArray rearrange = new Qn18AlternateRearrangeArray();
		// int arr[n] = {-5, 3, 4, 5, -6, -2, 8, 9, -1, -4};
		// int arr[] = {-5, -3, -4, -5, -6, 2 , 8, 9, 1 , 4};
		// int arr[] = {5, 3, 4, 2, 1, -2 , -8, -9, -1 , -4};
		// int arr[] = {-5, 3, -4, -7, -1, -2 , -8, -9, 1 , -4};
		int arr[] = { 1, 2, -4, 3, -1, 4 };
		// int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
		int n = arr.length;

		System.out.println("Given array is ");
		rearrange.printArray(arr, n);

		rearrange.myRearrageArray(arr, n);

		System.out.println("RearrangeD array is ");
		rearrange.printArray(arr, n);
	}
}