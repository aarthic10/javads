package com.practice.drishticon.test.string;

public class ReverseString {

	public static void main(String[] args) {
		String s1 = "Groupo";
		System.out.println(reverse(s1.toCharArray()));
		System.out.println(reverseString(s1));
		char[] charArray = s1.toCharArray();
		System.out.println("recursion "+reverseRecursion(charArray, -1, charArray.length));
	}

	private static String reverseString(String s1) {
		String reverse = "";
		
		for(int i=s1.length()-1;i>=0;i--){
			reverse = reverse + s1.charAt(i);
		}
		return reverse;
	}

	private static String reverse(char[] charArray) {
		String reverse = "";
		int start = 0;
		int end = charArray.length-1;
		char temp;
		while(start<end){
			temp = charArray[start];
			charArray[start] = charArray[end];
			charArray[end] = temp;
			
			start++;
			end--;
		}
		
		reverse = String.copyValueOf(charArray) ;
		return reverse;
		
	}
	
	
	private static String reverseRecursion(char[] charArray, int start, int end){
		char temp;
		if(start>=end){
			return "";
		}
		reverseRecursion(charArray, ++start,--end);
		temp = charArray[start];
		charArray[start] = charArray[end];
		charArray[end] = temp;
		return String.copyValueOf(charArray);
	}

}
