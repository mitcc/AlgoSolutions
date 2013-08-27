/*
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?

 * For example,
 * Given sorted array A = [1,1,1,2,2,3],

 * Your function should return length = 5, and A is now [1,1,2,2,3].
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] A) {
        if(A.length == 0)
            return 0;
        int index = 1;
        int count = 1;
        for(int i = 1; i < A.length; i++) {
            if(A[i] == A[i - 1]) {
                count++;
                if(count <= 2) {
                    A[index++] = A[i];
                }
            } else {
                count = 1;
                A[index++] = A[i];
            }
        }
        return index;
    }
}
