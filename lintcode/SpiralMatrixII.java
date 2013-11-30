/*
 * Given an integer n, generate a square matrix filled 
 * with elements from 1 to n^2 in spiral order.

Example
Given n = 3,

You should return the following matrix:

[
  [ 1, 2, 3 ],
  [ 8, 9, 4 ],
  [ 7, 6, 5 ]
]
 */
public class SpiralMatrixII {

    /**
     * @param n an integer
     * @return a square matrix
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0, value = 0; i < (n + 1) / 2; ++i) {
            for (int j = i; j < n - i; ++j) {
                matrix[i][j] = ++value;
            }
            for (int j = i + 1; j < n - i; ++j) {
                matrix[j][n - 1 - i] = ++value;
            }
            for (int j = n - 2 - i; j >= i; --j) {
                matrix[n - 1 - i][j] = ++value;
            }
            for (int j = n - 2 - i; j >= i + 1; --j) {
                matrix[j][i] = ++value;
            }
        }
        return matrix;
    }

}
