package com.practice.datastructures.linklist;

public class DoubleLinklist {
	private Link first;
	private Link last;

	public DoubleLinklist() {
		first = null;
		last = null;
	}

	public void insertFirst(int iData) {
		Link newLink = new Link(iData, 0);
		if (first == null) {
			last = newLink;
			first = newLink;
		} else {
			newLink.next = first;
			first = newLink;
		}
	}

	public void insertLast(int iData) {
		Link newLink = new Link(iData, 0);
		if (first == null) {
			last = newLink;
			first = newLink;
		} else {
			last.next = newLink;
			last = newLink;

		}
	}

	public void deleteFirst() {
		System.out.println("--- Deleting first ---");
		if (first != null) {
			if (first == last) {
				System.out.println("Only one item in list");
				last = null;
			}
			first = first.next;

		}
	}

	public void displayList() {
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
	}

}
