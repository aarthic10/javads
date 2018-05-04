package com.practice.datastructures.stack;

public class StackX {

	private int nElems;
	private long[] stackArray;
	private int top;
	
	public StackX(int max){
		stackArray = new long[max];
		nElems = max;
		top = -1;
	}
	
	public void push(long value){
		stackArray[++top] = value;
	}
	
	public long pop(){		
		return stackArray[top--];
	}
	
	public long peek(){
		return stackArray[top];
	}
	
	public boolean isFull(){
		return top==nElems;
	}
	
	public boolean isEmpty(){
		return top==-1;
	}
}
