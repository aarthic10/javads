package com.practice.drishticon.test.top30Array.javarevisited;

import java.util.HashSet;
import java.util.Set;

public class Qn5IntegerPair {
	private static int[] numbers = new int[]{-1,0,1,2,7,9,10,11,12};
	public static void main(String args[]){
		int[] numbers = new int[]{-1,0,1,2,7,9,10,11,12};
		printPairs(numbers, 11);
		printPairsPointers(numbers,11);
		printPairsRecursivePointers(0, numbers.length-1, 11);
		printPairsUsingSet(numbers, 11);
		
		
	}

	private static void printPairsPointers(int[] numbers, int sum) {
		int actualSum = 0;
		int inner = 0;
		int outer = numbers.length -1;
		
		while(inner!=outer){
			actualSum = numbers[inner] + numbers[outer];
			if(actualSum == sum){
				System.out.println("Pair ("+numbers[inner++]+","+numbers[outer--]+")");				
			}else if(actualSum > sum){
				inner++;
			}else if(actualSum < sum){
				outer--;
			}
		}
	}
	
	private static void printPairsRecursivePointers(int inner, int outer, int sum){
		int actualSum = numbers[inner] + numbers[outer];
		if(inner == outer){
			System.out.println("Reached the end");
		}else if(actualSum == sum){
			System.out.println("Pair ("+numbers[inner]+","+numbers[outer]+")");
			printPairsRecursivePointers(++inner, --outer, sum);
		}else if(actualSum > sum){
			printPairsRecursivePointers(++inner, outer, sum);
		}else if(actualSum < sum){
			printPairsRecursivePointers(inner, --outer, sum);
		}
	}

	private static void printPairs(int[] numbers, int sum) {
		int first = 0;
		int second = 0;
		for(int i=0;i<numbers.length;i++){
			first = numbers[i];
			for(int j=i+1;j<numbers.length;j++){
				second = numbers[j];
				if((first+second)== sum ){
					System.out.println("Pair ("+first+","+second+")");
				}
			}
		}
		
	}
	
	private static void printPairsUsingSet(int[] numbers,int sum){
		Set<Integer> values = new HashSet<Integer>();
		int second = 0;
		for(int number:numbers){
			second = sum-number;
			if(values.contains(second)){
				System.out.println("Pair ("+number+","+second+")");
			}else{
				values.add(number);
			}
		}
		
	}
}
