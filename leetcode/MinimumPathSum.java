/*
 * Given a m x n grid filled with non-negative numbers, find a path from top left to 
 * bottom right which minimizes the sum of all numbers along its path.

 * Note: You can only move either down or right at any point in time.
 * 
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int xLen = grid.length;
        int yLen = grid[0].length;
        int[][] dp = new int[xLen][yLen];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < yLen; i++)
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        for(int i = 1; i < xLen; i++)
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        for(int i = 1; i < xLen; i++) {
            for(int j = 1; j < yLen; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[xLen - 1][yLen - 1];
    }
}
