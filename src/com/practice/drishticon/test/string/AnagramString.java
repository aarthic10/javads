package com.practice.drishticon.test.string;

public class AnagramString {
	public static void main(String args[]) {
		String s1 = "tea";
		String s2 = "ate";
		//System.out.println(anagram(s1, s2));
		isAnagram(s1, s2);
	}

	private static boolean anagram(String s1, String s2) {
		boolean isAnagram = false;

		if (s1.length() != s2.length()) {
			return false;
		}

		char arr[] = s1.toCharArray();
		char arr2[] = s2.toCharArray();

		for (char ch : arr) {
			isAnagram = false;
			for (char ch2 : arr2) {
				if (ch == ch2) {
					isAnagram = true;
					break;
				}
			}

			if (!isAnagram) {
				break;
			}
		}

		return isAnagram;
	}

	public static boolean isAnagram(String word, String anagram) {
		if (word.length() != anagram.length()) {
			return false;
		}
		char[] chars = word.toCharArray();
		for (char c : chars) {
			int index = anagram.indexOf(c);
			if (index != -1) {
				anagram = anagram.substring(0, index) + anagram.substring(index + 1, anagram.length());
			} else {
				return false;
			}
		}
		return anagram.isEmpty();
	}

}
