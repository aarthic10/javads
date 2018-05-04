package com.practice.datastructures.binarytree;

class TreeApp {
	public static void main(String[] args) {
		BinaryTree theTree = new BinaryTree(); // make a tree
		theTree.insert(50);
		theTree.insert(25);
		theTree.insert(75);
		theTree.insert(12);
		theTree.insert(37);
		theTree.insert(43);
		theTree.insert(30);
		theTree.insert(33);
		theTree.insert(31);
		theTree.insert(34);
		theTree.insert(87);
		theTree.insert(93);
		theTree.insert(97);
		Node found = theTree.find(25); // find node with key 25
		if (found != null)
			System.out.println("Found the node with key 25");
		else
			System.out.println("Could not find node with key 25");

		System.out.println("Inorder Traversal");
		theTree.inorderTraverse();
		System.out.println("Preorder Traversal");
		theTree.preOrderTraverse();
		System.out.println("Postorder Traversal");
		theTree.postOrderTraverse();
		
		theTree.delete(25);
		System.out.println("Inorder Traversal");
		theTree.inorderTraverse();
		theTree.displayRoot();
		System.out.println("Minimum value is " + theTree.minimum());
		System.out.println("Maximum value is " + theTree.maximum());
	} // end main()
}