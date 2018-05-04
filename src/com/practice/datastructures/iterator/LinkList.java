package com.practice.datastructures.iterator;

public class LinkList {
	private Link first;
	
	public LinkList(){
		first = null;
	}
	
	public Link getFirst(){
		return first;
	}
	
	public void setFirst(Link link){
		first = link;
	}
	
	public boolean getIsEmpty(){
		return first == null;
	}
	
	public ListIterator getIterator(){
		return new ListIterator(this);
	}
	
	public void displayList(){
		Link current = first;
		System.out.println("Displaying List");
		while(current!=null){
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
		
	}
}
