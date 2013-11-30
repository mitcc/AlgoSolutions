/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:

 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the 
 * previous row.
 *
 * For example,

 * Consider the following matrix:
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 */
public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int yLen = matrix[0].length;
        int i = 0; 
        int j = matrix.length * yLen;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (matrix[mid / yLen][mid % yLen] == target)
                return true;
            else if (matrix[mid / yLen][mid % yLen] < target)
                i = mid + 1;
            else 
                j = mid;
        }
        return false;
    }

/*************************************************************/

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] < target) 
                i++;
            else
                j--;
        }
        return false;
    }
}
