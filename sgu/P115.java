/*
115. Calendar


time limit per test: 0.5 sec. 
memory limit per test: 4096 KB

First year of new millenium is gone away. In commemoration of it write a program 
that finds the name of the day of the week for any date in 2001.

Input

Input is a line with two positive integer numbers N and M, where N is a day number 
in month M. N and M is not more than 100.

Output

Write current number of the day of the week for given date (Monday ¨C number 1, ¡­ , 
Sunday ¨C number 7) or phrase ¡°Impossible¡± if such date does not exist.

Sample Input

 21 10
Sample Output

 7
 */
import java.util.*;

public class P115 {
/*    public static void day(int n, int m) {
        int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(n < 0 || n > month[m - 1] || m < 0 || m > 12) 
            System.out.println("Impossible");
        else {
            int diff = 21, now = n + 350;
            for(int i = 1; i <= 9; i++) 
                diff += month[i - 1];
            for(int i = 1; i < m; i++) 
                now += month[i - 1];
            System.out.println((now - diff + 6) % 7 + 1);
        }
    }
*/

    public static void day(int n, int m) {
        int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(n < 0 || n > month[m - 1] || m < 0 || m > 12) 
            System.out.println("Impossible");
        else {
            int now = n;
            for(int i = 1; i < m; i++) 
                now += month[i - 1];
            System.out.println((now + 6) % 7 + 1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        day(in.nextInt(), in.nextInt());
    }
}
