/*
 * Given an integer matrix, find the length of the longest 
 * increasing path.
 * 
 * From each cell, you can either move to four directions: 
 * left, right, up or down. You may NOT move diagonally or 
 * move outside of the boundary (i.e. wrap-around is not 
 * allowed).
 * 
 * Example 1:
 * 
 * nums = [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * Return 4
 * The longest increasing path is [1, 2, 6, 9].
 * 
 * Example 2:
 * 
 * nums = [
 *   [3,4,5],
 *   [3,2,6],
 *   [2,2,1]
 * ]
 * Return 4
 * The longest increasing path is [3, 4, 5, 6]. Moving 
 * diagonally is not allowed.
 */
public class LongestIncreasingPathInAMatrix {

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] path = new int[matrix.length][matrix[0].length];
        int result = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                result = Math.max(result, dfs(matrix, i, j, path));
            }
        }
        return result;
    }
    
    public int dfs(int[][] matrix, int i, int j, int[][] path) {
        if (path[i][j] > 0) {
            return path[i][j];
        }
        int[] v1 = {0, 0, -1, 1};
        int[] v2 = {-1, 1, 0, 0};
        for (int k = 0; k <= 3; ++k) {
            int x = i + v1[k];
            int y = j + v2[k];
            if (0 <= x && x < matrix.length && 0 <= y && 
                    y < matrix[0].length && matrix[i][j] < matrix[x][y]) {
                path[i][j] = Math.max(path[i][j], dfs(matrix, x, y, path));
            }
        }
        path[i][j]++;
        return path[i][j];
    }

}
