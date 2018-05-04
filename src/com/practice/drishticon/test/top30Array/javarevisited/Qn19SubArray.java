package com.practice.drishticon.test.top30Array.javarevisited;

public class Qn19SubArray {

	
	public static void main(String args[]){
		printSubArrayEqualZero(new int[] {-3, 2, 3, 1, 6});
	}

	private static void printSubArrayEqualZero(int[] arr) {
		for(int curr = 0; curr<arr.length;curr++){
			int res = arr[curr];
			for(int end = curr+1;end<arr.length;end++){
				res = res + arr[end];
				
				if(arr[end]==0){
					System.out.println("From index "+end+" to "+end);
					break;
				}
				if(res > 0){
					break;
				}else if(res == 0){
					System.out.println("From index "+curr+" to "+end);
					break;
				}
				
				
			}
		}
		
	}
}
