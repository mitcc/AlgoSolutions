/*
302. BHTML 1.0

Time limit per test: 0.25 second(s)
Memory limit: 65536 kilobytes
input: standard
output: standard



The hypertext markup language BHTML 1.0 has only two paired tags. They are UP 
</UP> and DOWN </DOWN>. The UP </UP> tag capitalizes all letters inside its body 
(between an open tag and a close one), and DOWN </DOWN> makes all inside the 
body letters lowercase. You are given the text consisting of latin letters and 
tags. Your task is to write the text right as it will be shown in the Bernet 
Explorer browser window. Tags in the text are arranged correctly, i.e. they form 
correct bracket sequence. If a letter lays inside several tags, its case is 
defined by the most inner tag.

Input
The input contains the string S with the text. The length of the string is a 
natural number not exceeding 1000. Tags are always written in uppercase.

Output
Write to the output text after the processing.

Example(s)
sample input                                            sample output
Thi<UP>sIs<DOWN>EaSY</DOWN>Pr<UP>O</UP>ble</UP>m        ThiSISeasyPROBLEm 
 * 
 */
import java.util.*;

public class P302 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String res = "";
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<' && s.charAt(i + 1) == 'U') {
                stack.push('U');
                i += 3;
            } else if (s.charAt(i) == '<' && s.charAt(i + 1) == 'D') {
                stack.push('D');
                i += 5;
            } else if (s.charAt(i) == '<' && s.charAt(i + 1) == '/' 
                    && s.charAt(i + 2) == 'U') {
                stack.pop();
                i += 4;
            } else if (s.charAt(i) == '<' && s.charAt(i + 1) == '/' 
                    && s.charAt(i + 2) == 'D') {
                stack.pop();
                i += 6;
            } else if (!stack.isEmpty() && stack.peek() == 'U' 
                    && s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                res += (char) (s.charAt(i) - 32);
            } else if (!stack.isEmpty() && stack.peek() == 'D' 
                    && s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                res += (char) (s.charAt(i) + 32);
            } else {
                res += s.charAt(i);
            }
        }
        System.out.println(res);
    }
}
