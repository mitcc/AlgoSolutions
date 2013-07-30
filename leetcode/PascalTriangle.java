package info.mitcc.leetcode;

import java.util.ArrayList;

public class PascalTriangle {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(numRows <= 0)
        	return result;
        ArrayList<Integer> start = new ArrayList<Integer>();
        start.add(1);
        result.add(start);
        for(int i = 1; i < numRows; i++) {
        	ArrayList<Integer> pre = result.get(i - 1);
        	ArrayList<Integer> next = new ArrayList<Integer>();
        	next.add(1);
        	for(int j = 1; j < i; j++) {
        		int temp = pre.get(j - 1) + pre.get(j);
        		next.add(temp);
        	}
        	next.add(1);
        	result.add(next);
        }
        return result;
    }
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> list = new PascalTriangle().generate(5);
		System.out.println(list);
	}
}
