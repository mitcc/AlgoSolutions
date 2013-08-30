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
}
