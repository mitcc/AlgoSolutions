/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you 
climb to the top?

Note: Given n will be a positive integer.
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        int result = 1;
        for (int i = 1, j = 0; i <= n; ++i) {
            int tmp = result;
            result += j;
            j = tmp;
        }
        return result;
    }

/*****************************************************************************/

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    
}
