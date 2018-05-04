package com.practice.datastructures.linklist;

public class Link {

	private int iData;
	private double dData;
	public Link next;
	
	public Link(int d, double dd){
		iData = d;
		dData = dd;
	}
	
	public void displayLink(){
		System.out.println("{"+iData+","+dData+"}");
	}

	public int getiData() {
		return iData;
	}

	public double getdData() {
		return dData;
	}
	
}
