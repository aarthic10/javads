package com.practice.datastructures.linklist;

public class LinkList {

	private Link first;

	public boolean isEmpty() {
		return (first == null);
	}

	public void insertFirst(int id, double dd) {
		Link newLink = new Link(id, dd);
		newLink.next = first;
		first = newLink;
	}

	public Link deleteFirst() {
		Link temp = first;
		first = first.next;
		return temp;
	}

	public void displayLinkList() {
		System.out.println("Displaying LinkList ");
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}

	public Link find(int key) {
		Link current = first;
		// boolean isExist = false;
		while (current != null) {
			int value = current.getiData();
			if (key == value) {
				// isExist = true;
				return current;
			}
			current = current.next;
		}

		return null;
	}

	public Link delete(int key) {
		Link next = null;
		Link current = first;
		boolean isExist = false;
		if (current.getiData() == key) {
			first = current.next;
			return current;
		}
		while (current.next != null) {
			next = current.next;
			if (next.getiData() == key) {
				current.next = next.next;
				break;
			}
			current = next;
		}
		if (!isExist) {
			next = null;
		}

		return next;
	}

	public void reverseList() {
		Link prev = first;
		Link next = first.next;
		prev.next = null;
		while (next != null) {
			first = next;
			next = first.next;
			first.next = prev;
			prev = first;
		}
	}

	public void recursiveRev(){
		recursiveReverseLinkList(first);
	}
	
	public Link recursiveReverseLinkList(Link head) {
		
		if(head == null || head.next == null){
			first = head;
			return head;
		}
		
		//Break all the next links
		Link second = head.next;
		head.next = null;
		
		recursiveReverseLinkList(second);
		
		//reverse the links. Last to prev
		second.next = head;
		
		
		return head;
				
	}
	
}
