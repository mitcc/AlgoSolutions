/*
 * Reverse bits of a given 32 bits unsigned integer.

 * For example, given input 43261596 (represented 
 * in binary as 00000010100101000001111010011100), 
 * return 964176192 (represented in binary as 
 * 00111001011110000010100101000000).
 */
public class ReverseBits {

    public int reverseBits(int n) {
        n = ((n & 0x55555555) << 1) | ((n & 0xAAAAAAAA) >>> 1);
        n = ((n & 0x33333333) << 2) | ((n & 0xCCCCCCCC) >>> 2);
        n = ((n & 0x0F0F0F0F) << 4) | ((n & 0xF0F0F0F0) >>> 4);
        n = ((n & 0x00FF00FF) << 8) | ((n & 0xFF00FF00) >>> 8);
        n = ((n & 0x0000FFFF) << 16) | ((n & 0xFFFF0000) >>> 16);
        return n;
    }

}
