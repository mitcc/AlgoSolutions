/*
404. Fortune-telling with camomile

Time limit per test: 0.25 second(s)
Memory limit: 65536 kilobytes
input: standard
output: standard



Masha loves Petya. The following question gives her no rest: does Petya love her 
too? The best way to find this out is a fortune-telling. There are plenty ways 
of fortune predicting, but Masha prefers fortune-telling with camomile more than
others. It's rules are simple. You should take camomile into the right hand and 
start picking petals one by one. After each petal you should pronounce one phrase 
from the predefined list. Such phrases like "loves", "doesn't love", "loves 
sincerely", "doubts", "wants to date", "laughs" are usually used. Phrases are 
pronounced from the first to the last. The list of phrases is cyclic, so after 
the last phrase you should pronounce the first one. The phrase that you pronounce 
after the last petal will be an answer.

Since Masha doesn't want to go to the forest and look for camomiles, she asks 
you to write the program which will simulate the process.

Input
First line of the input file contains two integer numbers N and M (1 ¡Ü N ¡Ü 100, 
1 ¡Ü M ¡Ü 100), the number of petals and the number of phrases. Each of the 
following M lines contains one phrase. Phrases consist only of latin letters and 
their lengths are between 1 and 100. 

Output
Output the resulting phrase.

Example(s)
sample input
sample output
6 4
loves
doesnt
sincerely
doubts
doesnt

sample input
sample output
9 3
loves
doesnt
hates
hates
 * 
 */
import java.util.*;

public class P404 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String res = null;
        for(int i = 0; i < m; i++) {
            String s = in.next();
            if(i == (n - 1) % m)
                res = s;
        }
        System.out.println(res);
    }
}
