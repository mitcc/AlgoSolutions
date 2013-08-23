/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

 * If you were only permitted to complete at most one transaction (ie, buy one and sell one 
 * share of the stock), design an algorithm to find the maximum profit.
 */
package info.mitcc.leetcode;

public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		int maxDiff = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 1; i < prices.length; i++) {
			min = Math.min(Math.min(min, prices[i - 1]), prices[i]);
			maxDiff = Math.max(maxDiff, prices[i] - min);
		}
		return maxDiff;
	}
}
