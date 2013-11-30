/*
 * You are a professional robber planning to rob houses 
 * along a street. Each house has a certain amount of money 
 * stashed, the only constraint stopping you from robbing 
 * each of them is that adjacent houses have security 
 * system connected and it will automatically contact the 
 * police if two adjacent houses were broken into on the 
 * same night.

Given a list of non-negative integers representing the 
amount of money of each house, determine the maximum amount 
of money you can rob tonight without alerting the police.

Example
Given [3, 8, 4], return 8.

Challenge
O(n) time and O(1) memory.
 */
public class HouseRobber {

    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        long prev = 0;
        long cur = 0;
        for (int a : A) {
            long tmp = cur;
            cur = Math.max(prev + a, cur);
            prev = tmp;
        }
        return cur;
    }

}
