package com.practice.datastructures.linklist;

class SortedListApp {
	
	public static void main(String[] args) {

		SortedLinkList theSortedList = new SortedLinkList();
		theSortedList.insert(20);
		theSortedList.insert(40);
		theSortedList.displayList(); // display list
		theSortedList.insert(10); // insert 3 more items
		theSortedList.insert(30);
		theSortedList.insert(50);
		theSortedList.displayList();
		theSortedList.remove(); // remove an item
		theSortedList.displayList();
		
	}
}
