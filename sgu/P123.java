/*
123. The sum


time limit per test: 0.5 sec. 
memory limit per test: 4096 KB

The Fibonacci sequence of numbers is known: F1 = 1; F2 = 1; Fn+1 = Fn + Fn-1, for n>1. 
You have to find S - the sum of the first K Fibonacci numbers.

Input

First line contains natural number K (0<K<41).

Output

First line should contain number S.

Sample Input

 5
Sample Output

 12
 */
import java.util.*;

public class P123 {
    public static int sum(int n) {
        if(n == 1 || n == 2) 
            return n;
        int total = 2, prev = 1, next = 1;
        for(int i = 3; i <= n; i++) {
            total += prev + next;
            next += prev;
            prev = next - prev;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(sum(in.nextInt()));
    }
}
