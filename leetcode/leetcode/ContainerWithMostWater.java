/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at
coordinate (i, ai). n vertical lines are drawn such that the two endpoints of 
line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis 
forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int result = 0;
        int low = 0;
        int high = height.length - 1;
        while (low < high) {
            int area = (high - low) * Math.min(height[low], height[high]);
            result = Math.max(result, area);
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return result;
    }

}
