package com.practice.walmartTest;

public class BlackJack {

	public static int blackJack(int a, int b) {
		int result = -1;
		int blackJackValue = 21;

		if (a > blackJackValue && b > blackJackValue) {
			result = 0;
		} else if (a == blackJackValue || b == blackJackValue) {
			result = blackJackValue;
		} else if (a < blackJackValue && b < blackJackValue) {
			result = a > b ? a : b;
		} else {
			result = a < b ? a : b;
		}

		return result;
	}

	public static void main(String args[]) {
		System.out.println(blackJack(15, 22));
	}

}
