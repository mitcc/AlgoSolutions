/*
Say you have an array for which the ith element is the price of a given stock 
on day i.

Design an algorithm to find the maximum profit. You may complete at most two 
transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell
the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int[] leftProfit = new int[len];
        int[] rightProfit = new int[len];
        for (int i = 0, leftMin = Integer.MAX_VALUE, 
                rightMax = Integer.MIN_VALUE; i < len; ++i) {
            leftMin = Math.min(leftMin, prices[i]);
            rightMax = Math.max(rightMax, prices[len - 1 - i]);
            if (i == 0) {
                leftProfit[i] = 0;
                rightProfit[len - 1 - i] = 0;
            } else {
                leftProfit[i] = Math.max(leftProfit[i - 1], 
                        prices[i] - leftMin);
                rightProfit[len - 1 - i] = Math.max(rightProfit[len - i], 
                        rightMax - prices[len - 1 - i]);
            }
        }
        int result = 0;
        for (int i = 0; i < len; ++i) {
            result = Math.max(result, leftProfit[i] + rightProfit[i]);
        }
        return result;
    }

}
