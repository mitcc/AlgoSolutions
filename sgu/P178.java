/*
178. Golden chain

time limit per test: 0.25 sec.
memory limit per test: 4096 KB
input: standard
output: standard



Peter arrived to the city and stayed in the hotel. He has no money but few day's 
later (maximum N days) he will receive a lot of money. And so he has a golden 
chain with N links. Peter must pay one link everyday, but he can pay more and 
take change by some of his links paid before. 
When he receives money he will get his chain out of pawn. Peter likes his chain 
and he wants to break minimal number of links. Help him! 
For example, if N=5, he must break one link (the second). After it his chain 
will consist of 3 parts with lengths 1, 1 and 3. 
At the first day he will pay one link, at the second - one link too. Now he have 
one part consists of three connected links. At the third day he will pay 3-linked 
part and take two separated links (as change) back. On the fourth and fifth day 
he will pay one link. 
You may assume that Peter can choose the way to get change.

Input
Input contains one integer number N (1<=N<=10^16).

Output
In output file you must write one integer number (number of the broken links).

Sample test(s)

Input
9

Output
2
 * 
 */
import java.util.*;

public class P178 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        int res = 0;
        while((res + 1) * (1L << (res + 1)) - 1 < n) {
            res++;
        }
        System.out.println(res);
    }
}
