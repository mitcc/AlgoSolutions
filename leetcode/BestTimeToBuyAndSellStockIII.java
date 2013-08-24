/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

 * Design an algorithm to find the maximum profit. You may complete at most two transactions.

 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again). 
 */
package info.mitcc.leetcode;

public class BestTimeToBuyAndSellStockIII {
	public int maxProfit(int[] prices) {
		if(prices.length == 0)
			return 0;
		int[] leftMax = new int[prices.length];
		int[] rightMax = new int[prices.length];
		
		int min = prices[0];
		leftMax[0] = 0;
		for(int i = 1; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			leftMax[i] = Math.max(leftMax[i - 1], prices[i] - min);
		}
		
		int max = prices[prices.length - 1];
		rightMax[prices.length - 1] = 0;
		for(int i = prices.length - 2; i >= 0; i--) {
			max = Math.max(max, prices[i]);
			rightMax[i] = Math.max(rightMax[i + 1], max - prices[i]);
		}
		
		int result = 0;
		for(int i = 0; i < prices.length; i++) {
			result = Math.max(result, leftMax[i] + rightMax[i]);
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] test = {1, 2, 0, 1};
		System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(test));
	}
}
