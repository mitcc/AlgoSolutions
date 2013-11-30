/*
 * Given an array of n positive integers and a 
 * positive integer s, find the minimal length 
 * of a subarray of which the sum >= s. If 
 * there isn't one, return 0 instead.
 * For example, given the array [2,3,1,2,4,3] 
 * and s = 7,
 * the subarray [4,3] has the minimal length 
 * under the problem constraint.

 * More practice:
 * If you have figured out the O(n) solution, 
 * try coding another solution of which the 
 * time complexity is O(n log n).
 */
public class MinimumSizeSubarraySum {

    // O(n) time.
    public int minSubArrayLen(int s, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= s) {
                result = Math.min(result, right - left);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

/*********************************************************/    

    // O(n ^ 2) time.
    public int minSubArrayLen(int s, int[] nums) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    result = Math.min(result, j - i + 1);
                    break;
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
