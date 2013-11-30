/*
Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose an array sorted in ascending order is rotated at some pivot unknown to 
you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
 */
public class FindMinimumInRotatedSortedArrayII {

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            if (nums[low] == nums[low + 1]) {
                low++;
            } else if (nums[high] == nums[high - 1]) {
                high--;
            } else {
                int mid = low + (high - low >> 1);
                if (nums[mid] < nums[high]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return nums[low];
    }

/*****************************************************************************/

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            for (; low < high - 1 && nums[low] == nums[low + 1]; ++low);
            for (; high > low + 1 && nums[high] == nums[high - 1]; --high);
            int mid = low + (high - low >> 1);
            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[low];
    }

}
