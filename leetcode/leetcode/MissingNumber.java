/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find 
the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it 
using only constant extra space complexity?

 */
public class MissingNumber {

    // O(n) time, O(1) space.
    public int missingNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; ++i) {
            xor ^= (i + 1) ^ nums[i];
        }
        return xor;
    }

/*****************************************************************************/

    // O(n * lg(n)) time, O(1) space.
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

}
