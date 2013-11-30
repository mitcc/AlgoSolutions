/*
 * Given a unsorted array with integers, find the median of it. 

A median is the middle number of the array after it is sorted. 

If there are even numbers in the array, return the N/2-th number after sorted.

Example
Given [4, 5, 1, 2, 3], return 3

Given [7, 9, 4, 5], return 5

Challenge
O(n) time.
 */
public class Median {

    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        return quickSort(nums, 0, nums.length - 1, (nums.length - 1) / 2); 
    }

    public int quickSort(int[] nums, int low, int high, int midIndex) {
        int i = low;
        for (int j = low; j < high; ++j) {
            if (nums[j] <= nums[high]) {
                swap(nums, i++, j);
            }
        }
        swap(nums, i, high);
        if (i == midIndex) {
            return nums[midIndex];
        } else if (i < midIndex) {
            return quickSort(nums, i + 1, high, midIndex); 
        } 
        return quickSort(nums, low, i - 1, midIndex);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
