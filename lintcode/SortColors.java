/*
 * Given an array with n objects colored red, white or 
 * blue, sort them so that objects of the same color 
 * are adjacent, with the colors in the order red, white 
 * and blue.

Here, we will use the integers 0, 1, and 2 to represent 
the color red, white, and blue respectively.

Example
Given [1, 0, 1, 2], return [0, 1, 1, 2].

Note
You are not suppose to use the library's sort function 
for this problem.

Challenge
A rather straight forward solution is a two-pass 
algorithm using counting sort.
First, iterate the array counting number of 0's, 1's,
and 2's, then overwrite array with total number of 0's, 
then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only 
constant space?
 */
public class SortColors {

    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        int i = 0; 
        int j = nums.length - 1;
        for (int k = 0; k <= j; ++k) {
            if (nums[k] == 0) {
                swap(nums, k, i++);
            } else if (nums[k] == 2) {
                swap(nums, k--, j--);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
