/*
 * Given a positive integer num, write a function which returns 
 * True if num is a perfect square else False.

 * Note: Do not use any built-in library function such as sqrt.
 * 
 * Example 1:
 * 
 * Input: 16
 * Returns: True
 * Example 2:
 * 
 * Input: 14
 * Returns: False
 */
public class ValidPerfectSquare {

    // O(1) time
    public boolean isPerfectSquare(int num) {
        int sqrt = 0;
        for (int mask = 1 << 15; mask > 0; mask >>>= 1) {
            sqrt |= mask;
            if (sqrt > num / sqrt) {
                sqrt ^= mask;
            }
        }
        return sqrt * sqrt == num;
    }

/*******************************************************************/

    public boolean isPerfectSquare(int num) {
        for (int i = 1; num > 0; ++i) {
            num -= 2 * i - 1;
        }
        return num == 0;
    }

/*******************************************************************/

    // O(lg(n)) time
    public boolean isPerfectSquare(int num) {
        int sqrt = sqrt(num);
        return sqrt * sqrt == num;
    }

    public int sqrt(int num) {
        double x = num;
        double y = 0;
        while (y != x) {
            y = x;
            x = (x + num / x) / 2;
        }
        return (int) x;
    }

}
