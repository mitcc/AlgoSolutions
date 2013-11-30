/*
 * Given n items with size Ai and value Vi, and a backpack with size m. What's 
 * the maximum value can you put into the backpack?

Example
Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack 
with size 10. The maximum value is 9.

Note
You cannot divide item into small pieces and the total size of items you choose
should smaller or equal to m.

Challenge
O(n x m) memory is acceptable, can you do it in O(m) memory?
 */
public class BackpackII {

    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        int[][] dp = new int[A.length + 1][m + 1];
        for (int i = 1; i <= A.length; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (j < A[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i- 1][j], 
                            dp[i - 1][j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        return dp[A.length][m];
    }

/*****************************************************************************/

    public int backPackII(int m, int[] A, int V[]) {
        int[] dp = new int[m + 1];
        for (int i = 1; i <= A.length; ++i) {
            for (int j = m; j >= 1; --j) {
                if (j >= A[i - 1]) {
                    dp[j] = Math.max(dp[j], dp[j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        return dp[m];
    }

}
