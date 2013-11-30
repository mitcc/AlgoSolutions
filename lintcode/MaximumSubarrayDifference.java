/*
 * Given an array with integers.

Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the 
largest.

Return the largest difference.

Example
For [1, 2, -3, 1], return 6.

Note
The subarray should contain at least one number

Challenge
O(n) time and O(n) space.
 */
public class MaximumSubarrayDifference {

    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        int[] leftMax = new int[nums.length];
        int[] leftMin = new int[nums.length];
        int[] rightMax = new int[nums.length];
        int[] rightMin = new int[nums.length];

        for (int i = 0, localMax = 0, localMin = 0; i < nums.length; ++i) {
            localMax += nums[i];
            leftMax[i] = Math.max(i == 0 ?
                    Integer.MIN_VALUE : leftMax[i - 1], localMax);
            localMax = Math.max(localMax, 0);

            localMin += nums[i];
            leftMin[i] = Math.min(i == 0 ?
                    Integer.MAX_VALUE : leftMin[i - 1], localMin);
            localMin = Math.min(localMin, 0);
        }

        for (int i = nums.length - 1, localMax = 0, localMin = 0; i >= 0; --i) {
            localMax += nums[i];
            rightMax[i] = Math.max(i == nums.length - 1 ?
                    Integer.MIN_VALUE : rightMax[i + 1], localMax);
            localMax = Math.max(localMax, 0);

            localMin += nums[i];
            rightMin[i] = Math.min(i == nums.length - 1 ?
                    Integer.MAX_VALUE : rightMin[i + 1], localMin);
            localMin = Math.min(localMin, 0);
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; ++i) {
            result = Math.max(result, Math.abs(leftMax[i] - rightMin[i + 1]));
            result = Math.max(result, Math.abs(leftMin[i] - rightMax[i + 1]));
        }
        return result;
    }

}
