/*
 * Find the contiguous subarray within an array (containing 
 * at least one number) which has the largest product.

Example
For example, given the array [2,3,-2,4], the contiguous 
subarray [2,3] has the largest product = 6.
 */
public class MaximumProductSubarray {

    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public tin maxProduct(int[] nums) {
        int globalMax = Integer.MIN_VALUE;
        int localMax = 1;
        int localMin = 1;
        for (int num : nums) {
            int tmp = localMax; 
            localMax = Math.max(num, Math.max(localMax * num, localMin * num));
            localMin = Math.min(num, Math.min(tmp * num, localMin * num));
            globalMax = Math.max(globalMax, localMax);
        }
        return globalMax;
    }

}
