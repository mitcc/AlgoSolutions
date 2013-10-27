/*
100. A+B

time limit per test: 0.5 sec. 
memory limit per test: 65536 KB

Read integers A and B from input file and write their sum in output file.

Input

Input file contains A and B (0<A,B<10001).

Output

Write answer in output file.

Sample Input

 5 3
Sample Output

 8
 */
import java.util.*;

public class P100 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(in.nextInt() + in.nextInt());
    }
}
