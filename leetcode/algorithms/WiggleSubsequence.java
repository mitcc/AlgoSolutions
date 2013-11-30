/*
 * A sequence of numbers is called a wiggle sequence if the differences between 
 * successive numbers strictly alternate between positive and negative. The 
 * first difference (if one exists) may be either positive or negative. A 
 * sequence with fewer than two elements is trivially a wiggle sequence.

 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences 
 * (6,-3,5,-7,3) are alternately positive and negative. In contrast, 
 * [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its 
 * first two differences are positive and the second because its last 
 * difference is zero.
 * 
 * Given a sequence of integers, return the length of the longest subsequence 
 * that is a wiggle sequence. A subsequence is obtained by deleting some number 
 * of elements (eventually, also zero) from the original sequence, leaving the 
 * remaining elements in their original order.
 * 
 * Examples:
 * Input: [1,7,4,9,2,5]
 * Output: 6
 * The entire sequence is a wiggle sequence.
 * 
 * Input: [1,17,5,10,13,15,10,5,16,8]
 * Output: 7
 * There are several subsequences that achieve this length. One is 
 * [1,17,10,13,10,16,8].
 * 
 * Input: [1,2,3,4,5,6,7,8,9]
 * Output: 2
 * Follow up:
 * Can you do it in O(n) time?
 */
public class WiggleSubsequence {

    // O(n) time, O(1) space.
    // 计算拐点个数
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) {
                result++;
                for (; i + 1 < nums.length && nums[i + 1] >= nums[i]; ++i);
            } else if (nums[i] < nums[i - 1]) {
                result++;
                for (; i + 1 < nums.length && nums[i + 1] <= nums[i]; ++i);
            }
        }
        return result;
    }

/*****************************************************************************/

    // O(n ^ 2) time, O(n) space.
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 1;
        //dp[i][0] means nums[i] is the smaller than the previous 
        //while dp[i][1] means larger.
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < nums.length; ++i) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] < nums[j]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                } else if (nums[i] > nums[j]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
                result = Math.max(result, Math.max(dp[i][0], dp[i][1]));
            }
        }
        return result;
    }

}
