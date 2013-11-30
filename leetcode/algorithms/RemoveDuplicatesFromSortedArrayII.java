/*
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?

 * For example,
 * Given sorted array A = [1,1,1,2,2,3],

 * Your function should return length = 5, and A is now [1,1,2,2,3].
 */
public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] A) {
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (index < 2 || A[index - 1] != A[i] || A[index - 2] != A[i])
                A[index++] = A[i];
        }
        return index;
    }

/*****************************************************************************/

    public int removeDuplicates(int[] A) {
        if (A.length == 0)
            return A.length;
        int count = 1;
        int index = 1;
        for (int i = 1; i < A.length; i++) {
            count = A[i] == A[i - 1] ? count + 1 : 1;
            if (count <= 2)
                A[index++] = A[i];
        }
        return index;
    }

/*****************************************************************************/

    public int removeDuplicates(int[] A) {
        if (A.length == 0 || A.length == 1)
            return A.length;
        int index = 2;
        int prev = A[1];
        int tmp = A[0];
        for (int i = 2; i < A.length; i++) {
            prev = A[i - 1];
            if (A[i] != A[i - 1] || A[i] != tmp) 
                A[index++] = A[i];
            tmp = prev;
        }
        return index;
    } 
}
