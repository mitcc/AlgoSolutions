/*
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?

 * Would this affect the run-time complexity? How and why?
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 * Find the minimum element.

 * The array may contain duplicates. 
 */

public class FindMininumInRotatedSortedArrayII {

    public int findMin(int[] num) {
        int start = 0;
        int end = num.length - 1;
        while (start < end) {
            if (num[start] == num[start + 1] || num[start] == num[end])
                start++;
            else if (num[end] == num[end - 1])
                end--;
            else {
                int mid = start + (end - start) / 2;
                if (num[mid] < num[end])
                    end = mid;
                else 
                    start = mid + 1;
            }
        }
        return num[start];
    }

}
