package com.practice.drishticon.test.top30Array.javarevisited;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Qn5IntegerPair {
	private static int[] nums = new int[]{2, 7, 11, 15};
	public static void main(String args[]){
		int[] numbers = new int[]{-1,0,1,2,7,9,10,11,12};
		/*printPairs(numbers, 11);
		printPairsPointers(numbers,11);
		printPairsRecursivePointers(0, numbers.length-1, 11);
		printPairsUsingSet(numbers, 11);*/
		
		int[] result = printPairs(9);
		System.out.println(result[0]+" "+result[1]);
	}
	
	private static int[] printPairs( int sum){
		
		//Leet Code - Unsorted Array
		
		Map<Integer, Integer> values= new HashMap<Integer, Integer>();
		
		for(int j=0; j<nums.length;j++){
			
			int num = nums[j];			
			int complement = sum - num;			
			if(values.containsKey(complement)){
				int pos = values.get(complement);
				if(pos!=j){
					return new int[]{pos, j};
				}
				
			}
			values.put(num, j);
			
		}
	
		
		
		return null;
		
		/*int inner = 0;
		int outer = numbers.length-1;
		int total = 0;
		while(inner <= outer){
			total = numbers[inner] + numbers[outer];
			if(total > sum ){
				outer--;
			}else if(total <sum){
				inner++;
			}else{
				System.out.println("Pair "+numbers[inner++]+" "+numbers[outer--]);				
			}
		}
		*/
		
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
		int actualSum = nums[inner] + nums[outer];
		if(inner == outer){
			System.out.println("Reached the end");
		}else if(actualSum == sum){
			System.out.println("Pair ("+nums[inner]+","+nums[outer]+")");
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
