/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. 
Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int col0 = 1;
        for (int i = 0; i < rowLen; ++i) {
            if (matrix[i][0] == 0) {
                col0 = 0;
            }
            for (int j = 1; j < colLen; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = rowLen - 1; i >= 0; --i) {
            for (int j = colLen - 1; j >= 1; --j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0) {
                matrix[i][0] = 0;
            }
        }
    }

/*****************************************************************************/

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int xLen = matrix.length;
        int yLen = matrix[0].length;
        boolean isRowZeroes = false;
        boolean isColzeroes = false;
        for (int i = 0; i < yLen && !isRowZeroes; ++i) {
            if (matrix[0][i] == 0) {
                isRowZeroes = true;
            }
        }
        for (int i = 0; i < xLen && !isColzeroes; ++i) {
            if (matrix[i][0] == 0) {
                isColzeroes = true;
            }
        }
        for (int i = 1; i < xLen; ++i) {
            for (int j = 1; j < yLen; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < xLen; ++i) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < yLen; ++j) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < yLen; ++i) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < xLen; ++j) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (isRowZeroes) {
            for (int i = 0; i < yLen; ++i) {
                matrix[0][i] = 0;
            }
        }
        if (isColzeroes) {
            for (int i = 0; i < xLen; ++i) {
                matrix[i][0] = 0;
            }
        }
    }

/*****************************************************************************/

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int xLen = matrix.length;
        int yLen = matrix[0].length;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < xLen; ++i) {
            for (int j = 0; j < yLen; ++j) {
                if (matrix[i][j] == 0) {
                    queue.offer(i * yLen + j);
                }
            }
        }
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int rowIndex = index / yLen;
            int colIndex = index % yLen;
            for (int i = 0; i < yLen; ++i) {
                matrix[rowIndex][i] = 0;
            }
            for (int i = 0; i < xLen; ++i) {
                matrix[i][colIndex] = 0;
            }
        }
    }

/*****************************************************************************/

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int xLen = matrix.length;
        int yLen = matrix[0].length;
        int[] rows = new int[xLen];
        int[] cols = new int[yLen];
        for (int i = 0; i < xLen; ++i) {
            for (int j = 0; j < yLen; ++j) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        for (int i = 0; i < rows.length; ++i) {
            if (rows[i] == 1) {
                for (int j = 0; j < yLen; ++j) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < cols.length; ++i) {
            if (cols[i] == 1) {
                for (int j = 0; j < xLen; ++j) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

}
