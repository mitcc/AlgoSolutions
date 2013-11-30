/*
 * Given an unsorted array nums, reorder it such that

nums[0] < nums[1] > nums[2] < nums[3]....

Example
Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].

Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 */
public class WiggleSortII {

    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        int[] tmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp);
        for (int i = nums.length - 1, j = 0, k = i / 2 + 1; i >= 0; --i) {
            nums[i] = tmp[i % 2 == 0 ? j++ : k++];
        }
    }

}
