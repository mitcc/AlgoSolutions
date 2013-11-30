/*
Write an efficient algorithm that searches for a value in an m x n matrix. This 
matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous 
row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
 */
public class SearchA2DMatrix {

    // O(lg(m * n))
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int xLen = matrix.length;
        int yLen = matrix[0].length;
        int i = 0;
        int j = xLen * yLen;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (matrix[mid / yLen][mid % yLen] == target) {
                return true;
            } else if (matrix[mid / yLen][mid % yLen] < target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return false;
    }
    
/*****************************************************************************/

    // O(m + n)
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
    
}

