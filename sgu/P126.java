/*
126. Boxes


time limit per test: 0.25 sec. 
memory limit per test: 4096 KB

There are two boxes. There are A balls in the first box, and B balls in the 
second box (0 < A + B < 2147483648). It is possible to move balls from one box 
to another. From one box into another one should move as many balls as the other 
box already contains. You have to determine, whether it is possible to move all 
balls into one box.

Input

The first line contains two integers A and B, delimited by space.

Output

First line should contain the number N - the number of moves which are required 
to move all balls into one box, or -1 if it is impossible.

Sample Input

Sample Output

 2 6
Sample Output

 2
 * 
 */
import java.util.*;

public class P126 {
    public static int gcd(int a, int b) {
        while(b != 0) {
            int temp = a;
            a = b;
            b = temp % a;
        }
        return a;
    }

    public static int log2(int a) {
        int res = 0;
        while(a >= 2) {
            res++;
            a >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int res = 0; 
        if(a != 0 && b != 0) {
            int N = (a + b) / gcd(a, b);
            int n = log2(N);
            res = 1 << n == N ? n : -1;
        }
        System.out.println(res);
    }
}
