package com.practice.drishticon.test.top30Array.javarevisited;

public class Qn10UniqueNumber {
	public static void main(String args[]) {
		int i = findUniqueNumber(new int[] { 1, 1, 2, 2, 3, 4, 4, 5, 5 });
		System.out.println(i);
		printXORUniqueNumber(new int[] { 1, 1, 2, 2, 4, 4, 5, 5, 7 });
		
		//Cant Understand
		System.out.println(getSingle(new int[] {3, 3, 2, 3}));
	}

	/*
	 * For instance, if your array contains the elements [3, 4, 5, 3, 4], the
	 * algorithm will return 3 ^ 4 ^ 5 ^ 3 ^ 4 But the XOR operator ^ is
	 * associative and commutative, so the result will be also equal to: (3 ^ 3)
	 * ^ (4 ^ 4) ^ 5 Since i ^ i = 0 for any integer i, and i ^ 0 = i, you have
	 * (3 ^ 3) ^ (4 ^ 4) ^ 5 = 0 ^ 0 ^ 5 = 5
	 */
	private static void printXORUniqueNumber(int[] numbers) {
		int result = 0;
		for (int number : numbers) {
			result = result ^ number;
		}
		System.out.println(result);
	}

	// only one unpaired number
	private static int findUniqueNumber(int[] numbers) {

		for (int i = 0; i < numbers.length - 1; i = i + 2) {
			if (numbers[i] != numbers[i + 1])
				return numbers[i];
		}
		return numbers[numbers.length - 1];
	}

	

	private static int getSingle(int arr[]) {
		 int ones = 0 ; //At any point of time, this variable holds XOR of all the elements which have appeared "only" once.
		    int twos = 0 ; //At any point of time, this variable holds XOR of all the elements which have appeared "only" twice.
		    int not_threes ;

		    for( int x : arr )
		    {
		        twos |= ones & x ; //add it to twos if it exists in ones
		        ones ^= x ; //if it exists in ones, remove it, otherwise, add it

		        // Next 3 lines of code just converts the common 1's between "ones" and "twos" to zero.

		        not_threes = ~(ones & twos) ;//if x is in ones and twos, dont add it to Threes.
		        ones &= not_threes ;//remove x from ones
		        twos &= not_threes ;//remove x from twos
		    } 
		    return ones;
	}
}
