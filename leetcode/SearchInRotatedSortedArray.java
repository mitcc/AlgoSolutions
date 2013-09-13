/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 * You are given a target value to search. If found in the array return its index, otherwise return -1.

 * You may assume no duplicate exists in the array.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        int low = 0, high = A.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(A[mid] == target)
                return mid;
            if(A[mid] >= A[low]) {
                if(target >= A[low] && target < A[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                if(target > A[mid] && target <= A[high])
                    low = mid + 1;
                else 
                    high = mid - 1;
            }
        }
        return -1;
    }
}
