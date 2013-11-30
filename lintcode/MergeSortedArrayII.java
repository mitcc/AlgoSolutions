/*
 * Merge two given sorted integer array A and B 
 * into a new sorted integer array.

Example
A=[1,2,3,4]

B=[2,4,5,6]

return [1,2,2,3,4,4,5,6]

Challenge
How can you optimize your algorithm if one array 
is very large and the other is very small?
 */
public class MergeSortedArrayII {

    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        int[] C = new int[A.length + B.length];
        int i = A.length - 1;
        int j = B.length - 1;
        for (int k = A.length + B.length - 1; k >= 0; --k) {
            C[k] = (j < 0 || i >= 0 && A[i] > B[j]) ? A[i--] : B[j--];
        }
        return C;
    }

}
