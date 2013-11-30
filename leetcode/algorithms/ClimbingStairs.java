/*
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can 
 * you climb to the top?
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2; i <= n; i++) 
            res[i] = res[i - 1] + res[i - 2];
        return res[n];
    }

/************************ updated 2013/11/20 ***********************/

    public int climbStairs(int n) {
        int result = 1;
        int a = 1;
        int b = 1;
        for (int i = 1; i < n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }
}
