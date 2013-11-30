/*
296. Sasha vs. Kate

Time limit per test: 0.5 second(s)
Memory limit: 65536 kilobytes
input: standard
output: standard



During the regular Mars's World Finals Subregional Programming Contest a boy 
Sasha lost N "Mars" bars of chocolate to a girl Kate. But for two years already 
Sasha does not hurry to pay his debt. And now Sasha and Kate decided that Sasha 
will give Kate P chocolate bars, where number P can be obtained from the number 
N by removing exactly K decimal digits. Sasha generously let Kate to choose 
digits to be removed. Your task is to find out how many bars Sasha will give 
Kate. Of course Kate will choose K digits from the number N in such a way that 
the resulting number P would be maximal.

Input
The first line of the input file contains two integer numbers N and K (1¡Ü N¡Ü 
101000; 0¡Ü K¡Ü 999). Number K is strictly less than the number of digits in 
N. N will not have any leading zeros.

Output
Output the unknown P.

Example(s)
sample input       sample output
1992 2             99

sample input       sample output
1000 2             10
 * 
 */
import java.util.*;

public class P296 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.next();
        int k = in.nextInt();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n.length(); j++) {
                if (j < n.length() - 1 && n.charAt(j + 1) > n.charAt(j)) {
                    n = n.substring(0, j) + n.substring(j + 1);
                    break;
                }
                if (j == n.length() - 1)
                    n = n.substring(0, j);
            }
        }
        System.out.println(n);
    }
}
