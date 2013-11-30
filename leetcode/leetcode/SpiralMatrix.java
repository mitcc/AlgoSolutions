/*
Given a matrix of m x n elements (m rows, n columns), return all elements of 
the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int xLen = matrix.length;
        int yLen = matrix[0].length;
        for (int i = 0; i < (Math.min(xLen, yLen) + 1) / 2; ++i) {
            for (int col = i; col < yLen - i; ++col) {
                result.add(matrix[i][col]);
            }
            for (int row = i + 1; row < xLen - i; ++row) {
                result.add(matrix[row][yLen - 1 - i]);
            }
            for (int col = yLen - 2 - i; i < xLen - 1 - i && col >= i; --col) {
                result.add(matrix[xLen - 1 - i][col]);
            }
            for (int row = xLen - 2 - i; i < yLen - 1 - i && row > i; --row) {
                result.add(matrix[row][i]);
            }
        }
        return result;
    }

}
