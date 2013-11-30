/*
 * Given a triangle, find the minimum path sum from 
 * top to bottom. Each step you may move to adjacent 
 * numbers on the row below.

Example
For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 
2 + 3 + 5 + 1 = 11).

Note
Bonus point if you are able to do this using only O(n) 
extra space, where n is the total number of rows in 
the triangle.
 */
public class Triangle {

    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int xLen = triangle.size();
        int[] dp = new int[xLen];
        for (int i = xLen - 1; i >= 0; --i) {
            int yLen = triangle.get(i).size();
            for (int j = 0; j < yLen; ++j) {
                dp[j] = triangle.get(i).get(j) + 
                    (i == xLen - 1 ? 0 : Math.min(dp[j], dp[j + 1]));
            }
        }
        return dp[0];
    }

}
