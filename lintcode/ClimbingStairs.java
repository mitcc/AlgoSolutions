/*
 * You are climbing a stair case. It takes n steps to 
 * reach to the top.

Each time you can either climb 1 or 2 steps. In how 
[<0;82;27Mmany distinct ways can you climb to the top?

Example
Given an example n=3 , 1+1+1=2+1=1+2=3

return 3
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        int a = 1;
        int b = 1;
        for (int i = 1; i <= n; ++i) {
            b += a;
            a = b - a;
        }
        return a;
    }

}
