/*
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.

 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 * The number of ways decoding "12" is 2.
 */
package info.mitcc.leetcode;

public class DecodeWays {
  public int numDecodings(String s) {
        int len = s.length();
        if(len == 0 || s.charAt(0) == '0')
        	return 0;
        int[] ways = new int[len];
        ways[0] = 1;
        for(int i = 1; i < len; i++) {
        	if(s.charAt(i) == '0') {
        		if(s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') 
        			ways[i] = i == 1 ? 1 : ways[i - 2];
        		else
        			return 0;
        	} else {
        		ways[i] += ways[i - 1];
            	if(s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) - '0' <= 6) 
            		ways[i] += i < 3 ? 1 : ways[i - 2];
        	}
        }    
        return ways[len - 1];
    }
	
	public static void main(String[] args) {
		String s = "12121";
		System.out.println(new DecodeWays().numDecodings(s));
	}
}
