/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 * Return the minimum cuts needed for a palindrome partitioning of s.

 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
package info.mitcc.leetcode;

import java.util.ArrayList;

public class PalindromePartitioningII {
	/*public int minCut(String s) {
		if(isPalindrome(s))
			return 0;
		int min = Integer.MAX_VALUE;
		ArrayList<ArrayList<String>> list = partition(s);
		for(int i = 0; i < list.size(); i++) 
			min = Math.min(min, list.get(i).size() - 1);
		return min;
    }
	
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
    }*/
	
	public boolean isPalindrome(String s) {
		return new StringBuilder(s).reverse().toString().equals(s);
	}
	
	public int minCut(String s) {
		if(isPalindrome(s))
			return 0;
		int n = s.length();
		int[][] c = new int[n][n];
		boolean[][] p = new boolean[n][n];
		int i, j, k, L;
		
		for(i = 0; i < n; i++) {
			p[i][i] = true;
			c[i][i] = 0;
		}
		
		for(L = 2; L <= n; L++) {
			for(i = 0; i < n - L + 1; i++) {
				j = i + L - 1;
				if(L == 2)
					p[i][j] = (s.charAt(i) == s.charAt(j));
				else
					p[i][j] = (s.charAt(i) == s.charAt(j)) && p[i + 1][j - 1];
				if(p[i][j] == true)
					c[i][j] = 0;
				else {
					c[i][j] = Integer.MAX_VALUE;
					for(k = i; k <= j - 1; k++)
						c[i][j] = Math.min(c[i][j], c[i][k] + c[k + 1][j] + 1);
				}
			}
		}
		return c[0][n - 1];
	}
	
	public static void main(String[] args) {
		System.out.println(new PalindromePartitioningII().minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}
}
