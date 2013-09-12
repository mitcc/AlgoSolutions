/*
 * Given n non-negative integers representing the histogram's bar height where the 
 * width of each bar is 1, find the area of largest rectangle in the histogram.

 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

 * The largest rectangle is shown in the shaded area, which has area = 10 unit.

 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {// brute force, can not pass the Jadge Large.
        int area = 0;
        for(int i = 0; i < height.length; i++) {
            int min = height[i];
            for(int j = i; j < height.length; j++) {
                min = Math.min(min, height[j]);
                area = Math.max(area, min * (j - i + 1));
            }
        }
        return area;
    }
}
