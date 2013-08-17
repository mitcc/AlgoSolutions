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
/*	public String getBinary(int num, int len) {
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
    }*/
	
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result.add(new ArrayList<Integer>());
		int preSize = 0;
		for(int i = 0; i < num.length; i++) {
			if(i > 0 && num[i] == num[i - 1]) {
				int newSize = result.size();
				for(int j = preSize; j < newSize; j++) {
					ArrayList<Integer> pre = new ArrayList<Integer>(result.get(j));
					pre.add(num[i]);
					result.add(pre);
				}
				preSize = newSize;
			} else {
				int size = result.size();
				preSize = size;
				for(int j = 0; j < size; j++) {
					ArrayList<Integer> pre = new ArrayList<Integer>(result.get(j));
					pre.add(num[i]);
					result.add(pre);
				}
			}
		}
		return result;
    }
	
	public static void main(String[] args) {
		int[] num = {1, 2, 2, 2, 3};
		System.out.println(new SubsetsII().subsetsWithDup(num));
	}
}
