package com.practice.drishticon.test;

public class searchNumberArray {

	private static int[] numbers = new int[] { 1, 2, 3, 4, 6, 7, 8, 10 };
	private static int[] trickNum = new int[] { -3, -1, 0, 1, 3, 5 };
	
	public static void main(String[] args) {
		searchNumber(new int[] { 1, 2, 3, 4, 6, 7, 8, 10 }, 2);
		binarySearchNumber(0, numbers.length - 1, 3);
		trickyBinarySearchNumber(0, trickNum.length);
	}

	private static void searchNumber(int[] numbers, int searchNum) {
		// Sequential Search
		for (int number : numbers) {
			if (number == searchNum) {
				System.out.println("Sequential Search --> Found number " + searchNum);
				break;
			}
		}
	}

	private static void binarySearchNumber(int startPos, int endPos, int searchNum) {
		int mid = (startPos + endPos) / 2;
		int midValue = numbers[mid];
		if (midValue == searchNum) {
			System.out.println("Found number " + searchNum + " at position " + mid);
		}else if(startPos == endPos){
			System.out.println("Number not found");
		}else if (searchNum > midValue) {
			binarySearchNumber(mid + 1, endPos, searchNum);
		} else if (searchNum < midValue) {
			binarySearchNumber(startPos, mid - 1, searchNum);
		} 

	}

	/*Consider a Java or C++ array say X which is sorted and no two elements in it are same. 
	How best can you find an index say i such that element at that index is also i. That is X[i] = i
	eg:
		 Array X : -3 -1 0 3 5 7 
      	 index   :  0  1 2 3 4 5

      Answer is 3 as X[3] = 3.
	*/
	
	private static void trickyBinarySearchNumber(int startPos, int endPos) {
		int midPos = (startPos + endPos)/2;
		int midValue = trickNum[midPos];
		if(midValue == midPos){
			System.out.println("Match in position "+midPos);
		}else if( midValue > midPos){
			trickyBinarySearchNumber(startPos, midPos-1);
		}else if(midValue < midPos){
			trickyBinarySearchNumber(midPos+1, endPos);
		}
		
	}
}
