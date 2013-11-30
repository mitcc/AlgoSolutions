/*
 * Say you have an array for which the ith element 
 * is the price of a given stock on day i.

 * Design an algorithm to find the maximum profit. 
 * You may complete at most k transactions.

 * Note:
 * You may not engage in multiple transactions at 
 * the same time (ie, you must sell the stock 
 * before you buy again).
 */
public class BestTimeToBuyAndSellStockIV {

    public int maxProfit(int k, int[] prices) {
        if (k >= prices.length / 2) {
            int result = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1])
                    result += prices[i] - prices[i - 1];
            }
            return result;
        }
        int[][] dp = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
            int tmpMax = -prices[0];
            for (int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tmpMax);
                tmpMax = Math.max(tmpMax, dp[i - 1][j - 1] - prices[j]);
            }
        }
        return dp[k][prices.length - 1];
    }

/*****************************************************************************/

    public int maxProfit(int k, int[] prices) {
        if (k >= prices.length / 2) {
            int result = 0;
            for (int i = 1; i < prices.length; ++i) {
                result += Math.max(0, prices[i] - prices[i - 1]);
            }
            return result;
        }   
        int[] global = new int[k + 1];
        int[] local = new int[k + 1];
        for (int i = 1; i < prices.length; ++i) {
            int delta = prices[i] - prices[i - 1];
            for (int j = k; j >= 1; --j) {
                local[j] = Math.max(global[j - 1] + Math.max(0, delta), 
                        local[j] + delta);
                global[j] = Math.max(global[j], local[j]);
            }
        }
        return global[k];
    }       

}
