package com.practice.datastructures.linklist;

public class SortedLinkList {

	private Link first;

	public SortedLinkList() {
		first = null;
	}

	public void insert(int iData) {
		Link newLink = new Link(iData, 0);
		Link current = first;
		Link previous = null;

		while (current != null && current.getiData() < iData) {
			previous = current;
			current = current.next;
		}

		if (previous != null) {
			previous.next = newLink;
		} else {
			first = newLink;
		}
		newLink.next = current;

	}

	public void remove() {
		first = first.next;

	}

	public void displayList() {
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}

}
