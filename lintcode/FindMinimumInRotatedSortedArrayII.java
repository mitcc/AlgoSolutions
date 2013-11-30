/*
 * Suppose a sorted array is rotated at some pivot 
 * unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.

Example
Given [4,4,5,6,7,0,1,2] return 0
 */
public class FindMinimumInRotatedSortedArrayII {

    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        int low = 0;
        int high = num.length - 1;
        while (low < high) {
            if (num[low] == num[high]) {
                high--;
            } else {
                int mid = (low + high) / 2;
                if (num[mid] > num[high]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
        }
        return num[low];
    }

}
