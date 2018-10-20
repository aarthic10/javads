package com.practice.datastructures.insertsort;

public class ArrayIns {

	private long[] arr;
	private int nElems;

	public ArrayIns(int max) {
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

	public void insertionSort2() {
		long temp;
		int inner;
		
		for(int outer=1; outer < nElems; outer++){
			temp = arr[outer];
			for(inner=outer; inner>0; inner--){
				if(temp < arr[inner-1]){
					arr[inner] = arr[inner-1];
				}else{
					break;
				}
			}			
			arr[inner] = temp;
		}

	}

	public void insertionSort() {
		long temp;
		int inner;

		for (int outer = 1; outer < nElems; outer++) {
			temp = arr[outer];
			System.out.println("temp " + temp);
			for (inner = outer; inner > 0; inner--) {

				if (arr[inner - 1] > temp) {
					arr[inner] = arr[inner - 1];
				} else {
					break;
				}
			}
			arr[inner] = temp;

		}

	}

}
