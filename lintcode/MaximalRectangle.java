/*
 * Given a 2D boolean matrix filled with False and True, find the 
 * largest rectangle containing all True and return its area.

Example
Given a matrix:

[
  [1, 1, 0, 0, 1],
  [0, 1, 0, 0, 1],
  [0, 0, 1, 1, 1],
  [0, 0, 1, 1, 1],
  [0, 0, 0, 0, 1]
]
return 6.
 */
public class MaximalRectangle {

    /**
     * @param matrix a boolean 2D matrix
     * @return an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int result = 0;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                height[j] = matrix[i][j] ? (height[j] + 1) : 0;
            }
            result = Math.max(result, largestRectangleArea(height));
        }
        return result;
    }

    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int i = 0;
        while (i < height.length || !stack.isEmpty()) {
            if (i < height.length && (stack.isEmpty() || 
                    height[i] >= height[stack.peek()])) {
                stack.push(i++);
            } else {
                result = Math.max(result, height[stack.pop()] * 
                    (stack.isEmpty() ? i : (i - stack.peek() - 1)));
            }
        }
        return result;
    }

}
