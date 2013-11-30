/*
 * Given a non-negative integer n, count all numbers with unique 
 * digits, x, where 0 <= x < 10 ^ n.

 * Example:
 * Given n = 2, return 91. (The answer should be the total numbers in 
 * the range of 0 <= x < 100, excluding [11,22,33,44,55,66,77,88,99])
 * 
 * Hint:
 * 
 * A direct way is to use the backtracking approach.
 * Backtracking should contains three states which are (the current 
 * number, number of steps to get that number and a bitmask which 
 * represent which number is marked as visited so far in the current 
 * number). Start with state (0,0,0) and count all valid number till 
 * we reach number of steps equals to 10 ^ n.
 * This problem can also be solved using a dynamic programming 
 * approach and some knowledge of combinatorics.
 * Let f(k) = count of numbers with unique digits with length equals 
 * k.
 * f(1) = 10, ..., f(k) = 9 * 9 * 8 * ... (9 - k + 2) [The first 
 * factor is 9 because a number cannot start with 0].
 */
public class CountNumbersWithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        if (n < 0 || n > 10) {
            return 0;
        }
        int[] result = {
            1, 10, 91, 739, 5275, 32491, 168571, 
            712891, 2345851, 5611771, 8877691
        };
        return result[n];
    }

/*******************************************************************/

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        } else if (1 <= n && n <= 10) {
            int result = 10;
            for (int i = 2, permutation = 9; i <= n; ++i) {
                permutation *= 11 - i;
                result += permutation;
            }
            return result;
        }
        return 0;
    }

}
