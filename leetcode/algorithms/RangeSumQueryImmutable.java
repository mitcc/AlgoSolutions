/*
 * Given an integer array nums, find the sum of the elements
 * between indices i and j (i ¡Ü j), inclusive.

 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]

 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
public class RangeSumQueryImmutable {

}

class NumArray {

    int[] dp;

    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        dp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            dp[i + 1] = dp[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return dp[j + 1] - dp[i];
    }

}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
