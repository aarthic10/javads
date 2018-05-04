package com.practice.datastructures;

public class ArrayApp {
	public static void main(String[] args) {
		long[] arr = new long[100];
		int size = 0; // number of items
		int j; // loop counter
		long searchKey; // key of item to search for
		
		
		arr[0] = 77; 
		arr[1] = 99;
		arr[2] = 44;
		arr[3] = 55;
		arr[4] = 22;
		arr[5] = 88;
		arr[6] = 11;
		arr[7] = 00;
		arr[8] = 66;
		arr[9] = 33;
		size = 10;
		
		// display items
		for (j = 0; j < size; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println("");
		
		// Linear search
		searchKey = 66;
		for (j = 0; j < size; j++) {
			if (arr[j] == searchKey) {
				// found item
				break;
			}
		}
		if (j == size) {
			System.out.println("Can’t find " + searchKey);
		} else {
			System.out.println("Found " + searchKey+" at position "+j); 
		}
		
		// delete item with key 55
		searchKey = 55;
		for (j = 0; j < size; j++) {
			if (arr[j] == searchKey){
				break;
			}
		}
		for (int k = j; k < size - 1; k++) {
			arr[k] = arr[k + 1];// move one place forward
		}
	
		size--; // decrement size since one item is removed
		
		
		for (j = 0; j < size; j++){
			// display items
			System.out.print(arr[j] + " ");
		}
		System.out.println("");			
	}
}