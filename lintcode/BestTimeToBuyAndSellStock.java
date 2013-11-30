/*
 * Medium Best Time to Buy and Sell Stock Show result 

41% Accepted
Say you have an array for which the ith element is the 
price of a given stock on day i.

If you were only permitted to complete at most one 
transaction (ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.

Example
Given an example [3,2,3,1,2], return 1
 */
public class BestTimeToBuyAndSellStock {

    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        int result = 0;
        int leftMin = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; ++i) {
            leftMin = Math.min(leftMin, prices[i]);
            result = Math.max(result, prices[i] - leftMin);
        }
        return result;
    }

}
