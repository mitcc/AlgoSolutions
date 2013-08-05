package info.mitcc.leetcode;

import java.util.*;

public class ThreeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < num.length - 2; i++) {
        	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        	for(int j = i + 1; j < num.length; j++) {
        		if(map.containsKey(num[j])) {
        			int index = map.get(num[j]);
        			if(index < j) {
        				ArrayList<Integer> list = new ArrayList<Integer>();
        				list.add(num[i]);
        				list.add(num[index]);
        				list.add(num[j]); 
        				Collections.sort(list);
        				if(!result.contains(list)) 
        					result.add(list);
        			}
        		}
        		if(!map.containsKey(num[j]))
        			map.put(0 - num[i] - num[j], j);
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[] s = {-2, 0, 1, 1, 2};
		System.out.println(new ThreeSum().threeSum(s));
	}
}