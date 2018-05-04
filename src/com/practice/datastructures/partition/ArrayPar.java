package com.practice.datastructures.partition;

public class ArrayPar {

	public int nElems;
	public int[] arr;
	
	public ArrayPar(int max){
		arr = new int[max];
	}
	
	public void insert(int number){
		arr[nElems] = number;
		nElems++;
	}
	
	public void display(){
		for(int number:arr){
			System.out.print(number + " ");
		}
		System.out.println();
	}
	
	public int size(){
		return nElems;
	}
	public int partition(int left, int right, int pivot){
		int leftPtr = left;
		int rightPtr = right;
		int temp = 0;
		
		while(leftPtr<=rightPtr){
			if(arr[leftPtr]>pivot){
				while(rightPtr>=leftPtr){
					if(arr[rightPtr]<pivot){
						temp = arr[leftPtr];
						arr[leftPtr] = arr[rightPtr];
						arr[rightPtr] = temp;
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
		
		return leftPtr;
	}
	
	
}
