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
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Calendar calendar = new GregorianCalendar(2001, m - 1, n);
        if(calendar.get(Calendar.YEAR) != 2001 || 
                calendar.get(Calendar.MONTH) != m - 1 || 
                calendar.get(Calendar.DAY_OF_MONTH) != n) 
            System.out.println("Impossible");
        else {
            int res = calendar.get(Calendar.DAY_OF_WEEK);
            res = res == 1 ? 7 : res - 1;
            System.out.println(res);
        }
    }
}
