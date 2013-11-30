/*
 * Say you have an array for which the ith element is 
 * the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may 
complete at most k transactions.

Example
Given prices = [4,4,6,1,1,4,2,5], and k = 2, return 6.

Note
You may not engage in multiple transactions at the same 
time (i.e., you must sell the stock before you buy again).

Challenge
O(nk) time.
 */
public class BestTimeToBuyAndSellStockIV {

    /**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int k, int[] prices) {
        if (k >= prices.length / 2) {
            int result = 0;
            for (int i = 1; i < prices.length; ++i) {
                result += Math.max(0, prices[i] - prices[i - 1]);
            }
            return result;
        }
        int[] buy = new int[k];
        int[] sell = new int[k];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int i = 0; i < prices.length; ++i) {
            for (int j = k - 1; j >= 0; --j) {
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
                buy[j] = Math.max(buy[j], (j > 0 ? sell[j - 1] : 0) 
                        - prices[i]);
            }
        }
        return sell[k - 1];
    }

}
