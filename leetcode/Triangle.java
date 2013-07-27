package info.mitcc.leetcode;

import java.util.ArrayList;

public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        int[][] dp = new int[row][];
        for(int i = 0; i < row; i++)
        	dp[i] = new int[i + 1];
        for(int i = 0; i < col; i++)
        	dp[row - 1][i] = triangle.get(row - 1).get(i);
        for(int i = row - 2; i >= 0; i--) {
        	for(int j = 0; j <= i; j++) {
        		dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
        	}
        }
        return dp[0][0];
    }
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> list1 = new ArrayList<Integer>(), list2 = new ArrayList<Integer>(), 
				list3 = new ArrayList<Integer>(), list4 = new ArrayList<Integer>();
		list1.add(2);
		list2.add(3);
		list2.add(4);
		list3.add(6);
		list3.add(5);
		list3.add(7);
		list4.add(4);
		list4.add(1);
		list4.add(8);
		list4.add(3);
		list.add(list1);
		list.add(list2);
		list.add(list3);
		list.add(list4);
		System.out.println(new Triangle().minimumTotal(list));
	}
}
