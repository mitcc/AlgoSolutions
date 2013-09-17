/*
 * Given n non-negative integers representing an elevation map where the width 
 * of each bar is 1, compute how much water it is able to trap after raining.

 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TrappingRainWater {
    public int trap(int[] A) {
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            left[i] = (i == 0) ? A[i] : Math.max(left[i - 1], A[i]);
            right[A.length - 1 - i] = (i == 0) ? A[A.length - 1] : Math.max(right[A.length - i], A[A.length - 1 - i]);
        }
        int result = 0; 
        for(int i = 0; i < A.length; i++) {
            result += Math.min(left[i], right[i]) - A[i];
        }
        return result;
    }
}
