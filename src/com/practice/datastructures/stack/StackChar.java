package com.practice.datastructures.stack;

public class StackChar {
	private int top;
	private char[] arr;

	public StackChar (int max) {
		arr = new char[max];
		top = -1;
	}

	public void push(char value) {
		arr[++top] = value;
	}

	public char peek() {
		return arr[top];
	}

	public char pop() {
		return arr[top--];
	}

	public boolean isEmpty() {
		return top == -1 ? true : false;
	}
}
