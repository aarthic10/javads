package com.practice.datastructures.shellsort;

public class ArraySh {
	private long[] arr;
	private int nElems;

	public ArraySh(int max) {
		arr = new long[max];
	}

	public void insert(long value) {
		arr[nElems] = value;
		nElems++;
	}

	public void display() {
		for (long number : arr) {
			System.out.print(number + " ");
		}
		System.out.println();
	}

	public void shellSort() {

		int h = 1;
		while (h <= nElems / 3) {
			h = 3 * h + 1;
		}

		int inner = h, outer = h;
		long temp = 0;
		while (h > 0) {
			for (outer = h; outer < nElems; outer++) {
				temp = arr[outer];
				inner = outer;
				while(inner>h-1 && temp<=arr[inner-h]){
						arr[inner] = arr[inner-h];
						 inner=inner-h;
					}
				
				arr[inner] = temp;
			}
			h = (h - 1) / 3;
		}
	}

}
