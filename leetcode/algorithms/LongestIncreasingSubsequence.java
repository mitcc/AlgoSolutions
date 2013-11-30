/*
 * Given an unsorted array of integers, find the length of longest 
 * increasing subsequence.

 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore 
 * the length is 4. Note that there may be more than one LIS 
 * combination, it is only necessary for you to return the length.

 * Your algorithm should run in O(n^2) complexity.

 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence {

    // O(n * lg(n)) time, O(n) space.
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int num : nums) {
            if (list.size() == 0 || list.get(list.size() - 1) < num) {
                list.add(num);
            } else {
                list.set(findPosition(list, num), num);
            }
        }
        return list.size();
    }
    
    /**
     * find the minimum number's index which is larger or 
     * equal to the given value
     */
    public int findPosition(List<Integer> list, int value) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (value == list.get(mid)) {
                return mid;
            } else if (value < list.get(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

/*******************************************************************/

    // O(n ^ 2) time, O(n) space.
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 1;
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

}
