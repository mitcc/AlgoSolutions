/*
 * There are n coins with different value in a line. Two players take turns to 
 * take one or two coins from left side until there are no more coins left. The 
 * player who take the coins with the most value wins.

Could you please decide the first player will win or lose?

Example
Given values array A = [1,2,2], return true.

Given A = [1,2,4], return false.
 */
public class CoinsInALineII {

    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        int[] dp = new int[5];
        int sum = 0;
        for (int i = values.length - 1; i >= 0; --i) {
            int a = i + 1 < values.length ? values[i + 1] : 0;
            int b = i + 2 < values.length ? dp[(i + 2) % 5] : 0;
            int c = i + 3 < values.length ? dp[(i + 3) % 5] : 0;
            int d = i + 4 < values.length ? dp[(i + 4) % 5] : 0;
            dp[i % 5] = values[i] + Math.max(Math.min(b, c), a + Math.min(c, d));
            sum += values[i];
        }
        return dp[0] > sum - dp[0];
    }

/*****************************************************************************/

    public boolean firstWillWin(int[] values) {
        int[] dp = new int[values.length];
        int sum = 0;
        for (int i = values.length - 1; i >= 0; --i) {
            int a = i + 1 < values.length ? values[i + 1] : 0;
            int b = i + 2 < values.length ? dp[i + 2] : 0;
            int c = i + 3 < values.length ? dp[i + 3] : 0;
            int d = i + 4 < values.length ? dp[i + 4] : 0;
            dp[i] = values[i] + Math.max(Math.min(b, c), a + Math.min(c, d));
            sum += values[i];
        }
        return dp[0] > sum - dp[0];
    }

}
