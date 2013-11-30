/*
460. Plural Form of Nouns

Time limit per test: 0.25 second(s)
Memory limit: 65536 kilobytes
input: standard
output: standard

In the English language, nouns are inflected by grammatical number — that is 
singular or plural. In this problem we use a simple model of constructing plural 
from a singular form. This model doesn't always make English plural forms 
correctly, but it works in most cases. Forget about the real rules you know 
while solving the problem and use the statement as a formal document.

You are given several nouns in a singular form and your program should translate 
them into plural form using the following rules:


If a singular noun ends with ch, x, s, o the plural is formed by adding es. For 
example, witch -> witches, tomato -> tomatoes.

If a singular noun ends with f or fe, the plural form ends with ves. For example, 
leaf -> leaves, knife -> knives. Pay attention to the letter f becoming v.

Nouns ending with y change the ending to ies in plural. For example, family -> 
families.

In all other cases plural is formed by adding s. For example, book -> books.


Input
The first line of input contains a single positive integer n (1 ≤ n ≤ 10) — 
the number of words to be processed. The following n lines contain one word each. 
A word consists from 2 to 25 lowercase Latin letters. It is not guaranteed that 
the given words are real English words from vocabulary.

Output
Print n given words in their plural forms on separate lines. Keep the words in 
the same order as they are given in the input. 

Example(s)
sample input
sample output
3
contest
hero
lady
s
contests
heroes
ladies
 * 
 */
import java.util.*;

public class P460 {
/*  public static String plural(String word) {
        int len = word.length();
        if(word.substring(len - 2, len).equals("ch") || 
                word.charAt(len - 1) == 'x' || word.charAt(len - 1) == 's' || 
                word.charAt(len - 1) == 'o') 
            word += "es";
        else if(word.charAt(len - 1) == 'f' || 
                word.substring(len - 2, len).equals("fe"))
            word = word.substring(0, 
                    (word.charAt(len - 1) == 'f') ? len - 1 : len - 2) + "ves";
        else if(word.charAt(len - 1) == 'y') 
            word = word.substring(0, len - 1) + "ies";
        else
            word += "s";
        return word;
    }*/

    public static String plural(String word) {
        String[] from = {"ch", "x", "s", "o", "f", "fe", "y", ""};
        String[] to = {"ches", "xes", "ses", "oes", "ves", "ves", "ies", "s"};
        for(int i = 0; i < from.length; i++) {
            if(word.endsWith(from[i])) {
                word = word.substring(0, word.length() - from[i].length()) + to[i];
                break;
            }
        }
        return word;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n > 0) {
            n--;
            System.out.println(plural(in.next()));
        }
    }
}
