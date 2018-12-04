package com.practice.datastructures.binarytree;

public class BinaryTree {
	public Node root;

	public void displayRoot() {
		System.out.println("Root " + root.data);
	}

	public void insert(int value) {
		Node newNode = new Node(value);
		if (root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node parent;
			while (true) {
				parent = current;
				if (value < current.data) {
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public int minimum() {
		int min = root.data;
		Node current = root;
		Node parent = root;
		while (current != null) {
			parent = current;
			current = current.leftChild;

		}
		if (parent != null)
			min = parent.data;

		return min;
	}

	public int maximum() {
		int max = root.data;
		Node current = root;
		Node parent = root;
		while (current != null) {
			parent = current;
			current = current.rightChild;
		}

		if (parent != null)
			max = parent.data;

		return max;
	}

	public void delete(int data) {
		Node current = root;
		Node parent = root;
		Boolean isLeftChild = true;
		while (current != null) {
			if (current.data == data) {

				// Deleting leaf node
				if (current.leftChild == null && current.rightChild == null) {
					if (current == root) {
						root = null;
					} else if (isLeftChild) {
						parent.leftChild = null;
					} else {
						parent.rightChild = null;
					}
				}

				// Deleting Node with single child
				else if (current.rightChild == null) {
					if (current == root) {
						root = current.leftChild;
					} else if (isLeftChild) {
						parent.leftChild = current.leftChild;
					} else {
						parent.rightChild = current.leftChild;
					}
				} else if (current.leftChild == null) {
					if (current == root) {
						root = current.rightChild;
					} else if (isLeftChild) {

						parent.leftChild = current.rightChild;
					} else {
						parent.rightChild = current.rightChild;
					}
				}

				// Delete node with two child
				else {
					Node successor = getSuccessor(current);
					successor.leftChild = current.leftChild;
					if (current.rightChild != successor) {
						successor.rightChild = current.rightChild;
					}

					if (current == root) {
						root = successor;
					} else if (isLeftChild) {
						parent.leftChild = successor;
					} else {
						parent.rightChild = successor;
					}
				}

				break;
			} else if (data > current.data) {
				isLeftChild = false;
				parent = current;
				current = current.rightChild;
			} else {
				isLeftChild = true;
				parent = current;
				current = current.leftChild;
			}
		}

	}

	private Node getSuccessor(Node current) {
		Node successor = current.rightChild;
		Node leftChild = successor;
		Node parent = successor;
		while (leftChild != null) {
			parent = successor;
			successor = leftChild;
			leftChild = successor.leftChild;
		}
		if (successor != current.rightChild && successor.rightChild != null) {
			parent.leftChild = successor.rightChild;
		}

		return successor;
	}

	public Node find(int findNode) {
		Node found = null;
		Node current = root;

		while (current != null) {
			if (current.data == findNode) {
				found = root;
				break;
			} else if (findNode > current.data) {
				current = current.rightChild;
			} else {
				current = current.leftChild;
			}
		}

		return found;
	}

	public void inorderTraverse() {
		inorderTraversal(root);
		System.out.println();
	}

	public void postOrderTraverse() {
		postOrderTraversal(root);
		System.out.println();
	}

	private void postOrderTraversal(Node current) {
		if (current != null) {
			postOrderTraversal(current.leftChild);
			postOrderTraversal(current.rightChild);
			System.out.print(current.data + " ");
		}
	}

	public void preOrderTraverse() {
		preOrderTraversal(root);
		System.out.println();
	}

	private void preOrderTraversal(Node current) {
		if (current != null) {
			System.out.print(current.data + " ");
			preOrderTraversal(current.leftChild);
			preOrderTraversal(current.rightChild);

		}
	}

	private void inorderTraversal(Node current) {
		if (current != null) {
			inorderTraversal(current.leftChild);

			System.out.print(current.data + " ");
			inorderTraversal(current.rightChild);

		}
	}

	public void stackInorderTraverse() {
		stackInorderTraversal(root);
	}

	private void stackInorderTraversal(Node root) {
		Stack theStack = new Stack(13);
		Node current = root;
		pushLeftChildren(theStack, current);

		while (!theStack.isEmpty()) {
			current = theStack.pop();
			if (current != null) {
				System.out.print(current.data + " ");
				current = current.rightChild;
				pushLeftChildren(theStack, current);
			}
		}

	}

	public void stackPreorderTraverse() {
		stackPreorderTraversal(root);
	}

	private void stackPreorderTraversal(Node root2) {
		Stack theStack = new Stack(13);
		Node current = root;
		while (current != null) {
			System.out.print(current.data + " ");
			theStack.push(current);
			current = current.leftChild;
		}

		while (!theStack.isEmpty()) {
			current = theStack.pop();
			if (current != null) {
				current = current.rightChild;
				while (current != null) {
					System.out.print(current.data + " ");
					theStack.push(current);
					current = current.leftChild;
				}
			}
		}

	}

	public void stackPostOrderTraverse() {
		stackPostOrderTraversal(root);
	}

	private void stackPostOrderTraversal(Node root2) {
		Stack theStack = new Stack(13);
		Node root = root2;
		theStack.push(root);
		Node rightChild = null;
		while (!theStack.isEmpty()) {
			while (root != null) {

				if (root.rightChild != null) {
					theStack.push(root.rightChild);
				}
				theStack.push(root);
				root = root.leftChild;
			}

			root = theStack.pop();
			if (root.rightChild != null && !theStack.isEmpty() && root.rightChild == theStack.peek()) {
				rightChild = theStack.pop();
				theStack.push(root);
				root = rightChild;
			} else {
				System.out.print(root.data + " ");
				root = null;
			}
		}

	}

	private Node pushLeftChildren(Stack theStack, Node current) {
		while (current != null) {
			theStack.push(current);
			current = current.leftChild;
		}
		return current;
	}
}
