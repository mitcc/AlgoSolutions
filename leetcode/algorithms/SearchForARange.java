/*
 * Given a sorted array of integers, find the starting 
 * and ending position of a given target value.

 * Your algorithm's runtime complexity must be in the 
 * order of O(log n).

 * If the target is not found in the array, return [-1, -1].

 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4]. 
 */
public class SearchForARange {

    public int[] searchReange(int[] A, int target) {
        int[] result = new int[2];
        int start = 0;
        int end = A.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        result[0] = (start < A.length && A[start] == target) ? start : -1;
        end = A.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        result[1] = (end >= 0 && A[end] == target) ? end : -1;
        return result;
    }

}
