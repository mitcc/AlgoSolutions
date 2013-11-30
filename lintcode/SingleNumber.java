/*
 * Given 2*n + 1 numbers, every numbers occurs twice except one, find it.

Example
Given [1,2,2,1,3,4,3], return 4

Challenge
One-pass, constant extra space.
 */
public class SingleNumber {
    /**
	 *@param A : an integer array
	 *return : a integer 
	 */
    public int singleNumber(int[] A) {
        int xor = 0;
        for (int a : A) {
            xor ^= a;
        }
        return xor;
    }

}
