/*
 * Given a 2D binary matrix filled with 0's 
 * and 1's, find the largest square containing 
 * all 1's and return its area.

 * For example, given the following matrix:
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 4.
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int xLen = matrix.length;
        int yLen = matrix[0].length;
        int[] height = new int[yLen];
        int result = 0;
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;    
            }
            int k = 0;
            Stack<Integer> stack = new Stack<Integer>();
            while (k < yLen || !stack.isEmpty()) {
                if (k < yLen && (stack.isEmpty() || 
                            height[k] >= height[stack.peek()])) {
                    stack.push(k++);
                } else {
                    int a = Math.min(height[stack.pop()], 
                            stack.isEmpty() ? k : k - stack.peek() - 1);
                    result = Math.max(result, a * a);
                }
            }
        }
        return result;
    }

}
