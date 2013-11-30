/*
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return 
 * the bitwise AND of all numbers in this range, inclusive.

 * For example, given the range [5, 7], you should return 4.
 */
public class BitwiseANDOfNumbersRange {

    /*
     * Analysis:
     * 
     * To find the binary common prefix of m and n.
     */

    public int rangeBitwiseAnd(int m, int n) {
        int mask = Integer.MAX_VALUE;
        while ((m & mask) != (n & mask)) {
            mask <<= 1;
        }
        return m & mask;
    }

/*********************************************************/
    
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count++;
        }
        return m << count;
    }

/*********************************************************/
    
    public int rangeBitwiseAnd(int m, int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            if ((m & n & mask) != 0 && (n - m) <= mask)
                result += mask;
        }
        return result;
    }

}
