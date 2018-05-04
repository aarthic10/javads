package com.practice.drishticon.test.geek4geeks;

public class Palindrome {

	public static void main(String[] args) {
		int numOfStrings = Integer.parseInt(args[0]);
		String[] strings = new String[numOfStrings];
		
		for(int i = 1; i <= numOfStrings; i++){
			strings[i-1] = args[i];
		}

		for(String value : strings){
			int start = 0;
			int end = value.length() - 1;
			char[] stringChars = value.toCharArray();
			boolean isPalindrome = false;
			while(start < end){
				if(!Character.isLetterOrDigit(stringChars[start])){
					start ++;
				} else if(!Character.isLetterOrDigit(stringChars[end])){
					end --;
				} else if(Character.toUpperCase(stringChars[start]) == Character.toUpperCase(stringChars[end])) {
					isPalindrome = true;
					start ++;
					end --;
				} else{
					isPalindrome = false;
					break;
				}
			}
			
			if(isPalindrome){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
		
	}

}
