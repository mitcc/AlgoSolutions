/*
 * Given n non-negative integers representing the histogram's bar 
 * height where the width of each bar is 1, find the area of largest 
 * rectangle in the histogram.

histogram

Above is a histogram where width of each bar is 1, given height = 
[2,1,5,6,2,3].

histogram

The largest rectangle is shown in the shaded area, which has 
area = 10 unit.

Example
Given height = [2,1,5,6,2,3],
return 10.
 */
public class LargestRectangleInHistogram {

    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int result = Integer.MIN_VALUE;
        int i = 0;
        while (i < height.length || !stack.isEmpty()) {
            if (i < height.length && (stack.isEmpty() || 
                        height[stack.peek()] <= height[i])) {
                stack.push(i++);
            } else {
                result = Math.max(result, height[stack.pop()] * 
                        (stack.isEmpty() ? i : i - 1 - stack.peek()));
            }
        }
        return result;
    }

}
