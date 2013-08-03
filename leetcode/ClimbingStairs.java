/*
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
package info.mitcc.leetcode;

public class ClimbingStairs {
	public int climbStairs(int n) {
        int[] sum = new int[n + 1];
    	sum[0] = 1;
		for(int i = 1; i <= n; i++) {
			sum[i] = sum[i - 1];
			if(i >= 2)
				sum[i] += sum[i - 2];
		}
		return sum[n];
    }
}
