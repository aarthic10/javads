package com.practice.datastructures.queue;

public class Queue {

	private int front;
	private int rear;
	private long[] arr;
	private int nItems;
	private int max;
	
	public Queue(int limit){
		max = limit;
		arr = new long[max];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	public void insert(long value){
		if(rear==max-1){
			rear = -1;
		}
		nItems++;
		
		arr[++rear] = value;		
	}
	
	public long remove(){
		if(front==max){
			front = 0;
		}
		nItems--;
		return arr[front++];
	}
	
	public long peek(){
		return arr[front];
	}
	
	public boolean isFull(){
		return nItems==max ? true : false;
	}
	
	public boolean isEmpty(){
		return nItems==0 ? true : false;
	}
	
	public int size(){
		return nItems;
	}
}
