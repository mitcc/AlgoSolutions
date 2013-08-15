/*
 * Given a collection of numbers, return all possible permutations.

 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
package info.mitcc.leetcode;

import java.util.*;

public class PermutationsII {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> item = new ArrayList<Integer>();
		HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
		int len = num.length;
		for(int i = 0; i < len; i++)
			item.add(num[i]);
		result.add(item);
		
		int size = 1;
		for(int i = 0; i < len; i++) {
			size = result.size();
			for(int j = 0; j < size; j++) {
				for(int k = i + 1; k < len; k++) {
					ArrayList<Integer> temp = new ArrayList<Integer>(result.get(j));
					int t = temp.get(i);
					if(t == temp.get(k)) {
						continue;
					}
					temp.set(i, temp.get(k));
					temp.set(k, t);
					if(hashSet.add(temp))
						result.add(temp);
				}
			}
		}
		return result;
    }

	public static void main(String[] args) {
		int[] num = {1, 1, 3};
		System.out.println(new PermutationsII().permute(num));
	}
}
