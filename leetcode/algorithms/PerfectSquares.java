/*
 * Given a positive integer n, find the least 
 * number of perfect square numbers (for example, 
 * 1, 4, 9, 16, ...) which sum to n.

 * For example, given n = 12, return 3 because
 *  12 = 4 + 4 + 4; given n = 13, return 2 because 
 *  13 = 4 + 9.
 */
public class PerfectSquares {

    // https://en.wikipedia.org/wiki/Lagrange%27s_four-square_theorem
    public int numSquares(int n) {
        if (Math.pow((int) Math.sqrt(n), 2) == n) {
            return 1;
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            return 4;
        }
        for (int i = 1; i * i <= n; ++i) {
            int j = (int) Math.sqrt(n - i * i);
            if (i * i + j * j == n) {
                return 2;
            }
        }
        return 3;
    }

/*******************************************************************/

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            int minNum = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; ++j) {
                minNum = Math.min(minNum, dp[i - j * j] + 1);
            }
            dp[i] = minNum;
        }
        return dp[n];
    }

}
