/*
Given an array S of n integers, find three integers in S such that the sum is 
closest to a given number, target. Return the sum of the three integers. You 
may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length; ++i) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int threeSum = nums[i] + nums[low] + nums[high];
                if (threeSum == target) {
                    return threeSum;
                } else if (threeSum < target) {
                    low++;
                } else {
                    high--;
                }
                if (Math.abs(threeSum - target) < Math.abs(result - target)) {
                    result = threeSum;
                }
            }
        }
        return result;
    }

}
