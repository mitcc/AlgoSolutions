/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in 
the diagram below).

The robot can only move either down or right at any point in time. The robot is 
trying to reach the bottom-right corner of the grid (marked 'Finish' in the 
diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.
 */
public class UniquePaths {

    // O(m * n) time, O(1) space using formula.
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        if (m > n) {
            int tmp = m;
            m = n;
            n = tmp;
        }
        return (int) combination(m - 1, m + n - 2);
    }

    public long combination(int m, int n) {
        if (m > n) {
            throw new IllegalArgumentException("m is larger than n.");
        }
        long result = 1;
        for (int i = 1; i <= m; ++i) {
            result = result * (n + 1 - i) / i;
        }
        return result;
    }

/*****************************************************************************/

    // O(m * n) time, O(n) space.
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

}
