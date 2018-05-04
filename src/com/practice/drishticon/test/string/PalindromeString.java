package com.practice.drishticon.test.string;

public class PalindromeString {

	public static void main(String args[]){
		
		String s1 = "badb";
		System.out.println(palindrome(s1));
		System.out.println(reversePalindrome(s1));
	}

	private static boolean reversePalindrome(String s1) {
		boolean isPalindrome = false;
		String reverse = "";
		for(int i=s1.length()-1;i>=0;i--){
			reverse = reverse + s1.charAt(i);
		}
		if(s1.equals(reverse)){
			isPalindrome = true;
		}
		
		return isPalindrome;
	}

	private static boolean palindrome(String s1) {
		boolean isPalindrome = true;
		char[] arr = s1.toCharArray();
		int start = 0;
		int end = s1.length()-1;
		
		while(start<end){
			if(arr[start]!=arr[end]){
				isPalindrome = false;
				break;
			}
			start++;
			end--;
		}
		
		return isPalindrome;
	}
}
