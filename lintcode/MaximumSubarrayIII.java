/*
 * Given an array of integers and a number k, find k non-overlapping subarrays 
 * which have the largest sum.

The number in each subarray should be contiguous.

Return the largest sum.

Example
Given [-1,4,-2,3,-2,3], k=2, return 8

Note
The subarray should contain at least one number
 */
public class MaximumSubarrayIII {

    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    // O(k * n ^ 2) time, O(k * n) space.
    public int maxSubArray(int[] nums, int k) {
        int len = nums.length;
        int[][] dp = new int[k + 1][len + 1];
        for (int i = 1; i <= k; ++i) {
            for (int j = i; j <= len; ++j) {
                dp[i][j] = Integer.MIN_VALUE;
                int maxSum = Integer.MIN_VALUE;
                for (int p = j, curSum = 0; p >= i; --p) {
                    curSum = Math.max(nums[p - 1], curSum + nums[p - 1]);
                    maxSum = Math.max(maxSum, curSum);
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][p - 1] + maxSum); 
                }
            }
        }
        return dp[k][len];
    }

}
