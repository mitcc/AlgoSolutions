/*
 * Medium Best Time to Buy and Sell Stock II

50% Accepted
Say you have an array for which the ith element is the price of a given stock 
on day i.

Design an algorithm to find the maximum profit. You may complete as many 
transactions as you like (ie, buy one and sell one share of the stock multiple 
times). However, you may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).

Example
Given an example [2,1,2,0,1], return 2
 */
public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; ++i) {
            result += Math.max(0, prices[i] - prices[i - 1]);
        }
        return result;
    }    

}
