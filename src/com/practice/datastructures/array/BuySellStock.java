package com.practice.datastructures.array;

public class BuySellStock {

	public static void main(String[] args) {
		int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
		System.out.println("Total Profits "+allProfits(prices));
		System.out.println("Max Profit "+maxProfit(prices));
	}

	// Find all the profits. Buy 1 and sell 5. Again buy 3 and sell 6
	public static int allProfits(int[] prices) {

		if (prices == null || prices.length == 0) {
			return 0;
		}

		int result = 0;
		int min = prices[0];
		int totalResult = 0;

		for (int i = 0; i < prices.length; i++) {
			if (min > prices[i]) {
				min = prices[i];

			}
			result = prices[i] - min;
			if (result > 0) {
				totalResult += result;
				min = prices[i]; //reset the min to buy again
			}

		}

		return totalResult;

	}

	// Find max profit

	public static int maxProfit(int[] prices) {

		if (prices == null || prices.length == 0) {
			return 0;
		}

		int result = 0;
		int min = prices[0];

		for (int i = 0; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			result = Math.max(result, prices[i]-min);

		}

		return result;

	}
}
