/*
 * Given 2*n + 2 numbers, every numbers occurs twice except 
 * two, find them.

Example
Given [1,2,2,3,4,4,5,3] return 1 and 5

Challenge
O(n) time, O(1) extra space.
 */
public class SingleNumberIII {

    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        int xor = 0;
        for (int a : A) {
            xor ^= a;
        }
        xor &= ~(xor - 1);
        int candidate0 = 0;
        int candidate1 = 0;
        for (int a : A) {
            candidate0 ^= (a & xor) != 0 ? a : 0;
            candidate1 ^= (a & xor) == 0 ? a : 0;
        }
        return Arrays.asList(new Integer[]{candidate0, candidate1});
    }

}
