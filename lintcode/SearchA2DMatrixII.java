/*
 * Write an efficient algorithm that searches for a value 
 * in an m x n matrix, return the occurrence of it.

This matrix has the following properties:

Integers in each row are sorted from left to right.
Integers in each column are sorted from up to bottom.
No duplicate integers in each row or column.
Example
Consider the following matrix:

[
  [1, 3, 5, 7],
  [2, 4, 7, 8],
  [3, 5, 9, 10]
]
Given target = 3, return 2.

Challenge
O(m+n) time and O(1) extra space
 */
public class SearchA2DMatrixII {

    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return 0;
        }
        int count = 0;
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                count++;
                i++;
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return count;
    }

/*****************************************************************************/

    //TODO
    pubilc int searchMatrix(int[][] matrix, int target) {

    }

    public int binarySearch(int[] matrix, int row1, int row2, int col1, int col2) {
        
    }

}
