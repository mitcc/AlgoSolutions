/*
 * Given a m x n matrix, if an element is 0, set 
 * its entire row and column to 0. Do it in place.

Example
Given a matrix

[
  [1,2],
  [0,3]
],
return
[
[0,2],
[0,0]
]

Challenge
Did you use extra space?
A straight forward solution using O(mn) space is 
probably a bad idea.
A simple improvement uses O(m + n) space, but 
still not the best solution.
Could you devise a constant space solution?
 */
public class SetMatrixZeroes {

    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        boolean isRowZeros = false;
        boolean isColZeros = false;
        for (int i = 0; i < matrix.length; ++i) {
            if (matrix[i][0] == 0) {
                isColZeros = true;
                break;
            }
        }
        for (int j = 0; j < matrix[0].length; ++j) {
            if (matrix[0][j] == 0) {
                isRowZeros = true;
                break;
            }
        }
        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; ++i) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; ++j) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < matrix[0].length; ++j) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < matrix.length; ++i) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; isRowZeros && j < matrix[0].length; ++j) {
            matrix[0][j] = 0;
        }
        for (int i = 0; isColZeros && i < matrix.length; ++i) {
            matrix[i][0] = 0;
        }
    }

/*******************************************************************/

    public void setZeroes(int[][] matrix) {
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    queue.offer(i * matrix[0].length + j);
                }
            }
        }
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int x = index / matrix[0].length;
            int y = index % matrix[0].length;
            for (int i = 0; i < matrix.length; ++i) {
                matrix[i][y] = 0;
            }
            for (int j = 0; j < matrix[0].length; ++j) {
                matrix[x][j] = 0;
            }
        }
    }

}
