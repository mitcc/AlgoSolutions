/* Find the contiguous subarray within an array (containing at 
 * least one number) which has the largest sum.

 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */ 
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0, curSum = 0; i < nums.length; ++i) {
            curSum = Math.max(nums[i], nums[i] + curSum);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }


    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int thisSum = 0;
        for (int i = 0; i < nums.length; i++) {
            thisSum = Math.max(thisSum, 0) + nums[i];
            result = Math.max(result, thisSum);
        }
        return result;
    }

}
