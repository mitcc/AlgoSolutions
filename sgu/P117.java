/*
117. Counting


time limit per test: 0.25 sec. 
memory limit per test: 4096 KB

Find amount of numbers for given sequence of integer numbers such that after 
raising them to the M-th power they will be divided by K.

Input

Input consists of two lines. There are three integer numbers N, M, K (0<N, M, 
K<10001) on the first line. There are N positive integer numbers − given sequence 
(each number is not more than 10001) − on the second line.

Output

Write answer for given task.

Sample Input

 4 2 50
9 10 11 12
Sample Output

 1
 * 
 */
import java.util.*;

public class P117 {
    public static int powMod(int n, int m, int k) {
        if(m == 1)
            return n % k;
        int res = powMod(n, m / 2, k);
        res = res * res % k;
        if(m % 2 != 0)
            res = res * n % k;
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int cnt = 0; 
        for(int i = 0; i < n; i++) {
            if(powMod(in.nextInt(), m, k) == 0)
                cnt++;
        }
        System.out.print(cnt);
    }
}
