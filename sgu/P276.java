/*
276. Andrew's Troubles

time limit per test: 0.25 sec.
memory limit per test: 65536 KB
input: standard
output: standard



Famous Berland ACM-ICPC team Anisovka consists of three programmers: Andrew, 
Michael and Ilya. A long time ago, during the first few months the team was 
founded, Andrew was very often late to the trainings and contests. To stimulate 
Andrew to be more punctual, Ilya and Andrew decided to introduce a new rule for 
team participants. If somebody is late (i.e. comes at least one second after 
appointed time) he owes a cup of tea to other team members. If he is late for 5 
minutes, he owes two cups of tea. If he is late for 15 minutes, he owes three 
cups of tea. And if he is late for 30 minutes or more, he owes 4 cups of tea. 
The training starts at the time S (counted in seconds, from some predefined 
moment of time) and Andrew comes at the time P (also in seconds, counted from 
the same moment of time). 
Your task is to find how many cups of tea Andrew owes. 

Input
The input file contains single line with integer numbers S and P (0 <= S,P <= 10^4). 

Output
Write to the output file the number of cups Andrew owes. 

Sample test(s)

Input
Test #1 
10 10 

Test #2 
10 11 

Test #3 
0 300 

Output
Test #1 
0 

Test #2 
1 

Test #3 
2 
 * 
 */
import java.util.Scanner;

public class P276 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int p = in.nextInt();
        if(p <= s)
            System.out.println(0);
        else if(p - s > 0 && p - s < 300)
            System.out.println(1);
        else if(p - s >= 300 && p - s < 900)
            System.out.println(2);
        else if(p - s >= 900 && p - s < 1800)
            System.out.println(3);
        else 
            System.out.println(4);
    }
}
