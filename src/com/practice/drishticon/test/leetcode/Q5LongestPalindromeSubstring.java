package com.practice.drishticon.test.leetcode;

public class Q5LongestPalindromeSubstring {
	
	public static void main(String args[]) {
		String s = "cabad";
		String palindrome = "";
		int length = 0;
		int increment = 0;
		
		for(int i = 1; i < s.length()-2; i++) {
			increment++;
			if(s.charAt(i+increment) == s.charAt(i-increment)) {
				int newLength = (i+increment) - (i-increment);
				if(newLength >= length) {
					length = newLength;
					palindrome = s.substring(i-increment, i+increment+1);
				}
				
			}
			
		}
		System.out.println(palindrome);
	}

}
