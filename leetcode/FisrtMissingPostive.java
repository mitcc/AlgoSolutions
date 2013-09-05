/*
 * Given an unsorted integer array, find the first missing positive integer.

 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.

 * Your algorithm should run in O(n) time and uses constant space.
 */
public class FirstMissingPositive {
/*  public int firstMissingPositive(int[] A) {
        for(int i = 0; i < A.length; i++) {
            while(A[i] > 0 && A[i] <= A.length && A[i] != A[A[i] - 1]) {
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
            }
        }
        for(int i = 0; i < A.length; i++) {
            if(A[i] != i + 1)
                return i + 1;
        }
        return A.length + 1;
    }*/


    public int firstMissingPositive(int[] A) {
        int i = 0;
        while(i < A.length) {
            if(A[i] >= 1 && A[i] <= A.length && A[i] != i + 1 && A[A[i] - 1] != A[i]) {
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
            } else
                i++;
        }
        for(int j = 0; j < A.length; j++) {
            if(A[j] != j + 1)
                return j + 1;
        }
        return A.length + 1;
    }
}
