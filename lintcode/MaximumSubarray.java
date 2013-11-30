/*
 * Given an array of integers, find a contiguous subarray 
 * which has the largest sum.

Example
Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous 
subarray [4,−1,2,1] has the largest sum = 6.

Note
The subarray should contain at least one number.

Challenge
Can you do it in time complexity O(n)?
 */
public class MaximumSubarray {

    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0, curSum = 0; i < nums.length; ++i) {
            curSum = Math.max(nums[i], nums[i] + curSum);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }

}
