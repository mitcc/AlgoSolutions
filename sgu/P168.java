/*
168. Matrix

time limit per test: 0.5 sec.
memory limit per test: 16000 KB
input: standard
output: standard



You are given N*M matrix A. You are to find such matrix B, that B[i,j]= 
min{ A[x,y] : (y>=j) and (x>=i+j-y) }

Input
On the first line of the input there are two integer numbers, N and M (1<=N,
M<=1000). Then matrix A follows: next N lines contains M integers each (not 
greater than 32000 by absolute value). The j-th number on then i-th of this 
lines is A[i,j].

Output
Write matrix B in the same format as matrix A, but without N and M.

Sample test(s)

Input
3 3 
1 2 3 
4 5 6 
7 8 9

Output
1 2 3 
2 3 6 
3 6 9
 * 
 */
import java.io.*;

public class P168 {
    public static int nextInt() throws IOException {
        int ch = -1;
        do {
            ch = System.in.read();
        } while (Character.isWhitespace(ch));
        boolean negative = (ch == '-');
        if(negative)
            ch = System.in.read();
        int res = 0;
        while (Character.isDigit(ch)) {
            res *= 10;
            res += Character.digit(ch, 10);
            ch = System.in.read();
        }
        return negative ? -res : res;
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int m = nextInt();
        int[][] b = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b[i][j] = nextInt();
                if(i >= 1 && j <= m - 2 && b[i][j] > b[i - 1][j + 1])
                    b[i][j] = b[i - 1][j + 1];
            } 
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j <= m - 2 && b[i][j] > b[i][j + 1])
                    b[i][j] = b[i][j + 1];
                else if (i <= n - 2 && b[i][j] > b[i + 1][j])
                    b[i][j] = b[i + 1][j];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(b[i][j] + " ");
            }
            sb.setCharAt(sb.length() - 1, '\n');
        }
        System.out.print(sb);
    }
}
