/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 * Return all possible palindrome partitioning of s.

 * For example, given s = "aab",
 * Return

 *  [
 *    ["aa","b"],
 *    ["a","a","b"]
 *  ]
 */
package info.mitcc.leetcode;

import java.util.*;

public class PalindromePartitioning {
	public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> temp = null;
        if(s.length() == 1) {
        	temp = new ArrayList<String>();
        	temp.add(s);
        	result.add(temp);
        	return result;
        }
        if(isPalindrome(s)) {
        	temp = new ArrayList<String>();
        	temp.add(s);
        	result.add(temp);
        }
        for(int i = 1; i < s.length(); i++) {
        	if(isPalindrome(s.substring(0, i))) {
        		ArrayList<ArrayList<String>> list = partition(s.substring(i, s.length()));
        		temp = new ArrayList<String>();
        		int size = list.size();
        		for(int j = 0; j < size; j++) {
        			temp = list.get(j);
        			temp.add(0, s.substring(0, i));
        			result.add(temp);
        		}
        	}	
        }       
        return result;
    }
	
	public boolean isPalindrome(String s) {
		return new StringBuilder(s).reverse().toString().equals(s);
	}
	
	public static void main(String[] args) {
		System.out.println(new PalindromePartitioning().partition("abb"));
	}
}
