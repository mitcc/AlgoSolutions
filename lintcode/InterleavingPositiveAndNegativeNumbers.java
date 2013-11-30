/*
 * Given an array with positive and negative integers. Re-range it to 
 * interleaving with positive and negative integers.

 Notice

You are not necessary to keep the original order of positive integers 
or negative integers.

Example
Given [-1, -2, -3, 4, 5, 6], after re-range, it will be [-1, 5, -2, 4, 
-3, 6] or any other reasonable answer.

Challenge 
Do it in-place and without extra memory.
 */
public class InterleavingPositiveAndNegativeNumbers {

    /**
     * @param A: An integer array.
     * @return: void
     */
    public void rerange(int[] A) {
        int index = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] < 0) {
                swap(A, index++, i);
            }
        }
        if (2 * index != A.length) {
            if (2 * index < A.length) {
                for (int i = 0; i < A.length / 2; ++i) {
                    swap(A, i, A.length - 1 - i);
                }
                index = A.length - index;
            }
            swap(A, index - 1, A.length - 1);
            index--;
        }
        index += A.length / 2 % 2;
        for (int i = 1; i <= A.length / 2 - 1; i += 2, index += 2) {
            swap(A, i, index);
        }
    }

    public void swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

}
