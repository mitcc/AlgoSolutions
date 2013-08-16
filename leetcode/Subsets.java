/*
 * Given a set of distinct integers, S, return all possible subsets.

 * Note:

 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:

 * [
 *  [3],
 *  [1],
 *  [2],
 *  [1,2,3],
 *  [1,3],
 *  [2,3],
 *  [1,2],
 *  []
 * ]
 */
package info.mitcc.leetcode;

import java.util.*;

public class Subsets {
/*	public String getBinary(int num, int len) {
		String str = Integer.toBinaryString(num);
		String s = "";
		if(str.length() < len) 
			for(int i = 0; i < len - str.length(); i++) 
				s += "0";
		s += str;
		return s;
	}
	
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int len = S.length;
		for(int i = 0; i < (1 << len); i++) {
			String s = getBinary(i, len);
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int j = 0; j < len; j++)
				if(s.charAt(j) == '1')
					temp.add(S[j]);
			result.add(temp);
		}
		return result;
	}*/
	
/*	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result.add(new ArrayList<Integer>());
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(S[0]);
		result.add(list);
		for(int i = 1; i < S.length; i++) {
			int size = result.size();
			for(int j = 0; j < size; j++) {
				ArrayList<Integer> pre = new ArrayList<Integer>(result.get(j));
				pre.add(S[i]);
				result.add(pre);
			}
		}
		return result;
	}*/
	
	ArrayList<ArrayList<Integer>> result = null;
	
	public void dfs(int[] S, int pos, ArrayList<Integer> temp) {
		for(int i = pos; i < S.length; i++) {
			temp.add(S[i]);
			result.add(new ArrayList<Integer>(temp));
			dfs(S, i + 1, temp);
			temp.remove(temp.size() - 1);
		}
	}

	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		Arrays.sort(S);
		result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		result.add(temp);
		dfs(S, 0, temp);
		return result;
	}
	
	public static void main(String[] args) {
		int[] S = {1, 2, 3};
		System.out.println(new Subsets().subsets(S));
	}
}
