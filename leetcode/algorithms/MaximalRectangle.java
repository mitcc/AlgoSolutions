/*
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle 
 * containing all ones and return its area.
 */

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int[] height = new int[colLen];
        int maxArea = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                height[j] = matrix[i][j] == '0' ? 0 : (height[j] + 1);
            }
            int k = 0;
            Stack<Integer> stack = new Stack<Integer>();
            while (k < colLen || !stack.isEmpty()) {
                if (k < colLen && (stack.isEmpty() || 
                            height[k] >= height[stack.peek()]))
                    stack.push(k++);
                else
                    maxArea = Math.max(maxArea, height[stack.pop()] * 
                            (stack.isEmpty() ? k : k - stack.peek() - 1));
            }
        }
        return maxArea;
    }

}
