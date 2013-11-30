/*
 * Given an array nums, write a function to move all 0's to 
 * the end of it while maintaining the relative order of 
 * the non-zero elements.

 Notice

You must do this in-place without making a copy of the 
array.
Minimize the total number of operations.
Example
Given nums = [0, 1, 0, 3, 12], after calling your function, 
nums should be [1, 3, 12, 0, 0].
 */
public class MoveZeroes {

    /**
     * @param nums an integer array
     * @return nothing, do this in-place
     */
    public void moveZeroes(int[] nums) {
        for (int i = 0, index = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                swap(nums, i, index++);
            }
        }
    }

    public void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

}
