/*
 * Given a non negative integer number num. For every numbers i in the range 
 * 0 <= i <= num calculate the number of 1's in their binary representation and 
 * return them as an array.
 * 
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * 
 * Follow up:
 * 
 * It is very easy to come up with a solution with run time 
 * O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a 
 * single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like 
 * __builtin_popcount in c++ or in any other language.
 * Hint:
 * 
 * You should make use of what you have produced already.
 * Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to 
 * generate new range from previous.
 * Or does the odd/even status of the number help you in calculating the number 
 * of 1s?
 */
public class CountingBits {

    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for (int i = 0; i <= num; ++i) {
            bits[i] = bits[i / 2] + (i % 2 == 0 ? 0 : 1);
        }
        return bits;
    }

/*******************************************************************/

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; ++i) {
            result[i] = hammingWeight(i);
        }
        return result;
    }

    public int hammingWeight(int n) {
        n = n - ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        return (((n + (n >>> 4)) & 0x0f0f0f0f) * 0x01010101) >>> 24;
    }

}
