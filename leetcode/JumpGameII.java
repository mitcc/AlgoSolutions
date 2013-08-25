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
}
