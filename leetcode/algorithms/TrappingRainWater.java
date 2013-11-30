/*
 * Given n non-negative integers representing an elevation map where the width 
 * of each bar is 1, compute how much water it is able to trap after raining.

 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TrappingRainWater {

    public int trap(int[] A) {
        int[] leftMax = new int[A.length];
        int[] rightMax = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            leftMax[i] = Math.max(leftMax[i - (i == 0 ? 0 : 1)], A[i]);
            rightMax[A.length - 1 - i] = Math.max(rightMax[A.length - 
                    (i == 0 ? 1 : 0) - i], A[A.length - 1 - i]);
        }
        int result = 0 ;
        for (int i = 0; i < A.length; i++) {
            result += Math.min(leftMax[i], rightMax[i]) - A[i];
        }
        return result;
    }

/*****************************************************************************/

    public int trap(int[] A) {
        int result = 0;
        int start = 0; 
        int end = A.length - 1;
        while (start < end) {
            int k;
            if (A[start] < A[end]) {
                k = start + 1;
                while (A[k] < A[start]) {
                    result += A[start] - A[k++];
                }
                start = k;
            } else {
                k = end - 1;
                while (A[k] < A[end]) {
                    result += A[end] - A[k--];
                }
                end = k;
            }
        }
        return result;
    }

/*****************************************************************************/

    public int trap(int[] A) {
        int result = 0;
        int start = 0;
        int end = A.length;
        int leftMax = 0;
        int rightMax = 0;
        while (start < end) {
            if (leftMax < rightMax) {
                result += Math.max(leftMax - A[start], 0);
                leftMax = Math.max(leftMax, A[start++]);
            } else {
                result += Math.max(rightMax - A[--end], 0);
                rightMax = Math.max(rightMax, A[end]);
            }
        }
        return result;
    }

}
