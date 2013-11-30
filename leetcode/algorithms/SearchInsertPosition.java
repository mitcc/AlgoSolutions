/*
 * Given a sorted array and a target value, return the index if the target is 
 * found. 
 * If not, return the index where it would be if it were inserted in order.

 * You may assume no duplicates in the array.

 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * 
 */
public class SearchInsertPosition {
/*  public int searchInsert(int[] A, int target) {
        return binarySearch(A, 0, A.length - 1, target);
    }

    public int binarySearch(int[] A, int low, int high, int target) {
        int mid = low + (high - low) / 2;
        if(target == A[mid])
            return mid;
        if(low == high || low == mid && target < A[high])
            return target < A[low] ? low : low + 1;
        else if(target < A[mid])
            return binarySearch(A, low, mid - 1, target);
        else
            return binarySearch(A, mid + 1, high, target);
    }
*/
/*****************************************************************************/

    // O(lgn) time, O(1) space
    public int searchInsert(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) 
                start = mid + 1;
            else if (A[mid] == target) 
                return mid;
            else 
                end = mid - 1;
        }
        return start;
    }    

/*************************** updated 20141015 ********************************/
    // O(n) time, O(1) space

    public int searchInsert(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            if (i == 0 && A[i] > target || A[i] == target)
                return i;
            if (i < A.length - 1 && A[i] < target && target < A[i + 1]
                    || i == A.length - 1 && A[i] < target)
                return i + 1;
        }
        return -1;
    }

}
