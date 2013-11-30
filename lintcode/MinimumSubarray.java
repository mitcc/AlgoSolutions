/*
 * Given an array of integers, find the subarray with smallest sum.

Return the sum of the subarray.

Example
For [1, -1, -2, 1], return -3

Note
The subarray should contain at least one integer.
 */
public class MinimumSubarray {

    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        int result = Integer.MAX_VALUE;
        for (int i = 0, curSum = 0; i < nums.size(); ++i) {
            curSum += nums.get(i);
            result = Math.min(result, curSum);
            curSum = Math.min(curSum, 0);
        }
        return result;
    }

}
