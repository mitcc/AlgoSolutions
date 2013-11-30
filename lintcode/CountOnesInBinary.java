/*
 * Count how many 1 in binary representation of a 32-bit integer.

Example
Given 32, return 1

Given 5, return 2

Given 1023, return 9

Challenge
If the integer is n bits with m 1 bits. Can you do it in O(m) time?
 */
public class CountOnesInBinary {

    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */

    public int countOnes(int num) {
        num = (num & 0x55555555) + ((num >>> 1) & 0x55555555);
        num = (num & 0x33333333) + ((num >>> 2) & 0x33333333);
        num = (num & 0x0f0f0f0f) + ((num >>> 4) & 0x0f0f0f0f);
        num = (num & 0x00ff00ff) + ((num >>> 8) & 0x00ff00ff);
        num = (num & 0x0000ffff) + ((num >>> 16) & 0x0000ffff);
        return num;
    }

/*****************************************************************************/

    public int countOnes(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }

}
