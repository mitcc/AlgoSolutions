/*
Given n non-negative integers representing an elevation map where the width of 
each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In 
this case, 6 units of rain water (blue section) are being trapped. Thanks 
Marcos for contributing this image!
 */
public class TrappingRainWater {

    // O(n) time, O(1) space.
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int start = 0;
        int end = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;
        while (start <= end) {
            if (leftMax < rightMax) {
                result += Math.max(leftMax - height[start], 0);
                leftMax = Math.max(leftMax, height[start++]);
            } else {
                result += Math.max(rightMax - height[end], 0);
                rightMax = Math.max(rightMax, height[end--]);
            }
        }
        return result;
    }

/*****************************************************************************/

    // O(n) time, O(1) space.
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int start = 0;
        int end = height.length - 1;
        int result = 0;
        while (start < end) {
            if (height[start] < height[end]) {
                int k = start + 1;
                while (k <= end && height[k] <= height[start]) {
                    result += height[start] - height[k++];
                }
                start = k;
            } else {
                int k = end - 1;
                while (k >= start && height[k] <= height[end]) {
                    result += height[end] - height[k--];
                }
                end = k;
            }
        }
        return result;
    }

/*****************************************************************************/

    // O(n) time, O(n) space.
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = height[0];
        rightMax[len - 1] = height[len - 1];
        for (int i = 1; i < len; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            rightMax[len - 1 - i] = Math.max(rightMax[len - i], 
                    height[len - 1 - i]);
        }
        int result = 0;
        for (int i = 1; i < len - 1; ++i) {
            result += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return result;
    }

}
