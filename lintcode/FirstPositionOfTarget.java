/*
 * For a given sorted array (ascending order) and a target 
 * number, find the first index of this number in O(log n) 
 * time complexity.

If the target number does not exist in the array, return -1.

Example
If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, 
return 2.

Challenge
If the count of numbers is bigger than 2^32, can your code 
work properly?
 */
public class FirstPositionOfTarget {

    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high && target <= nums[high]) {
            if (nums[low] == target) {
                return low;
            }
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                high = mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            }
        }
        return -1;
    }

}
