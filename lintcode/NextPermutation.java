/*
 * Given a list of integers, which denote a permutation.

Find the next permutation in ascending order.

Example
For [1,3,2,3], the next permutation is [1,3,3,2]

For [4,3,2,1], the next permutation is [1,2,3,4]

Note
The list may contains duplicate integers.
 */
public class NextPermutation {

    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return 
     * anything, modify nums in-place instead
     */
    public int[] nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }
        for (int j = nums.length - 1; i >= 1 && j >= 0; --j) {
            if (nums[j] > nums[i - 1]) {
                swap(nums, i - 1, j);
                break;
            }
        }
        for (int j = 0; j < (nums.length - i) / 2; ++j) {
            swap(nums, i + j, nums.length - 1 - j);
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
