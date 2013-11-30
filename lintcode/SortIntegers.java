/*
 * Given an integer array, sort it in ascending order. Use 
 * selection sort, bubble sort, insertion sort or any O(n2) 
 * algorithm.

Example
Given [3, 2, 1, 4, 5], return [1, 2, 3, 4, 5].
 */
public class SortIntegers {

    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers(int[] A) {
        quicksort(A, 0, A.length - 1);
    }

    // bubble sort
    public void bubbleSort(int[] A) {
        for (int i = 0; i < A.length; ++i) {
            for (int j = 1; j <= A.length - 1 - i; ++j) {
                if (A[j - 1] > A[j]) {
                    swap(A, j - 1, j);
                }
            }
        }
    }

    // selection sort
    public void selectSort(int[] A) {
        for (int i = 0; i < A.length; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < A.length; ++j) {
                if (A[j] < A[minIndex]) {
                    minIndex = j;
                }
            }
            swap(A, i, minIndex);
        }
    }

    // insertion sort
    public void insertSort(int[] A) {
        for (int i = 1; i < A.length; ++i) {
            for (int j = i; j >= 1 && A[j - 1] > A[j]; --j) {
                swap(A, j - 1, j);
            }
        }
    }

    // quick sort
    public void quicksort(int[] A, int low, int high) {
        if (low >= high) {
            return;
        }
        int index = low; 
        for (int i = low; i <= high; ++i) {
            if (A[i] < A[high]) {
                swap(A, index++, i);
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

}
