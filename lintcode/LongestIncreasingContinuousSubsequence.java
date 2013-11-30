/*
 * Give an integer array，find the longest increasing continuous 
 * subsequence in this array.

An increasing continuous subsequence:

Can be from right to left or from left to right.
Indices of the integers in the subsequence should be continuous.
Example
For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.

For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.
 */
public class LongestIncreasingContinuousSubsequence {

    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        int result = 0;
        for (int i = 0, count = 1; i < A.length; ++i) {
            count = 1 + (i > 0 && A[i] > A[i - 1] ? count : 0);
            result =  Math.max(result, count);
        }
        for (int i = A.length - 1, count = 1; i >= 1; --i) {
            count = 1 + (A[i] < A[i - 1] ? count : 0);
            result =  Math.max(result, count);
        }
        return result;
    }

}
