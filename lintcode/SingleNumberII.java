/*
 * Given 3*n + 1 numbers, every numbers occurs triple times except one, find it.

Example
Given [1,1,2,3,3,3,2,2,4,1] return 4

Challenge
One-pass, constant extra space.
 */
public class SingleNumberII {

    public int singleNumberII(int[] A) {
        int[] bits = new int[32];
        int result = 0;
        for (int i = 0; i < 32; ++i) {
            for (int a : A) {
                bits[i] += (a >> i) & 1;
            }
            result |= (bits[i] % 3) << i;
        }
        return result;
    }

}
