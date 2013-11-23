/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 * Each element in the array represents your maximum jump length at that position.

 * Your goal is to reach the last index in the minimum number of jumps.

 * For example:
 * Given array A = [2,3,1,1,4]

 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 
 * 0 to 1, then 3 steps to the last index.)
 */

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
        }
        return dp[A.length - 1];        
    }

/*************************  updated 2013/11/23  ************************/

    public int jump(int[] A) {
        int cnt = 0, index = 0, maxIndex = 0;
        for(int i = 0; i < A.length; i++) {
            if(index >= A.length - 1)
                return cnt;
            maxIndex = Math.max(maxIndex, i + A[i]);
            if(i >= index) {
                cnt++;
                index = maxIndex;
            }
        }
        return cnt;
    }
}
