/*
1008. Elevator (20)

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
The highest building in our city has only one elevator. A request list is made
up with N positive numbers. The numbers denote at which floors the elevator
will stop, in specified order. It costs 6 seconds to move the elevator up one 
floor, and 4 seconds to move down one floor. The elevator will stay for 5 
seconds at each stop.

For a given request list, you are to compute the total time spent to fulfill 
the requests on the list. The elevator is on the 0th floor at the beginning 
and does not have to return to the ground floor when the requests are 
fulfilled.

Input Specification:

Each input file contains one test case. Each case contains a positive integer
N, followed by N positive numbers. All the numbers in the input are less than 
100.

Output Specification:

For each test case, print the total time on a single line.

Sample Input:
3 2 3 1
Sample Output:
41
 */

import java.util.*;

public class P1008 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0;
        int prev = 0;
        int next = 0;
        for (int i = 0; i < n; i++) {
            next = in.nextInt();
            if (next > prev) {
                sum += 6 * (next - prev) + 5;
            } else {
                sum += 4 * (prev - next) + 5;
            }
            prev = next;
        }
        System.out.println(sum);
    }

}
