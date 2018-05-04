package com.practice.datastructures.quicksort;

class QuickSort1App {
	public static void main(String[] args) {
		int maxSize = 16; // array size
		ArrayIns arr;
		arr = new ArrayIns(maxSize); // create array
		for (int j = 0; j < maxSize; j++) // fill array with
		{ // random numbers
			int n = (int) (java.lang.Math.random() * 99);
			arr.insert(n);
		}
		arr.display(); // display items
		arr.quicksort(); // quicksort them
		arr.display(); // display them again
	} // end main()
}