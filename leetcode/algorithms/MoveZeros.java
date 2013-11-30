/*
 * Given an array nums, write a function to move all 0's to the 
 * end of it while maintaining the relative order of the non-zero 
 * elements.

 * For example, given nums = [0, 1, 0, 3, 12], after calling your 
 * function, nums should be [1, 3, 12, 0, 0].

 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeros {

    public void moveZeros(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

}
