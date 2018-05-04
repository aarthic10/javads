package com.practice.datastructures.iterator;

public class ListIterator {
	
	private LinkList list;
	private Link current;
	private Link previous;
	
	public ListIterator(LinkList currentList){
		list = currentList;
	}
	
	public void reset(){
		current = list.getFirst();
		previous = null;
	}
	
	public Link nextLink(){
		previous = current;
		current = current.next;
		return current;
	}
	
	public Link getCurrent(){
		return current;
	}
	
	public boolean atEnd(){
		return current.next == null;
	}
	
	public void insertAfter(long dd){
		Link newLink = new Link(dd);
		if(list.getIsEmpty()){
			list.setFirst(newLink);
			current = newLink;
		}else{
			Link next = current.next;
			current.next = newLink;
			newLink.next = next;
			nextLink();
		}
	}
	
	public void insertBefore(long dd){
		Link newLink = new Link(dd);
		if(previous == null){
			newLink.next = list.getFirst();
			list.setFirst(newLink);
			reset();
		}else{
			previous.next = newLink;
			newLink.next = current;
			current = newLink;
		}
	}
	
	public long deleteCurrent(){
		long value = current.dData;
		if(previous == null){ // empty or first item	
			if(current == null){
				list.setFirst(null);
			}else{
				list.setFirst(current.next);
			}
			reset();			
		}else{					
			previous.next = current.next;
			if(atEnd()){
				reset();
			}else{
				current = current.next;
			}
		}
		
		return value;
	}
}
