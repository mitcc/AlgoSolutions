/*
 * Given an array of non-negative integers, you are 
 * initially positioned at the first index of the array.

Each element in the array represents your maximum 
jump length at that position.

Your goal is to reach the last index in the 
minimum number of jumps.

Example
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2.
(Jump 1 step from index 0 to 1, then 3 steps to the last 
index.)
 */
public class JumpGameII {

    public int jump(int[] A) {
        int farreach = 0;
        int count = 0;
        int end = 0;
        for (int i = 0; i < A.length - 1; ++i) {
            farreach = Math.max(farreach, i + A[i]);
            if (i >= end) {
                count++;
                end = farreach;
            }
        }
        return count;
    }

/*******************************************************************/

    public int jump(int[] A) {
        int[] dp = new int[A.length];
        for (int i = 0; i < A.length; ++i) {
            for (int j = i + 1; j < A.length && j <= i + A[i]; ++j) {
                if (dp[j] == 0) {
                    dp[j] = dp[i] + 1;
                } else {
                    dp[j] = Math.min(dp[j], dp[i] + 1);
                }
            }
        }
        return dp[A.length - 1];
    }

}
