/*
 * After robbing those houses on that street, the 
 * thief has found himself a new place for his 
 * thievery so that he will not get too much 
 * attention. This time, all houses at this place 
 * are arranged in a circle. That means the first 
 * house is the neighbor of the last one. 
 * Meanwhile, the security system for these 
 * houses remain the same as for those in the 
 * previous street.
 * 
 * Given a list of non-negative integers 
 * representing the amount of money of each house, 
 * determine the  * imum amount of money you can 
 * rob tonight without alerting the police.
 */
public class HouseRobberII {

    public int rob(int[] nums) {
        return Math.max(rob(nums, 0, nums.length - 2), 
                rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int start, int end) {
        if (nums.length == 1)
            return nums[0];
        int result = 0;
        int pre = 0;
        for (int i = start; i <= end; i++) {
            int tmp = pre;
            pre = Math.max(pre, result);
            result = Math.max(result, tmp + nums[i]);
        }
        return result;
    }

/*****************************************************************************/

    public int rob(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, rob(nums, i));
        }
        return result;
    }

    public int rob(int[] nums, int startPos) {
        int result = nums[startPos];
        int pre = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            int tmp = result;
            result = Math.max(result, pre + nums[(i + startPos) % nums.length]);
            pre = tmp;
        }
        return result;
    }

}
