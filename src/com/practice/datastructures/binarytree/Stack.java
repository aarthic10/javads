package com.practice.datastructures.binarytree;

public class Stack {
	
	private int nElems;
	private Node[] nodes;
	private int top;
	
	public Stack(int max){
		top = -1;
		nodes = new Node[max];
		nElems = max;
	}
	
	public void push(Node node){
		nodes[++top] = node;		
	}
	
	public Node pop(){				
		return nodes[top--];
	}
	
	public boolean isFull(){
		return top==nElems;
	}
	
	public boolean isEmpty(){
		return top==-1;
	}
	
	public Node peek(){
		return nodes[top];
	}
	
}
