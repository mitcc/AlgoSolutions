/*
 * Given a permutation which contains no repeated number, 
 * find its index in all the permutations of these numbers, 
 * which are ordered in lexicographical order. The index 
 * begins at 1.

Example
Given [1,2,4], return 1.
 */
public class PermutationIndex {

    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
        long result = 1;
        long factorial = 1;
        for (int i = A.length - 2; i >= 0; --i) {
            factorial *= A.length - 1 - i;
            int reversedOrderCount = 0;
            for (int j = i + 1; j < A.length; ++j) {
                if (A[i] > A[j]) {
                    reversedOrderCount++;
                }
            }
            result += reversedOrderCount * factorial;
        }
        return result;
    }

}
