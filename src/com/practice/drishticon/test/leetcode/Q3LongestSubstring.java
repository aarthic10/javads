package com.practice.drishticon.test.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q3LongestSubstring {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		

	}
	
	 public static int lengthOfLongestSubstring(String s) {
		 int i=0;
		 int j=0;
		 int ans = 0;
		 
		 Set<Character> values = new HashSet<Character>();
		 
		 while(i < s.length() && j < s.length()){
			 
			 if(!values.contains(s.charAt(j))){
				values.add(s.charAt(j++));
				ans = Math.max(ans, j-i);
				
			 }else{
				 values.remove(s.charAt(i++));
			 }
		 }
		 
		 return ans;
	 }

}
