/*
1001. A+B Format (20)

时间限制
400 ms
内存限制
32000 kB
代码长度限制
16000 B
判题程序
Standard
作者
CHEN, Yue
Calculate a + b and output the sum in standard format -- that is, the digits
must be separated into groups of three by commas (unless there are less than 
four digits).

Input

Each input file contains one test case. Each case contains a pair of integers 
a and b where -1000000 <= a, b <= 1000000. The numbers are separated by a 
space.

Output

For each test case, you should output the sum of a and b in one line. The sum 
must be written in the standard format.

Sample Input
-1000000 9
Sample Output
-999,991
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num = in.nextInt() + in.nextInt() + "";
        String res = "";
        int length = num.length();
        for (int i = 1; i < length / 3 + 1; i++) {
            res = "," + num.substring(length - 3 * i, length + 3 - 3 * i) + res;
            num = num.substring(0, length - 3 * i);
        }
        res = num + res;
        if (res.length() > 1 && res.charAt(0) == '-' && res.charAt(1) == ',')
        	res = res.substring(0, 1) + res.substring(2, res.length());
        if (res.length() > 0 && res.charAt(0) == ',') 
        	res = res.substring(1, res.length());
        System.out.println(res);
    }

}
