package com.practice.datastructures.quicksort;

public class ArrayIns2 {

	private int nElems;
	private int[] numbers;
	
	public ArrayIns2(int max){
		numbers = new int[max];
	}
	
	public void insert(int value){
		numbers[nElems] = value;
		nElems++;
	}
	
	public void display(){
		for(int number: numbers){
			System.out.print(number+ " ");
		}
		System.out.println();
	}
	
	public void quicksort(){
		recursiveQuickSort(0, nElems-1);
	}
	
	public void recursiveQuickSort(int left, int right){
		
		int size = (right-left)+1;
		if(size<=3){
			manualSort(left,right);
		}else{
			int pivot = findPivot(left,right);
			int partition = partition(left, right, pivot);
			recursiveQuickSort(left, partition-1);
			recursiveQuickSort(partition+1, right);
		}
		
	}
	
	private int findPivot(int left, int right) {
		int median = (left+right)/2;
		if(numbers[left]>numbers[median]){
			swap(left,median);
		}
		if(numbers[left]>numbers[right]){
			swap(left,right);
		}
		if(numbers[median]>numbers[right]){
			swap(median,right);
		}
		swap(median,right);
		return numbers[right];
	}

	private void manualSort(int left, int right) {
		int actualSize = (right-left)+1;
		if(actualSize<=1){
			return;
		}else if(actualSize == 2){
			if(numbers[left]>numbers[right]){
				swap(left,right);
			}
		}else if(actualSize == 3){
			if(numbers[left]>numbers[left+1]){
				swap(left,left+1);
			}
			if(numbers[left]>numbers[right]){
				swap(left,right);
			}
			if(numbers[left+1]>numbers[right]){
				swap(left+1,right);
			}
		}
	}

	public int partition(int left, int right, int pivot){
		int leftPtr = left;
		int rightPtr = right-1;
		
		while(leftPtr<=rightPtr){
			if(numbers[leftPtr]>pivot){
				while(rightPtr>=leftPtr){
					if(numbers[rightPtr]<pivot){
						swap(leftPtr, rightPtr);
						leftPtr++;
						rightPtr --;
						break;
					}else{
						rightPtr --;
					}
				}
			}else{
				leftPtr++;
			}
		}
		swap(leftPtr, right);
		return leftPtr;
	}

	private void swap(int leftPtr, int rightPtr) {
		int temp;
		temp = numbers[leftPtr];
		numbers[leftPtr] = numbers[rightPtr];
		numbers[rightPtr] = temp;
	}
}
