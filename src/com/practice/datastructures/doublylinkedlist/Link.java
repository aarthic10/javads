package com.practice.datastructures.doublylinkedlist;

public class Link {

	public Link next;
	public Link previous;
	private long dData;
	
	public Link(long data){
		dData = data;
	}

	public long getdData() {
		return dData;
	}
	
	public void displayLink(){
		System.out.print(dData+" ");
	}
	
}
