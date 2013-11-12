/*

105. Div 3


time limit per test: 0.5 sec. 
memory limit per test: 4096 KB

There is sequence 1, 12, 123, 1234, ..., 12345678910, ... . Given first N elements of 
that sequence. You must determine amount of numbers in it that are divisible by 3.

Input

Input contains N (1<=N<=231 - 1).

Output

Write answer to the output.

Sample Input

 4
Sample Output

 2
 */
import java.util.*;

public class P105 {
    public static int div3Sum(int n) {
       return n / 3 * 2 + (n % 3 == 2 ? 1 : 0); 
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(div3Sum(in.nextInt()));
    }
}
