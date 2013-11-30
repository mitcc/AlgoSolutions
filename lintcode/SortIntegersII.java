/*
 * Given an integer array, sort it in ascending order. Use quick 
 * sort, merge sort, heap sort or any O(nlogn) algorithm.

Example
Given [3, 2, 1, 4, 5], return [1, 2, 3, 4, 5].
 */
public class SortIntegersII {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        if (A == null || A.length <= 1) {
            return;
        }
        quicksort(A, 0, A.length - 1);
    }

/*******************************************************************/

    public void quicksort(int[] A, int low, int high) {
        if (low < 0 || high >= A.length || low >= high) {
            return;
        }
        int index = low;
        for (int i = low; i < high; ++i) {
            if (A[i] <= A[high]) {
                swap(A, i, index++);
            }
        }
        swap(A, index, high);
        quicksort(A, low, index - 1);
        quicksort(A, index + 1, high);
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

/*******************************************************************/

    public void mergesort(int[] A, int low, int high) {
        if (low < 0 || high >= A.length || low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergesort(A, low, mid);
        mergesort(A, mid + 1, high);
        merge(A, low, mid, high);
    }

    public void merge(int[] A, int low, int mid, int high) {
        int[] cache = new int[high - low + 1];
        int iLow = low;
        int iHigh = mid + 1;
        for (int i = 0; i < cache.length; ++i) {
            if (iHigh > high || iLow <= mid && A[iLow] < A[iHigh]) {
                cache[i] = A[iLow++];
            } else {
                cache[i] = A[iHigh++];   
            }
        }
        for (int i = 0; i < cache.length; ++i) {
            A[low + i] = cache[i];
        }
    }

}
