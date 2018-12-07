package com.practice.walmartTest;

import com.practice.datastructures.binarytree.BinaryTree;
import com.practice.datastructures.binarytree.Node;

public class MirrorBTTraversal {

	public static void main(String args[]) {
		BinaryTree theTree = new BinaryTree(); // make a tree
		theTree.insert(50);
		theTree.insert(40);
		theTree.insert(30);
		theTree.insert(20);
		theTree.insert(10);
		theTree.insert(70);
		theTree.insert(60);
		theTree.insert(80);
		
		
		mirror(theTree.root);
		preOrderTraversal(theTree.root);
	}
	
	
	private static void mirror(Node root) {
		if(root!=null) {
			mirror(root.leftChild);
			mirror(root.rightChild);
			
			//swap
			Node temp = root.leftChild;
			root.leftChild = root.rightChild;
			root.rightChild = temp;
			
		}		
	}
	
	private static void preOrderTraversal(Node root) {
		if(root!=null) {
			System.out.println(root.data);
			preOrderTraversal(root.leftChild);
			preOrderTraversal(root.rightChild);
		}
	}
	
}
