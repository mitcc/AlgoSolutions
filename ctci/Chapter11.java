public class Chapter11 {

    public int[] findElement(int[][] mat, int n, int m, int x) {
        int i = 0;
        int j = m - 1;
        while (i < n && j >= 0) {
            if (mat[i][j] == x) {
                return new int[] {i, j};
            } else if (mat[i][j] < x) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

    // 11.7
    // O(n * lg (n))
    public int getHeight(int[] men, int n) {
        if (men == null || men.length == 0) {
            return 0;
        }
        int[] dp = new int[men.length];
        int len = 0;
        for (int m : men) {
            int index = Arrays.binarySearch(dp, 0, len, m);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = m;
            if (index == len) {
                len++;
            }
        }
        return len;
    }

    // O(n ^ 2)
    public int getHeight(int[] men, int n) {
        if (men == null || men.length == 0) {
            return 0;
        }
        int[] dp = new int[men.length];
        Arrays.fill(dp, 1);
        int result = 0;
        for (int i = 1; i < men.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (men[i] > men[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    // 11.8
    public int[] getRankOfNumber(int[] A, int n) {
        if (A == null || A.length == 0) {
            return null;
        }
        int[] result = new int[A.length];
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < A.length; ++i) {
            int low = 0;
            int high = list.size();
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (list.get(mid) < A[i]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            list.add(high, A[i]);
            result[i] = high;
        }
        return result;
    }

}
