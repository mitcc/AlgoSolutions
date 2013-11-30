public class Chapter9 {

    // 9.1
    public int countWays(int n) {
        int mod = 1000000007;
        int[] dp = new int[3];
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            dp[i % 3] = ((dp[(i + 2) % 3] 
                        + dp[(i + 1) % 3]) % mod 
                        + dp[i % 3]) % mod;
        }
        return dp[n % 3];
    }

    // 9.2
    public int countWays(int x, int y) {
        int[] dp = new int[y];
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                if (i == 0 || j == 0) {
                    dp[j] = 1;
                } else {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[y - 1];
    }

    // 9.2-2
    public int countWays(int[][] map, int x, int y) {
        if (map == null) {
            return 0;
        }
        int mod = 1000000007;
        int[] dp = new int[y];
        dp[0] = 1;
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                if (map[i][j] != 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] = (dp[j] + dp[j - 1]) % mod;
                }
            }
        }
        return dp[y - 1];
    }

    // 9.3-1
    public boolean findMagicIndex(int[] A, int n) {
        return binarySearch(A, 0, A.length - 1);
    }

    public boolean binarySearch(int[] A, int low, int high) {
        while (0 <= low && low <= high && high < A.length) {
            int mid = low + ((high - low) >> 1);
            if (A[mid] == mid) {
                return true;
            } else if (A[mid] < mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    // 9.3-2
    public boolean findMagicIndex(int[] A, int n) {
        return findMagicIndex(A, 0, A.length - 1);
    }

    public boolean findMagicIndex(int[] A, int low, int high) {
        if (A == null || A.length == 0 || low < 0 || high >= A.length || low > high) {
            return false;
        }
        int mid = low + (high - low) / 2;
        if (A[mid] == mid) {
            return true;
        }
        return findMagicIndex(A, low, mid - 1) || findMagicIndex(A, mid + 1, high);
    }

    // 9.6
    public boolean chkParenthesis(String A, int n) {
        if (A == null || A.length() == 0) {
            return false;
        }
        for (int i = 0, count = 0; i < A.length(); ++i) {
            if (A.charAt(i) == '(') {
                count++;
            } else if (A.charAt(i) == ')') {
                count--;
            } else {
                return false;
            }
            if (count < 0) {
                return false;
            }
        }
        return true;
    }

    // 9.8
    public int countWays(int n) {
        int mod = 1000000007;
        int[] coins = {1, 5, 10, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= n; ++i) {
                dp[i] += dp[i - coin];
                dp[i] %= mod;
            }
        }
        return dp[n];
    }

}
