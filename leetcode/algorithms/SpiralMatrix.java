/*
 * Given a matrix of m x n elements (m rows, n columns), 
 * return all elements of the matrix in spiral order.

 * For example,
 * Given the following matrix:

 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int xLen = matrix.length;
        if (xLen == 0)
            return result;
        int yLen = matrix[0].length;
        for (int i = 0; i < (Math.min(xLen, yLen) + 1) / 2; i++) {
            for (int j = i; j < yLen - i; j++)
                result.add(matrix[i][j]);
            for (int j = i + 1; j < xLen - 1 - i; j++)
                result.add(matrix[j][yLen - 1 - i]);
            for (int j = yLen - 1 - i; j >= i && i != xLen - 1 - i; j--)
                result.add(matrix[xLen - 1 - i][j]);
            for (int j = xLen - 2 - i; j > i && i != yLen - 1 - i; j--)
                result.add(matrix[j][i]);
        }
        return result;
    }

}
