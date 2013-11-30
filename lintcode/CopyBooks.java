/*
 * Given an array A of integer with size of n( means n books and 
 * number of pages of each book) and k people to copy the book. You 
 * must distribute the continuous id books to one people to copy. 
 * (You can give book A[1],A[2] to one people, but you cannot give 
 * book A[1], A[3] to one people, because book A[1] and A[3] is not 
 * continuous.) Each person have can copy one page per minute. Return 
 * the number of smallest minutes need to copy all the books.

Example
Given array A = [3,2,4], k = 2.

Return 5( First person spends 5 minutes to copy book 1 and book 2 and 
second person spends 4 minutes to copy book 3. )

Challenge 
Could you do this in O(n*k) time ?
 */
public class CopyBooks {

    public int copyBooks(int[] pages, int k) {
        if (pages == null || pages.length == 0) {
            return 0;
        }
        int[] pageSum = new int[pages.length + 1];
        int maxPage = 0;
        int[][] dp = new int[k + 1][pages.length + 1];
        for (int i = 0; i < pages.length; ++i) {
            pageSum[i + 1] = pages[i] + pageSum[i];
            maxPage = Math.max(maxPage, pages[i]);
            dp[1][i + 1] = pageSum[i + 1];
        }
        if (k >= pages.length) {
            return maxPage;
        }
        for (int i = 2; i <= k; ++i) {
            for (int j = 1; j <= pages.length; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int p = 0; p < j; ++p) {
                    int last = dp[i - 1][p];
                    int cur = pageSum[j] - pageSum[p];
                    dp[i][j] = Math.min(dp[i][j], Math.max(last, cur));
                }
            }
        }
        return dp[k][pages.length];
    }

}
