/*
 * Given a triangle, find the minimum path sum from top to bottom. Each step 
 * you may move to adjacent numbers on the row below.

 * For example, given the following triangle

 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n 
 * is the total number of rows in the triangle.
 */
import java.util.*;

public class Triangle {

/**************************** updated 20141017 *******************************/

    public int minimumTotal(List<List<Integer>> triangle) {
        int xLen = triangle.size();
        int[] dp = new int[triangle.get(xLen - 1).size()];
        for (int i = xLen - 1; i >= 0; i--) {
            int yLen = triangle.get(i).size();
            for (int j = 0; j < yLen; j++) {
                dp[j] = (i == xLen - 1 ? 0 : Math.min(dp[j], dp[j + 1]))
                    + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
