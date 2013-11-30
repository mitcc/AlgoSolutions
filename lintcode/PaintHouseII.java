/*
 * There are a row of n houses, each house can be painted with one of the k 
 * colors. The cost of painting each house with a certain color is different. 
 * You have to paint all the houses such that no two adjacent houses have the 
 * same color.

The cost of painting each house with a certain color is represented by a n x k 
cost matrix. For example, costs[0][0] is the cost of painting house 0 with 
color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... 
Find the minimum cost to paint all houses.

 Notice

All costs are positive integers.

Example
Given n = 3, k = 3, costs = [[14,2,11],[11,14,5],[14,3,10]] return 10

house 0 is color 2, house 1 is color 3, house 2 is color 2, 2 + 5 + 3 = 10

Challenge
Could you solve it in O(nk)?
 */
public class PaintHouseII {

    /**
     * @param costs n x k cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    // O(nk);
    public int minCostII(int[][] costs) {
        int prevMin = 0;
        int prevSecMin = 0;
        int prevMinIndex = -1;
        for (int i = 0; i < costs.length; ++i) {
            int curMin = Integer.MAX_VALUE;
            int curSecMin = Integer.MAX_VALUE;
            int curMinIndex = -1;
            for (int j = 0; j < costs[0].length; ++j) {
                costs[i][j] += (j != prevMinIndex ? prevMin : prevSecMin);
                if (costs[i][j] < curMin) {
                    curSecMin = curMin;
                    curMin = costs[i][j];
                    curMinIndex = j;
                } else if (costs[i][j] < curSecMin) {
                    curSecMin = costs[i][j];
                }
            }
            prevMin = curMin;
            prevSecMin = curSecMin;
            prevMinIndex = curMinIndex;
        }
        return prevMin;
    }

/*****************************************************************************/

    // O(n * k^2)
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        for (int i = 1; i < costs.length; ++i) {
            for (int j = 0; j < costs[0].length; ++j) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < costs[0].length; ++k) {
                    if (k == j) {
                        continue;
                    }
                    min = Math.min(min, costs[i - 1][k]);
                }
                costs[i][j] += min;
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < costs[0].length; ++i) {
            result = Math.min(result, costs[costs.length - 1][i]);
        }
        return result;
    }

}
