/*
375. Amplifiers

Time limit per test: 1.5 second(s)
Memory limit: 65536 kilobytes
input: standard
output: standard



Scientist Shurik needs voltage that is N times more that the standard voltage 
in the wall outlet for power supply for his time machine. The standard voltage 
is equal to one Bervolt. Shurik decided to use voltage amplifiers. In the nearby 
shop he found the amplifiers of two types, the first type creates voltage 2X-1 
Bervolt from X Bervolt, the second one creates voltage 2X+1 Bervolt from X 
Bervolt. The number of amplifiers in the shop is unlimited. Shurik wants to 
build a sequence of amplifiers from the outlet to the time machine. Of course 
he wants to minimize the number of amplifiers. Help him.

Input
A single integer 1 ¡Ü N¡Ü 2¡¤ 109.

Output
If it is possible to make such scheme, output in the first line the minimal 
possible number of amplifiers. The second line in this case is to contain the 
sequence of amplifiers from the outlet to the time machine. Use number 1 for 
the first-type amplifiers and number 2 for second-type amplifiers.

If there is no solution, output "No solution" (without quotes).

Example(s)
sample input
sample output
5
2
2 1
 * 
 */
import java.util.*;

public class P375 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n % 2 == 0) 
            System.out.println("No solution");
        else {
            String res = "";
            while(n > 1) {
                res += (n / 2 % 2 == 1) ? "2" : "1";
                n = (n / 2 % 2 == 1) ? n / 2 : (n / 2 + 1);
            }
            System.out.println(res.length());
            for(int i = res.length() - 1; i >= 0; i--)
                System.out.print(res.charAt(i) + " ");
        }
    }
}
