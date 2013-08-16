/*
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.

 * Note:

 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,2], a solution is:

 * [
 *  [2],
 *  [1],
 *  [1,2,2],
 *  [2,2],
 *  [1,2],
 *  []
 * ]
 */
package info.mitcc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SubsetsII {
	public String getBinary(int num, int len) {
		String str = Integer.toBinaryString(num);
		String s = "";
		if(str.length() < len)
			for(int i = 0; i < len - str.length(); i++)
				s += "0";
		s += str;
		return s;
	}
	
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		Arrays.sort(num);
		HashSet<ArrayList<Integer>> list = new HashSet<ArrayList<Integer>>();
		int len = num.length;
		for(int i = 0; i < (1 << len); i++) {
			String s = getBinary(i, len);
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int j = 0; j < len; j++)
				if(s.charAt(j) == '1')
					temp.add(num[j]);
			list.add(temp);
		}
        return new ArrayList<ArrayList<Integer>>(list);
    }
	
	public static void main(String[] args) {
		int[] num = {1, 2, 2};
		System.out.println(new SubsetsII().subsetsWithDup(num));
	}
}
