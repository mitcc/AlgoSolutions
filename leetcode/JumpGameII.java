/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 * Each element in the array represents your maximum jump length at that position.

 * Your goal is to reach the last index in the minimum number of jumps.

 * For example:
 * Given array A = [2,3,1,1,4]

 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
package info.mitcc.leetcode;

public class JumpGameII {
	public int jump(int[] A) {
        int[] dp = new int[A.length];
        dp[0] = 0;
        for(int i = 1; i < A.length; i++) {
            for(int j = 0; j < i; j++) {
                if(j + A[j] >= i) {
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
            /* to avoid the test arrays can not jump to the last index. If returns 0 : NO; else : Yes
             * if(dp[i] == 0)
             * 	   break;
             */
        }
        return dp[A.length - 1];        
    }
	
	public static void main(String[] args) {
		int[] test = {0, 2, 1};
		System.out.println(new JumpGameII().jump(test));
	}
}