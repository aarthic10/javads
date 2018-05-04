package com.practice.datastructures.selectsort;

public class ArraySel {

	private int nElems;
	private long[] arr;

	public ArraySel(int max) {
		arr = new long[max];
		nElems = 0;
	}

	public void insert(long value) {
		arr[nElems] = value;
		nElems++;
	}

	public void display() {
		for (long value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

	public void selectionSort() {

		
		// int inner = outer;
		for (int outer = 0; outer <= nElems-2; outer++) {
			int min = outer;
			for (int inner = outer; inner <= nElems-1; inner++) {
				if (arr[inner] < arr[min]) {
					min = inner;
				}
				
			}
			swap(outer, min);
		}

	}
	
	public void swap(int outer, int min){
		long temp = arr[outer];
		arr[outer] = arr[min];
		arr[min] = temp;
	}
}
