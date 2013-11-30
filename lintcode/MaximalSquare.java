/*
 * Given a 2D binary matrix filled with 0's and 1's, find 
 * the largest square containing all 1's and return its 
 * area.

Example
For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
 */
public class MaximalSquare {

    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    // O(n * m) time, O(m) space.
    public int maxSquare(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int result = 0;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                height[j] = matrix[i][j] == 0 ? 0 : height[j] + 1;
            }
            result = Math.max(result, maxSquareArea(height));
        }
        return result;
    }

    public int maxSquareArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int i = 0;
        while (i < height.length || !stack.isEmpty()) {
            if (i < height.length && (stack.isEmpty() || 
                        height[stack.peek()] <= height[i])) {
                stack.push(i++);
            } else {
                int a = height[stack.pop()];
                int b = i - (stack.isEmpty() ? 0 : stack.peek() + 1);
                result = Math.max(result, (int) Math.pow(Math.min(a, b), 2));
            }
        }
        return result;
    }

/*****************************************************************************/

    // O(n * m) time, O(n * m) space.
    public int maxSquare(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int maxSize = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    dp[i][j] = matrix[i][j] == 0 ? 0 : Math.min(dp[i - 1][j - 1], 
                            Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
                maxSize = Math.max(maxSize, dp[i][j]);
            }
        }
        return maxSize * maxSize;
    }

    
/*****************************************************************************/

    // O(n * m) time, O(m) space.
    public int maxSquare(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[][] dp = new int[2][matrix[0].length];
        int maxSize = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (i == 0 || j == 0) {
                    dp[i % 2][j] = matrix[i][j];
                } else {
                    dp[i % 2][j] = matrix[i][j] == 0 ? 0 : 
                        Math.min(dp[(i - 1) % 2][j - 1], 
                        Math.min(dp[i % 2][j - 1], dp[(i - 1) % 2][j])) + 1;
                }
                maxSize = Math.max(maxSize, dp[i % 2][j]);
            }
        }
        return maxSize * maxSize;
    }


}
