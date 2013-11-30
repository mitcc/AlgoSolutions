/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 
in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        for (int i = 0, value = 1;i < (n + 1) / 2; ++i) {
            for (int col = i; col < n - i; ++col) {
                result[i][col] = value++;
            }
            for (int row = i + 1; row < n - i; ++row) {
                result[row][n - 1 - i] = value++;
            }
            for (int col = n - 2 - i; col >= i; --col) {
                result[n - 1 - i][col] = value++;
            }
            for (int row = n - 2 - i; row > i; --row) {
                result[row][i] = value++;
            }
        }
        return result;
    }

}
