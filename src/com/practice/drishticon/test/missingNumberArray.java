package com.practice.drishticon.test;

import java.util.Arrays;
import java.util.BitSet;

public class missingNumberArray {

	public static void main(String[] args) {
		int missingNum = missingNumber(new int[] { 1, 2, 3, 4, 6 }, 6);
		printSortedMissingNumbers(new int[]{1, 2, 5, 6, 7, 8, 9, 10}, 10);
		
		/*We can implement our own bitset by setting in a new array the values as 1 
		 * in the appropriate place for the number that is present
		 * bitset.set(number-1) 
		 * 
		 * own bitset code: arr[number-1] = 1
		 * */
		printMissingNumbers(new int[]{1, 2, 3, 4, 6, 7, 8, 10}, 10); //Using Bitset
		
		
		System.out.println("Single Missing Number "+missingNum);

	}

	private static int missingNumber(int[] a, int n) {
		int num = 0;
		int sum = (n * (n + 1)) / 2;
		int actualSum = 0;
		for (int i : a) {
			actualSum = actualSum + i;
		}

		num = sum - actualSum;
		return num;
	}
	
	
	private static void printSortedMissingNumbers(int[] numbers, int count) {
		int i = 0;
		int missingSize = count-numbers.length;
		int missing = 0 ;
		for(int j=1; j<count && missingSize!=missing; j++){
			if(j == numbers[i]){
				i++;
			}else{
				missing++;
				System.out.println(j);				
			}
		}
	}

	private static void printMissingNumbers(int[] numbers, int count) {
		int missingCount = count - numbers.length;
		BitSet bitSet = new BitSet(count);
		for (int number : numbers) {
			bitSet.set(number - 1);
		}
		System.out.printf("Missing numbers in integer array %s, with total number %d is %n", Arrays.toString(numbers),
				count);
		int lastMissingIndex = 0;
		for (int i = 0; i < missingCount; i++) {
			lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
			System.out.println(++lastMissingIndex);
		}
	}

}
