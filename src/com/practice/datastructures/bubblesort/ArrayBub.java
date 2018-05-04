package com.practice.datastructures.bubblesort;

public class ArrayBub {

	private int nElems;
	private long[] arr;
	
	public ArrayBub(int max){
		arr = new long[max];
		nElems = 0;
	}
	
	public void insert(long value){
		arr[nElems] = value;
		nElems++;
	}
	
	public void display(){
		for(long value:arr){
			System.out.print(value+" ");
		}
		System.out.println("");
	}
	
	public void bubbleSort2(){
		int inner = 0;
		int outer = nElems-1;
		
		for(;outer>=0;outer--){
			for(inner=0;inner<nElems-1;inner++){
				if(arr[inner]>arr[inner+1]){
					long temp = arr[inner];
					arr[inner] = arr[inner+1];
					arr[inner+1] = temp;
					continue;
				}
			}			
		}
	}
	
	public void bubbleSort(){
		
		for(int out=nElems-1;out>0;out--){// outer loop (backward)
			
			for(int in=0;in<out;in++){// inner loop (forward)
				
				if(arr[in]>arr[in+1]){
					swap(in);
				}
			}
		}
	}
	
	public void swap(int in){
		long temp = arr[in];
		arr[in] = arr[in+1];
		arr[in+1]=temp;
	}
	
}
