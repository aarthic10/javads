package com.practice.datastructures.binarytree;

import com.practice.datastructures.stack.StackX;

public class TraversalStack {
	public static void main(String args[]){
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
		
		theTree.postOrderTraverse();
		theTree.stackPostOrderTraverse();
		
		
	}
}
