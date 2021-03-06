package com.practice.datastructures.linklist;

class LinkListApp {
	
	public static void main(String[] args) {
		
		LinkList theList = new LinkList(); // make new list
		theList.insertFirst(22, 2.99); // insert four items
		theList.insertFirst(44, 4.99);
		theList.insertFirst(66, 6.99);
		theList.insertFirst(88, 8.99);
		theList.displayLinkList(); // display list
		
		Link element = theList.find(22);
		if(null != element){
			element.displayLink();
		}else{
			System.out.println("No Element Found!!");
		}
		
		theList.recursiveRev();
		theList.displayLinkList();
		
		/*while (!theList.isEmpty()) // until it�s empty,
		{
			Link aLink = theList.deleteFirst(); // delete link
			System.out.print("Deleted "); // display it
			aLink.displayLink();
			System.out.println("");
		}
		theList.displayLinkList(); */// display list
		
	} 
} 