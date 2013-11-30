/*
154. Factorial

time limit per test: 0.25 sec.
memory limit per test: 4096 KB
input: standard input
output: standard output



You task is to find minimal natural number N, so that N! contains exactly Q 
zeroes on the trail in decimal notation. As you know N! = 1*2*...*N. For example, 
5! = 120, 120 contains one zero on the trail.

Input
One number Q written in the input (0<=Q<=10^8).

Output
Write "No solution", if there is no such number N, and N otherwise.

Sample test(s)

Input
2

Output
10
 * 
 */
import java.util.Scanner;

public class P154 {
    public static int trailZeros(int n) {
        int cnt = 0;
        while(n > 0) {
            n /= 5;
            cnt += n;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        int low = 1;
        int high = 5 * Q;
        while(low < high) {
            int mid = low + (high - low >> 1);
            if(trailZeros(mid) < Q)
                low = mid + 1;
            else
                high = mid;
        }
        if(trailZeros(low) != Q)
            System.out.println("No solution");
        else
            System.out.println(low);
    }
}
