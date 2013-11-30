/*
 * We are playing the Guess Game. The game is as follows:

 * I pick a number from 1 to n. You have to guess which number I 
 * picked.
 * 
 * Every time you guess wrong, I'll tell you whether the number I 
 * picked is higher or lower.
 * 
 * However, when you guess a particular number x, and you guess 
 * wrong, you pay $x. You win the game when you guess the number I 
 * picked.
 * 
 * Example:
 * 
 * n = 10, I pick 8.
 * 
 * First round:  You guess 5, I tell you that it's higher. You pay $5.
 * Second round: You guess 7, I tell you that it's higher. You pay $7.
 * Third round:  You guess 9, I tell you that it's lower. You pay $9.
 * 
 * Game over. 8 is the number I picked.
 * 
 * You end up paying $5 + $7 + $9 = $21.
 * Given a particular n ≥ 1, find out how much money you need to have
 * to guarantee a win.
 * 
 * Hint:
 * 
 * The best strategy to play the game is to minimize the maximum loss 
 * you could possibly face. Another strategy is to minimize the 
 * expected loss. Here, we are interested in the first scenario.
 * Take a small example (n = 3). What do you end up paying in the 
 * worst case?
 * Check out this article if you're still stuck.
 * The purely recursive implementation of minimax would be worthless 
 * for even a small n. You MUST use dynamic programming.
 * As a follow-up, how would you modify your code to solve the 
 * problem of minimizing the expected loss, instead of the worst-case 
 * loss?
 */
public class GuessNumberHigherOrLowerII {

    public int getMoneyAmount(int n) {
        if (n < 1) {
            return 0;
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n; i >= 1; --i) {
            for (int j = i + 1; j <= n; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; ++k) {
                    dp[i][j] = Math.min(dp[i][j], 
                            k + Math.max(dp[i][k - 1], dp[k + 1][j]));
                }
            }
        }
        return dp[1][n];
    }

/*****************************************************************************/

    public int getMoneyAmount(int n) {
        if (n < 1) {
            return 0;
        }
        int[][] dp = new int[n + 1][n + 1];
        return getMoneyAmount(dp, 1, n);
    }

    public int getMoneyAmount(int[][] dp, int low, int high) {
        if (low >= high) {
            return 0;
        }
        if (dp[low][high] != 0) {
            return dp[low][high];
        }
        dp[low][high] = Integer.MAX_VALUE;
        for (int i = low; i <= high; ++i) {
            dp[low][high] = Math.min(dp[low][high], 
                    i + Math.max(getMoneyAmount(dp, low, i - 1), 
                        getMoneyAmount(dp, i + 1, high)));
        }
        return dp[low][high];
    }

}
