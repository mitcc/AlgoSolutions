/*
 * Find the kth largest element in an unsorted array. Note that 
 * it is the kth largest element in the sorted order, not the 
 * kth distinct element.

 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 * Note: 
 * You may assume k is always valid, 1 <= k <= array's length.
 */
public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = nums.length - 2; j >= i; j--) {
                if (nums[j] < nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
        return nums[k - 1];
    }

/*******************************************************************/

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
        
}
