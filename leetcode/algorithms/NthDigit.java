/*
 * Find the nth digit of the infinite integer sequence 1, 2,
 * 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

 * Note:
 * n is positive and will fit within the range of a 32-bit 
 * signed integer (n < 2^31).
 * 
 * Example 1:
 * 
 * Input:
 * 3
 * 
 * Output:
 * 3
 * Example 2:
 * 
 * Input:
 * 11
 * 
 * Output:
 * 0
 * 
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9,
 * 10, 11, ... is a 0, which is part of the number 10.
 */
public class NthDigit {

    public int findNthDigit(int n) {
        int len = 1;
        for (; n > len * 9 * (Math.pow(10, len - 1)); ++len) {
            n -= len * 9 * Math.pow(10,len - 1);
        }
        int num = (int) Math.pow(10, len - 1) + (n - 1) / len;
        num /= ((int) Math.pow(10, len - ((n - 1) % len + 1)));
        return num % 10;
    }

}
