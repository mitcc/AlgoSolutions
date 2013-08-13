/*
 * Given a collection of numbers, return all possible permutations.

 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
package info.mitcc.leetcode;

import java.util.*;

public class Permutations {
  public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> item = new ArrayList<Integer>();
		item.add(num[0]);
		result.add(item);
		for(int i = 1; i < num.length; i++) {
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			for(int j = 0; j < result.size(); j++) {
				for(int k = 0; k < result.get(j).size() + 1; k++) {
					ArrayList<Integer> temp = new ArrayList<Integer>(result.get(j));
					temp.add(k, num[i]);
					list.add(temp);
				}
			}
			result = list;
		}
		return result;
    }
}
