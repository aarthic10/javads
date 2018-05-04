package com.practice.datastructures.quicksort;

public class ArrayIns {

	private int nElems;
	private int[] numbers;
	
	public ArrayIns(int max){
		numbers = new int[max];
	}
	
	public void insert(int value){
		numbers[nElems] = value;
		nElems++;
	}
	
	public void display(){
		for(int number: numbers){
			System.out.print(number+ ", ");
		}
		System.out.println();
	}
	
	public void quicksort(){
		recursiveQuickSort(0, nElems-1);
	}
	
	public void recursiveQuickSort(int left, int right){
		
		 
		if(right-left<=0){
			return;
		}else{
			int pivot = numbers[right];
			int partition = partition(left, right, pivot);
			recursiveQuickSort(left, partition-1);
			recursiveQuickSort(partition+1, right);
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
