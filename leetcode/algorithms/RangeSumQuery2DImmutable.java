/*
 * Given a 2D matrix matrix, find the sum of the elements 
 * inside the rectangle defined by (row1, col1), (row2, col2).

 * Example:
 * Given matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 * 
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * Note:
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ¡Ü row2 and col1 ¡Ü col2.
 */
public class RangeSumQuery2DImmutable {

}

class NumMatrix {

    int[][] dp;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                dp[i + 1][j + 1] = dp[i + 1][j] 
                    + dp[i][j + 1] - dp[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] 
            - dp[row2 + 1][col1] + dp[row1][col1];
    }

}

// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
