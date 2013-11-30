/*
Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new 
place for his thievery so that he will not get too much attention. This time, 
all houses at this place are arranged in a circle. That means the first house 
is the neighbor of the last one. Meanwhile, the security system for these 
houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each 
house, determine the maximum amount of money you can rob tonight without 
alerting the police.
 */
public class HouseRobberII {

    public int rob(int[] nums) {
        return Math.max(rob(nums, 0, nums.length - 2), 
                rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int result = 0;
        for (int i = start, prevSum = 0; i <= end; ++i) {
            int tmp = prevSum;
            prevSum = Math.max(prevSum, result);
            result = Math.max(result, tmp + nums[i]);
        }
        return result;
    }

}
