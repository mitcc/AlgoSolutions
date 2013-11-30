/*
Find the contiguous subarray within an array (containing at least one number) 
which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        for (int i = 1, maxProduct = nums[0], minProduct = nums[0]; 
                i < nums.length; ++i) {
            int tmp = maxProduct;
            maxProduct = Math.max(nums[i], Math.max(nums[i] * maxProduct, 
                        nums[i] * minProduct));
            minProduct = Math.min(nums[i], Math.min(nums[i] * tmp, 
                        nums[i] * minProduct));
            result = Math.max(result, maxProduct);
        }
        return result;
    }

}
