/* 
249. Matrix

time limit per test: 0.5 sec.
memory limit per test: 65536 KB
input: standard
output: standard



It is necessary to arrange numbers from 0 to 2^(N+M)-1 in the matrix with 2^N 
rows and 2^M columns. Moreover, numbers occupying two adjacent cells must differ 
only in single bit in binary notation. Cells are adjacent if they have common 
side. Matrix is cyclic, i.e. for each row the leftmost and rightmost matrix 
cells are considered to be adjacent (the topmost and the bottommost matrix cells 
are also adjacent).

Input
The first line of input contains two integers N and M (0<N,M; N+M<=20).

Output
Output file must contain the required matrix in a form of 2^N lines of 2^M 
integers each.

Sample test(s)

Input
1 1

Output
0 2 
1 3
 * 
 */
import java.util.*;

public class P249 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 1 << n; i++) {
            for(int j = 0; j < 1 << m; j++) {
                sb.append(((i ^ (i >> 1)) << m) ^ (j ^ (j >> 1)));
                sb.append(' ');
            }
            sb.setCharAt(sb.length() - 1, '\n');
        }
        System.out.print(sb);
    }
}
