/*
231. Prime Sum

time limit per test: 0.25 sec.
memory limit per test: 4096 KB
input: standard
output: standard



Find all pairs of prime numbers (A, B) such that A<=B and their sum is also a 
prime number and does not exceed N.

Input
The input of the problem consists of the only integer N (1<=N<=10^6).

Output
On the first line of the output file write the number of pairs meeting the 
requirements. Then output all pairs one per line (two primes separated by a 
space).

Sample test(s)

Input
4

Output
0
 * 
 */
import java.util.*;

public class P231 {
    public static boolean[] isPrime(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for(int i = 2; i * i <= n; i++) {
            if(prime[i]) {
                for(int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean[] list = isPrime(n);
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 3; i <= n - 2; i += 2) {
            if(list[i] && list[i + 2]) {
                cnt++;
                sb.append(2 + " " + i + '\n');
            }
        }
        System.out.println(cnt);
        System.out.print(sb);
    }
}
