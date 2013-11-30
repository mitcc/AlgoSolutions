/*
 * Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate 
 * (i, ai). n vertical lines are drawn such that 
 * the two endpoints of line i is at (i, ai) and 
 * (i, 0). Find two lines, which together with 
 * x-axis forms a container, such that the 
 * container contains the most water.

Example
Given [1,3,2], the max area of the container is 2.

Note
You may not slant the container.
 */
public class ContainerWithMostWater {

    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        int result = 0;
        int low = 0; 
        int high = heights.length - 1;
        while (low < high) {
            result = Math.max(result, Math.min(heights[low], 
                        heights[high]) * (high - low));
            if (heights[low] < heights[high]) {
                low++;
            } else {
                high--;
            }
        }
        return result;
    }

}
