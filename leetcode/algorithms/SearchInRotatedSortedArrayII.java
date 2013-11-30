/*
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?

 * Would this affect the run-time complexity? How and why?

 * Write a function to determine if a given target is in the array. 
 */
public class SearchInRotatedSortedArrayII {

    public boolean search(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while (start <= end) {
            while (start < end && A[end] == A[end - 1])
                end--;
            int mid = start + (end - start) / 2;
            if (target == A[mid])
                return true;
            else if (target < A[mid]) {
                if (A[mid] >= A[end] && target < A[start])
                    start = mid + 1;
                else 
                    end = mid - 1;
            } else {                
                if (A[mid] < A[end] && target > A[end])
                    end = mid - 1;
                else 
                    start = mid + 1;
            }
        }
        return false;
    }

/*****************************************************************************/

    public boolean search(int[] A, int target) {
        for(int i = 0; i < A.length; i++) {
            if(target == A[i])
                return true;
        }
        return false;
    } 
}
