/*
 * Given an array nums of integers and an int k, partition 
 * the array (i.e move the elements in "nums") such that:

All elements < k are moved to the left
All elements >= k are moved to the right
Return the partitioning index, i.e the first index i 
nums[i] >= k.

 Notice

You should do really partition in array nums instead of 
just counting the numbers of integers smaller than k.

If all elements in nums are smaller than k, then return 
nums.length

Example
If nums = [3,2,2,1] and k=2, a valid answer is 1.

Challenge
Can you partition the array in-place and in O(n)?
 */
public class PartitionArray {

    /** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        int i = 0;
        for (int j = 0; j < nums.length; ++j) {
            if (nums[j] < k) {
                swap(nums, i++, j);
            }
        }
        return i;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

}
