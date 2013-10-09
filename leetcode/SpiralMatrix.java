/*
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

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
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(matrix.length == 0)
            return result;
        int M = matrix.length, N = matrix[0].length;     
        int small = M < N ? M : N;
        for(int i = 0; i < (small + 1) / 2; i++) {
            for(int j  = i; j < N - i; j++) {
                result.add(matrix[i][j]);
            }
            for(int j = i + 1; j < M - i; j++) {
                result.add(matrix[j][N - 1 - i]);
            }
            for(int j = N - 2 - i; j > i && i != M - 1 - i; j--) {
                result.add(matrix[M - 1 - i][j]);
            }
            for(int j = M - 1 - i; j > i && i != N - 1 - i; j--) {
                result.add(matrix[j][i]);
            }
        }
        return result;
    }
}
