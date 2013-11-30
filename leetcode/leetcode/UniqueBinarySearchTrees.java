/*
Given n, how many structurally unique BST's (binary search trees) that store 
values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class UniqueBinarySearchTrees {

    // Catalan number https://en.wikipedia.org/wiki/Catalan_number
    public int numTrees(int n) {
        int result = 1;
        for (int i = 0; i < n; ++i) {
            result = (int) ((long) result * 2 * (2 * i + 1) / (i + 2));
        }
        return result;
    }

/*****************************************************************************/

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= i - 1; ++j) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }

/*****************************************************************************/

    // LTE
    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int result = 0;
        for (int i = 0; i <= n - 1; ++i) {
            result += numTrees(i) * numTrees(n - 1 - i);
        }
        return result;
    }

}
