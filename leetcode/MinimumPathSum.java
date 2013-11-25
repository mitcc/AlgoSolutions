/*
 * Given a m x n grid filled with non-negative numbers, find a path from top left to 
 * bottom right which minimizes the sum of all numbers along its path.

 * Note: You can only move either down or right at any point in time.
 * 
 */
public class MinimumPathSum {
/****************************** updated 2013/11/25 ****************************/
    public int minPathSum(int[][] grid) {
        int xLen = grid.length, yLen = grid[0].length;
        int[][] dp = new int[xLen][yLen];
        for(int i = 0; i < xLen; i++) 
            for(int j = 0; j < yLen; j++) {
                dp[i][j] = grid[i][j];
                if(i == 0 && j != 0)
                    dp[i][j] += dp[i][j - 1];
                if(i != 0 && j == 0)
                    dp[i][j] += dp[i - 1][j];
                if(i != 0 && j != 0)
                    dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]);
            }        
        return dp[xLen - 1][yLen - 1];
    }
}
