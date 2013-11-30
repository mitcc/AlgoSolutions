/*
Write an efficient algorithm that searches for a value in an m x n matrix. This
matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
 */
public class SearchA2DMatrixII {

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

/*****************************************************************************/

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        return binarySearch(matrix, target, 0, matrix.length - 1, 0, 
                matrix[0].length - 1);
    }

    public boolean binarySearch(int[][] matrix, int target, int rowLow, 
            int rowHigh, int colLow, int colHigh) {
        if (rowLow > rowHigh || colLow > colHigh) {
            return false;
        }
        int row = rowLow + (rowHigh - rowLow) / 2;
        int start = colLow;
        int end = colHigh;
        int mid = start + (end - start) / 2;
        while (colLow <= mid && mid <= colHigh) {
            if (matrix[row][mid] == target) {
                return true;
            }
            if (colLow <= mid && mid < colHigh && matrix[row][mid] < target 
                    && target < matrix[row][mid + 1]) {
                break;
            } else {
                if (matrix[row][mid] < target) {
                    start = mid + 1;
                    if (start > colHigh) {
                        mid = colHigh;
                        break;
                    }
                } else {
                    end = mid - 1;
                    if (end < colLow) {
                        mid = colLow;
                        break;
                    }
                }
            }
            mid = start + (end - start) / 2;
        }
        return binarySearch(matrix, target, row + 1, rowHigh, colLow, mid) 
            || binarySearch(matrix, target, rowLow, row - 1, mid, colHigh);
    }

}
