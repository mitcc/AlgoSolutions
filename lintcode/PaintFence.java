/*
 * There is a fence with n posts, each post can be painted with one of 
 * the k colors.
You have to paint all the posts such that no more than two adjacent 
fence posts have the same color.
Return the total number of ways you can paint the fence.

 Notice

n and k are non-negative integers.

Example
Given n=3, k=2 return 6

      post 1,   post 2, post 3
way1    0         0       1 
way2    0         1       0
way3    0         1       1
way4    1         0       0
way5    1         0       1
way6    1         1       0
 */
public class PaintFence {

    /**
     * @param n non-negative integer, n posts
     * @param k non-negative integer, k colors
     * @return an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        if (n <= 1) {
            return n * k;
        }
        int[] dp = {k, k * k, 0};
        for (int i = 2; i < n; ++i) {
            dp[i % 3] = (k - 1) * (dp[(i - 1) % 3] + dp[(i - 2) % 3]);
        }
        return dp[(n - 1) % 3];
    }

}
