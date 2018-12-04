package com.practice.walmartTest;

import java.util.Stack;

import com.practice.datastructures.binarytree.BinaryTree;
import com.practice.datastructures.binarytree.Node;

public class ZigZagBTTraversal {
	
	public static void main(String args[]) {
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
		
		printZigZagTraverse(theTree);
	}

	private static void printZigZagTraverse(BinaryTree theTree) {
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		
		stack1.add(theTree.root);
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				Node current = stack1.pop();
				System.out.println(current.data+" ");
				if(current.leftChild!=null) stack2.add(current.leftChild);
				if(current.rightChild!=null) stack2.add(current.rightChild);
			
			}
			
			while(!stack2.isEmpty()) {
				Node current = stack2.pop();
				System.out.println(current.data+" ");
				if(current.rightChild!=null) stack1.add(current.rightChild);
				if(current.leftChild!=null) stack1.add(current.leftChild);				
			}
		}
	}

}
