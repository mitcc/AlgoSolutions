/*
Given an array of n positive integers and a positive integer s, find the 
minimal length of a subarray of which the sum ≥ s. If there isn't one, return
0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution of which 
the time complexity is O(n log n).
 */
public class MiniumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        int result = Integer.MAX_VALUE;
        for (int i = 0, j = 0, sum = 0; i < nums.length; ++i) {
            sum += nums[i];
            while (sum >= s) {
                result = Math.min(result, i - j + 1);
                sum -= nums[j++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
