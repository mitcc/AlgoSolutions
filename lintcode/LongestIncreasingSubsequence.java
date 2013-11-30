/*
 * Given a sequence of integers, find the longest increasing 
 * subsequence (LIS).

You code should return the length of the LIS.

Have you met this question in a real interview? Yes
Example
For [5, 4, 1, 2, 3], the LIS  is [1, 2, 3], return 3

For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4

Challenge
Time complexity O(n^2) or O(nlogn)

Clarification
What's the definition of longest increasing subsequence?

    * The longest increasing subsequence problem is to find a 
    * subsequence of a given sequence in which the subsequence's 
    * elements are in sorted order, lowest to highest, and in which 
    * the subsequence is as long as possible. This subsequence is 
    * not necessarily contiguous, or unique.  

    * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 */
public class LongestIncreasingSubsequence {

    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] >= nums[i]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        int result = 0;
        for (int v : dp) {
            result = Math.max(result, v);
        }
        return result;
    }

}
