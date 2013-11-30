/*
 * Given two array of integers(the first array is array A, the second 
 * array is array B), now we are going to find a element in array A 
 * which is A[i], and another element in array B which is B[j], so 
 * that the difference between A[i] and B[j] (|A[i] - B[j]|) is as 
 * small as possible, return their smallest difference.

Example
For example, given array A = [3,6,7,4], B = [2,8,9,3], return 0

Challenge
O(n log n) time
 */
public class TheSmallestDifference {

    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int result = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            result = Math.min(result, Math.abs(A[i] - B[j]));
            if (A[i] < B[j]) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }

}
