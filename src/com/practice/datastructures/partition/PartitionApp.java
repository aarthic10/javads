package com.practice.datastructures.partition;

class PartitionApp {
	public static void main(String[] args) {
		int maxSize = 16; // array size
		ArrayPar arr; // reference to array
		arr = new ArrayPar(maxSize); // create the array
		for (int j = 0; j < maxSize; j++) // fill array with
		{ // random numbers
			int n = (int) (java.lang.Math.random() * 199);
			arr.insert(n);
		}
		arr.display(); // display unsorted array
		int pivot = 99; // pivot value
		System.out.print("Pivot is " + pivot);
		int size = arr.size();
		// partition array
		int partDex = arr.partition(0, size - 1, pivot);
		System.out.println(", Partition is at index " + partDex);
		arr.display(); // display partitioned array
	}
}