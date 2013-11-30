/*
 * Given a rotated sorted array, recover it to sorted array in-place.

Example
[4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]

Challenge
In-place, O(1) extra space and O(n) time.

Clarification
What is rotated array?

For example, the orginal array is [1,2,3,4], The rotated array of it 
can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
 */
public class RecoverRotatedSortedArray {

    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        int i = 1;
        for (; i < nums.size() && nums.get(i - 1) <= nums.get(i); ++i);
        reverse(nums, 0, i - 1);
        reverse(nums, i, nums.size() - 1);
        reverse(nums, 0, nums.size() - 1);
    }

    public void reverse(ArrayList<Integer> nums, int low, int high) {
        for (int i = 0; low < high && i <= (high - low) / 2; ++i) {
            int tmp = nums.get(low + i);
            nums.set(low + i, nums.get(high - i));
            nums.set(high - i, tmp);
        }
    }

}
