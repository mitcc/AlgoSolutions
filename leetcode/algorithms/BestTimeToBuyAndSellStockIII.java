/*
 * Say you have an array for which the ith element is the 
 * price of a given stock on day i.

 * Design an algorithm to find the maximum profit. You may 
 * complete at most two transactions.

 * Note:
 * You may not engage in multiple transactions at the same 
 * time (ie, you must sell the stock before you buy again). 
 */

public class BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int len = prices.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        int min = prices[0];
        int max = prices[len - 1];
        for (int i = 1; i < len; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[len - 1 - i]);
            leftMax[i] = Math.max(leftMax[i - 1], prices[i] - min);
            rightMax[len - 1 - i] = Math.max(rightMax[len - i], 
                    max - prices[len - 1 - i]);
        }
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            result = Math.max(result, leftMax[i] + rightMax[i]);
        }
        return result;
    }    

/*****************************************************************************/

    public int maxProfit(int[] prices) {
        int x = 0;
        int xx = 0;
        int y = Integer.MIN_VALUE;
        int yy = Integer.MIN_VALUE;
        for (int price : prices) {
            y = Math.max(y, -price);       
            x = Math.max(x, y + price);  
            yy = Math.max(yy, x - price);  
            xx = Math.max(xx, yy + price); 
        }
        return xx;
    }

}
