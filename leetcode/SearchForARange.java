/*
 * Given a sorted array of integers, find the starting and ending position of a given target value.

 * Your algorithm's runtime complexity must be in the order of O(log n).

 * If the target is not found in the array, return [-1, -1].

 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4]. 
 */
public class SearchForARange {
/*   O(n)
 *  public int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
        int start = 0, end = A.length - 1;
        for(; start < A.length - 1 && A[start] != target; start++);
        for(; end >= start && A[end] != target; end--);
        if(start > end) {
            start = -1;
            end = -1;
        }
        res[0] = start;
        res[1] = end;
        return res;
    }
*/
/*    O(log n)    */
    public int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
        int low = 0, high = A.length - 1, mid = 0;
        while(low <= high) {
            mid = low + (high - low) / 2;
            if(A[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        res[0] = (low >= A.length || A[low] != target) ? -1 : low;

        high = A.length - 1;
        while(low <= high) {
            mid = low + (high - low) / 2;
            if(A[mid] > target) 
                high = mid - 1;
            else
                low = mid + 1;
        }
        res[1] = (high < 0 || A[high] != target) ? -1 : high; 
        return res;
    }
}
