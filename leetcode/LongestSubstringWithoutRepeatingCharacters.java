/*
 * Given a string, find the length of the longest substring without repeating characters. For example, 
 * the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For 
 * "bbbbb" the longest substring is "b", with the length of 1.
 */
 
package info.mitcc.leetcode;

import java.util.ArrayList;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
/*		int len = s.length();
		int max = 0;
		ArrayList<Character> list ;
		for(int i = 0; i < len; i++) {
			list = new ArrayList<Character>();
			int j;
			for(j = i; j < len; j++) {
				char c = s.charAt(j);
				if(list.contains(c))
					break;
				else
					list.add(c);
			}
			max = Math.max(max, j - i);
		}
		return max;*/
		
		int len = s.length();
		int max = 0;
		boolean[] occur = new boolean[256];
		int i = 0, j = 0; 
		while(j < len) {
			if(occur[s.charAt(j)]) {
				max = Math.max(max, j - i);
				while(s.charAt(i) != s.charAt(j)) {
					occur[s.charAt(i)] = false;
					i++;
				}
				i++;
				j++;
			} else {
				occur[s.charAt(j)] = true;
				j++;
			}
		}
		return Math.max(max, len - i);
    }
	public static void main(String[] args) {
		String s = "abcdefghglmknijpq";
		System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));
	}
}
