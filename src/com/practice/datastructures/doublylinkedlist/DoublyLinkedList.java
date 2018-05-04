package com.practice.datastructures.doublylinkedlist;

public class DoublyLinkedList {

	private Link first;
	private Link last;

	public DoublyLinkedList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insertFirst(long data) {
		Link newLink = new Link(data);

		if (isEmpty()) {
			last = newLink;
		} else {
			first.previous = newLink;
			newLink.next = first;
		}

		first = newLink;
	}

	public void insertLast(long data) {
		Link newLink = new Link(data);
		if (isEmpty()) {
			first = newLink;
		} else {
			last.next = newLink;
			newLink.previous = last;
		}

		last = newLink;
	}

	public void displayForward() {
		Link current = first;
		System.out.println("Displaying List Forward");
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println("");

	}

	public void displayBackward() {
		Link current = last;
		System.out.println("Displaying List Backward");
		while (current != null) {
			current.displayLink();
			current = current.previous;
		}
		System.out.println("");
	}

	public Link deleteFirst() {
		Link temp = first;
		
		if(first.next==null){ //only one item in the list
			last = null;
		}else{
			first.next.previous = null;
		}
		
		
		first = first.next;
		return temp;
	}

	public Link deleteLast() {
		Link temp = last;
		
		if(first.next == null){
			first = null;
		}else{
			last.previous.next = null;
		}	
		
		last = last.previous;
		return temp;
	}

	public Link deleteKey(long key) {
		Link current = first;
		while (current != null && current.getdData() != key) {
			current = current.next;
		}
		if (current != null) {
			Link previousLink = current.previous;
			Link nextLink = current.next;
			
			if(current == first){ //first item to be deleted
				first = nextLink;
			}else{
				previousLink.next = nextLink;	
			}
			
			if (current == last) { //last item to be deleted
				last = previousLink;
			}else{
				nextLink.previous = previousLink;
			}
		}

		return current;
	}
	
	
	public void insertAfter(long key, long data){
		Link current = first;
		Link newLink = new Link(data);
		while(current!=null && current.getdData() != key){
			current = current.next;
		}
		if(current == last){ // if inserting at the last
			last = newLink;
		}
		if(current!=null){
			Link next = current.next;
			current.next = newLink;
			newLink.previous = current;
			newLink.next = next;
		}
	}
}
