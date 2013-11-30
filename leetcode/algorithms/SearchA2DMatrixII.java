/*
 * Write an efficient algorithm that searches for a value in an m x n 
 * matrix. This matrix has the following properties:

 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * For example,
 * 
 * Consider the following matrix:
 * 
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * 
 * Given target = 20, return false.
 */
public class SearchA2DMatrixII {

    // O(m + n)
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (0 <= i && j < matrix[0].length && matrix[i][j] != target) {
            if (matrix[i][j] < target)
                j++;
            else
                i--;
        }
        return 0 <= i && j < matrix[0].length && matrix[i][j] == target;
    }

/*****************************************************************************/

    public boolean searchMatrix(int[][] matrix, int target) {
        return binarySearch(matrix, target, 0, matrix.length - 1, 0, 
                matrix[0].length - 1);
    }

    public boolean binarySearch(int[][] matrix, int target, int rowLow, 
            int rowHigh, int colLow, int colHigh) {
        if (rowLow > rowHigh || colLow > colHigh)
            return false;
        int row = rowLow + (rowHigh - rowLow) / 2;
        int start = colLow;
        int end = colHigh;
        int mid = start + (end - start) / 2;
        while (colLow <= mid && mid <= colHigh) {
            if (colLow <= mid && mid < colHigh && matrix[row][mid] < target 
                    && target < matrix[row][mid + 1])
                break;
            else if (matrix[row][mid] == target)
                return true;
            else if (matrix[row][mid] < target) {
                start = mid + 1;
                if (start > colHigh) {
                    mid = start;
                    break;
                }
            } else {
                end = mid - 1;
                if (end < colLow) {
                    mid = end;
                    break;
                }
            }
            mid = start + (end - start) / 2;
        }
        return binarySearch(matrix, target, row + 1, rowHigh, colLow, 
                Math.min(mid, colHigh)) || binarySearch(matrix, target, 
                rowLow, row - 1, mid + 1, colHigh);
    }

}
