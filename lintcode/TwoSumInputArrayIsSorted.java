/*
Given an array of integers that is already sorted in ascending order, find two
numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add
up to the target, where index1 must be less than index2. Please note that your
returned answers (both index1 and index2) are not zero-based.

 Notice

You may assume that each input would have exactly one solution.

Example
Given nums = [2, 7, 11, 15], target = 9
return [1, 2]
 */
public class TwoSumInputArrayIsSorted {

    /*
     * @param nums an array of Integer
     * @param target = nums[index1] + nums[index2]
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            if (nums[low] + nums[high] == target) {
                return new int[] {low + 1, high + 1};
            } else if (nums[low] + nums[high] < target) {
                low++;
            } else {
                high--;
            }
        }
        return null;
    }

}
