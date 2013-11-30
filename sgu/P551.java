/*
551. Preparing Problem

Time limit per test: 1 second(s)
Memory limit: 262144 kilobytes
input: standard
output: standard



It is not easy to prepare a problem for a programming contest. Petya and Vasya 
decided that problem "A+B" needs at least n distinct solutions to be written. 
It doesn't matter how many solutions each of them will write, they need to write 
at least n solutions in total. We know that Petya needs t1 units of time to write 
a solution, and Vasya needs t2 units of time. They start to work simultaneously 
at time 0. Thus, for example, Petya finishes writing his first solution at time 
t1, his second solution at 2 ¡¤ t1 and so on.

Petya and Vasya are working by the same algorithm. Each time Petya (Vasya) 
finishes writing a solution, he checks on how many solutions have already been 
written up to the current time moment t. Ready solutions are the solutions that
have been fully written by this time. The solutions that were fully finished 
exactly at time t are also considered ready. If the number of such solutions is 
strictly less than n, then Petya (Vasya) starts writing the next solution. If a 
member of the jury began working on a problem, he doesn't stop working under any 
circumstances, and he will surely finish it.

Petya and Vasya realize that if they act on this algorithm, they will not 
necessarily write exactly n solutions in total. Maybe they'll write more solutions.

Considering that Petya and Vasya work non-stop, find, how many solutions they 
wrote in total and the moment when the latest solution was finished. The latest 
solution is one which was finished last.

Input
The only input line contains three integers n, t1 and t2 (1 ¡Ü n, t1, t2 ¡Ü 5000).

Output
Print two integers ¡ª m and f, where m is the number of written solutions, and f 
is the moment when the last solution was finished.

Example(s)
sample input
sample output
5 2 3
5 6

sample input
sample output
5 2 4
6 8

sample input
sample output
3 30 50
4 100



Note
In the first sample Petya finished his solutions at time 2, 4 and 6, and Vasya 
¡ª at time 3 and 6. They finished writing their last solutions simultaneously, 
at time 6, and at this exact moment they already had the total of 5 written 
solutions and stopped working.
 * 
 */
import java.util.*;

public class P551 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t1 = in.nextInt();
        int t2 = in.nextInt();
        int cnt = 0;
        int s1 = 0;
        int s2 = 0;
        while(cnt < n) {
            if(s1 == s2) {
                s1 += t1;
                s2 += t2;
            }
            else if(s1 < s2)
                s1 += t1;
            else
                s2 += t2;
            cnt += s1 == s2 ? 2 : 1;
        }   
        cnt += s1 == s2 ? 0 : 1;
        System.out.println(cnt + " " + Math.max(s1, s2));   
    }
}
