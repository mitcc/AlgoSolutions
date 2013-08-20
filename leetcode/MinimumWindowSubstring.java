/*
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"

 * Minimum window is "BANC".

 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string "".

 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
package info.mitcc.leetcode;

import java.util.*;

public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
        String result = "";
        HashSet<Character> setT = charSet(T);
        int i = 0, j = S.length() - 1;
        HashSet<Character> temp = charSet(S);
        while(temp.containsAll(setT)) {
        	
        }
        
        
        
        return result;
    }
	
	public HashSet<Character> charSet(String s) {
		HashSet<Character> set = new HashSet<Character>();
		for(int i = 0; i < s.length(); i++)
			set.add(s.charAt(i));
		return set;
	}
}
