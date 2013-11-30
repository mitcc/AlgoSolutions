/*
135. Drawing Lines


time limit per test: 0.25 sec. 
memory limit per test: 4096 KB

Little Johnny likes to draw a lot. A few days ago he painted lots of straight 
lines on his sheet of paper. Then he counted in how many zones the sheet of 
paper was split by these lines. He noticed that this number is not always the 
same. For instance, if he draws 2 lines, the sheet of paper could be split into 
4, 3 or even 2 (if the lines are identical) zones. Since he is a very curious 
kid, he would like to know which is the maximum number of zones into which he 
can split the sheet of paper, if he draws N lines. The sheet of paper is to be 
considered a very large (=infinite) rectangle.

Input

The input file will contain an integer number: N (0<=N<=65535).

Output

You should output one integer: the maximum number of zones into which the sheet 
of paper can be split if Johnny draws N lines.

Sample Input #1

 0
Sample Output #1

 1
Sample Input #2

 1
Sample Output #2

 2
 * 
 */
import java.util.Scanner;

public class P135 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println((long) n * (n + 1) / 2 + 1);
    }
}
