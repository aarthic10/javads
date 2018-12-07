package com.practice.walmartTest;

import com.practice.datastructures.binarytree.BinaryTree;
import com.practice.datastructures.binarytree.Node;

public class BalancedBST {

	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int n = arr.length;
		Node root = sortedArrayToBST(arr, 0, n - 1);
		System.out.println("Preorder traversal of constructed BST");
		preOrder(root);
	}

	private static Node sortedArrayToBST(int[] arr, int left, int right) {

		if (left > right) {
			return null;
		}
		int mid = (left + right) / 2;
		Node node = new Node(arr[mid]);
		node.leftChild = sortedArrayToBST(arr, left, mid - 1);
		node.rightChild = sortedArrayToBST(arr, mid + 1, right);

		return node;
	}

	private static void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preOrder(node.leftChild);
		preOrder(node.rightChild);
	}

}
