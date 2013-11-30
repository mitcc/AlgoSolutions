/*
 * Write a function that takes an unsigned integer and 
 * returns the number of ¡¯1' bits it has (also known 
 * as the Hamming weight).

 * For example, the 32-bit integer ¡¯11' has binary 
 * representation 00000000000000000000000000001011, so 
 * the function should return 3.
 */
public class NumberOfOneBits {

    https://en.wikipedia.org/wiki/Hamming_weight
    http://graphics.stanford.edu/~seander/bithacks.html#CountBitsSetParallel
    public int hammingWeight(int n) {
        n = n - ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        return (((n + (n >>> 4)) & 0x0f0f0f0f) * 0x01010101) >>> 24;
    }

/*********************************************************/

    public int hammingWeight(int n) {
        n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n & 0x0f0f0f0f) + ((n >>> 4) & 0x0f0f0f0f);
        n = (n & 0x00ff00ff) + ((n >>> 8) & 0x00ff00ff);
        n = (n & 0x0000ffff) + ((n >>> 16) & 0x0000ffff);
        return n;
    }
    
/*********************************************************/

    public int hammingWeight(int n) {
        int count = 0;
        for (; n != 0; n = n & (n - 1), count++);
        return count;
    }

}
