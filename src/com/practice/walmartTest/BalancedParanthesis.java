package com.practice.walmartTest;

import java.util.HashMap;
import java.util.Map;

import com.practice.datastructures.binarytree.Stack;

public class BalancedParanthesis {
	
	static Map<Character, Character> pairs =  Map.of('{','}','[',']','(',')');

	public static void main(String args[]) {
		
		
		
		
		char exp[] = {'{','(',')','}','[',']',']'};
		if(isBalanced(exp)) {
			System.out.println("Balanced");
		}else {
			System.out.println("Not Balanced");
		}
	}
	
	private static boolean isBalanced(char[] exp) {
		java.util.Stack<Character> st = new java.util.Stack();
		
		for(char elem : exp) {
			
			if(elem == '{' || elem =='(' || elem == '[') {
				st.push(elem);
			}else {
				if(st.isEmpty()) {
					return false;
				}
				boolean match = isMatching(elem, st.pop());
				if(!match) {
					return false;
				}
			}
			
		}
		
		if(!st.empty()) {
			return false;
		}
		
		return true;		
	}
	
	public static boolean isMatching(char elem, char stackElem) {
		char value = pairs.get(stackElem);
		if(elem == value) {
			return true;
		}
		
		return false;
	}
}
