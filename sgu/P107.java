/*
107. 987654321 problem


time limit per test: 0.25 sec. 
memory limit per test: 4096 KB

For given number N you must output amount of N-digit numbers, such, that last 
digits of their square is equal to 987654321.

Input

Input contains integer number N (1<=N<=106)

Output

Write answer to the output.

Sample Input

 8
Sample Output

 0
 * 
 */
import java.math.*;
import java.util.*;

public class P107 {
    /*
     * 111111111
     * 611111111
     * 380642361
     * 880642361
     * 119357639
     * 619357639
     * 388888889
     * 888888889
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StringBuilder sb = null;
        if(n < 9)
            sb = new StringBuilder("0");
        else if(n == 9)
            sb = new StringBuilder("8");
        else {
            sb = new StringBuilder("72");
            for(int i = 0; i < n - 10; i++) 
                sb.append("0");
        }
        System.out.println(sb);
    }
}
