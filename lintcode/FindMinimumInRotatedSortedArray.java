/*
 * Suppose a sorted array is rotated at some pivot 
 * unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

Example
Given [4, 5, 6, 7, 0, 1, 2] return 0

Note
You may assume no duplicate exists in the array.
 */
public class FindMinimumInRotatedSortedArray {

    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        int low = 0;
        int high = num.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (num[mid] < num[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return num[low];
    }

/***********************************************/

    public int findMin(int[] num) {
        int result = Integer.MAX_VALUE;
        for (int n : num) {
            result = Math.min(result, n);
        }
        return result;
    }

}
