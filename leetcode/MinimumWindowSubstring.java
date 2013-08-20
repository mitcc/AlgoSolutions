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
		int sLen = S.length();
		int tLen = T.length();
		int count = 0;
		int minWindowLen = Integer.MAX_VALUE;	
		int[] hasFound = new int[256];
		int[] needToFound = new int[256];
		Arrays.fill(hasFound, 0);
		Arrays.fill(needToFound, 0);
		for(int i = 0; i < tLen; i++)
			needToFound[T.charAt(i)]++;
		
		for(int begin = 0, end = 0; end < sLen; end++) {
			if(needToFound[S.charAt(end)] == 0)
				continue;
			hasFound[S.charAt(end)]++;
			if(hasFound[S.charAt(end)] <= needToFound[S.charAt(end)])
				count++;
			
			if(count == tLen) {
				while(needToFound[S.charAt(begin)] == 0 || 
						hasFound[S.charAt(begin)] > needToFound[S.charAt(begin)]) {
					if(hasFound[S.charAt(begin)] > needToFound[S.charAt(begin)])
						hasFound[S.charAt(begin)]--;
					begin++;
				}
				int windowLen = end - begin + 1;
				if(windowLen < minWindowLen) {
					minWindowLen = windowLen;
					result = S.substring(begin, end + 1);
				}
			}
		}
		return result;
	}
}
