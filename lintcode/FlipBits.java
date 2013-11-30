/*
 * Determine the number of bits required to flip if you 
 * want to convert integer n to integer m.

Example
Given n = 31 (11111), m = 14 (01110), return 2.

Note
Both n and m are 32-bit integers.
 */
public class FlipBits {

    public static int bitSwapRequired(int a, int b) {
        return hammingWeight(a ^ b);
    }

    public static int hammingWeight(int n) {
        n = n - ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        return (((n + (n >>> 4)) & 0x0f0f0f0f) * 0x01010101) >>> 24;
    }

}
