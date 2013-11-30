/*
 * Given a m x n grid filled with non-negative numbers, find a path from top 
 * left to bottom right which minimizes the sum of all numbers along its path.

 * Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int xLen = grid.length;
        int yLen = grid[0].length;
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (i == 0 && j > 0)
                    grid[i][j] += grid[i][j - 1];
                else if (i > 0 && j == 0) 
                    grid[i][j] += grid[i - 1][j];
                else if (i > 0 && j > 0)
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[xLen - 1][yLen - 1];
    }

}
