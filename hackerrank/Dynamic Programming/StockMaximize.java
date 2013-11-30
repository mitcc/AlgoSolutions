/*
 * Problem Statement

Your algorithms have become so good at predicting the market that you now know 
what the share price of Wooden Orange Toothpicks Inc. (WOT) will be for the 
next N days.

Each day, you can either buy one share of WOT, sell any number of shares of WOT 
that you own, or not make any transaction at all. What is the maximum profit 
you can obtain with an optimum trading strategy?

Input

The first line contains the number of test cases T. T test cases follow:

The first line of each test case contains a number N. The next line contains N 
integers, denoting the predicted price of WOT shares for the next N days.

Output

Output T lines, containing the maximum profit which can be obtained for the 
corresponding test case.

Constraints

1 <= T <= 10 
1 <= N <= 50000

All share prices are between 1 and 100000

Sample Input

3
3
5 3 2
3
1 2 100
4
1 3 1 2
Sample Output

0
197
3
Explanation

For the first case, you cannot obtain any profit because the share price never 
rises. 
For the second case, you can buy one share on the first two days, and sell both 
of them on the third day. 
For the third case, you can buy one share on day 1, sell one on day 2, buy one
share on day 3, and sell one share on day 4.
 */
import java.util.Scanner;

public class StockMaximize {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int[] stock = new int[N];
            for (int j = 0; j < N; ++j) {
                stock[j] = in.nextInt();
            }
            System.out.println(stockMax(stock));
        }
    }

    public static long stockMax(int[] nums) {
        int rightMax = Integer.MIN_VALUE;
        long maxProfit = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            rightMax = Math.max(rightMax, nums[i]);
            maxProfit += rightMax - nums[i];
        }
        return maxProfit;
    }

}
