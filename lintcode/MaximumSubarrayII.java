/*
 * Given an array of integers, find two non-overlapping subarrays which have 
 * the largest sum.
The number in each subarray should be contiguous.
Return the largest sum.

Example
For given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and [2, -1, 2] or 
[1, 3, -1, 2] and [2], they both have the largest sum 7.

Note
The subarray should contain at least one number

Challenge
Can you do it in time complexity O(n) ?
 */
public class MaximumSubarrayII {

    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        int[] leftMax = new int[nums.size()];
        for (int i = 0, leftLocalMax = 0; i < nums.size(); ++i) {
            leftLocalMax += nums.get(i);
            leftMax[i] = Math.max(i == 0 ? Integer.MIN_VALUE : 
                    leftMax[i - 1], leftLocalMax);
            leftLocalMax = Math.max(leftLocalMax, 0);
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = nums.size() - 1, localRightMax = 0, 
                globalRightMax = Integer.MIN_VALUE; i >= 1; --i) {
            localRightMax += nums.get(i);
            globalRightMax = Math.max(globalRightMax, localRightMax);
            localRightMax = Math.max(localRightMax, 0);
            maxSum = Math.max(maxSum, globalRightMax + leftMax[i - 1]);
        }
        return maxSum;
    }

}
