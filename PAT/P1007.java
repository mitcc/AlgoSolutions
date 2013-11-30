/*
1007. Maximum Subsequence Sum (25)

时间限制
400 ms
内存限制
32000 kB
代码长度限制
16000 B
判题程序
Standard
作者
CHEN, Yue
Given a sequence of K integers { N1, N2, ..., NK }. A continuous subsequence 
is defined to be { Ni, Ni+1, ..., Nj } where 1 <= i <= j <= K. The Maximum 
Subsequence is the continuous subsequence which has the largest sum of its 
elements. For example, given sequence { -2, 11, -4, 13, -5, -2 }, its maximum 
subsequence is { 11, -4, 13 } with the largest sum being 20.

Now you are supposed to find the largest sum, together with the first and the
last numbers of the maximum subsequence.

Input Specification:

Each input file contains one test case. Each case occupies two lines. The 
first line contains a positive integer K (<= 10000). The second line contains 
K numbers, separated by a space.

Output Specification:

For each test case, output in one line the largest sum, together with the 
first and the last numbers of the maximum subsequence. The numbers must be 
separated by one space, but there must be no extra space at the end of a line. 
In case that the maximum subsequence is not unique, output the one with the 
smallest indices i and j (as shown by the sample case). If all the K numbers 
are negative, then its maximum sum is defined to be 0, and you are supposed to 
output the first and the last numbers of the whole sequence.

Sample Input:
10
-10 1 2 3 4 -5 -23 3 7 -21
Sample Output:
10 1 4
 */

import java.util.Scanner;

public class P1007 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = 0;
        int r = 0;
        int max = Integer.MIN_VALUE;
        int thisSum = 0;
        int thisL = 0;
        int[] data = new int[n];
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            data[i] = in.nextInt();
            thisSum += data[i];
            if (max < thisSum) {
                max = thisSum;
                r = i;
                if (l != thisL) 
                	l = thisL;
            }
            if (thisSum < 0) {
                thisSum = 0;
                thisL = i + 1;
            }
            if (data[i] >= 0)
                flag = true;
        }
        if (!flag) {
            max = 0;
            l = 0;
            r = n - 1;
        }
        System.out.println(max + " " + data[l] + " " + data[r]);
    }

}	
