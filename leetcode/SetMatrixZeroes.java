/*
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

 * click to show follow up.

 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
public class SetMatrixZeroes {
/*  public void setZeroes(int[][] matrix) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    queue.offer(i * n + j);
                }
            }
        }
        while(!queue.isEmpty()) {
            int val = queue.poll();
            int row = val / n;
            int col = val % n;
            for(int i = 0; i < m; i++) {
                matrix[i][col] = 0;
            } 
            for(int j = 0; j < n; j++) {
                matrix[row][j] = 0;
            }
        }
    }
*/
    
    public void setZeroes(int[][] matrix) {
        boolean isRowZero = false;
        boolean isColZero = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) {
                isColZero = true;
                break;
            }
        }
        for(int j = 0; j < n; j++) {
            if(matrix[0][j] == 0) {
                isRowZero = true;
                break;
            }
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < m; i++) {
            if(matrix[i][0] == 0) {
                for(int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 0; j < n; j++) {
            if(matrix[0][j] == 0) {
                for(int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(isRowZero) {
            for(int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if(isColZero) {
            for(int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
