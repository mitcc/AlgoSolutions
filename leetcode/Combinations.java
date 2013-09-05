/*
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 * For example,
 * If n = 4 and k = 2, a solution is:

 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, ink k) {
        if(k == 0)
            return null;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(k == 1) {
            for(int i = 1; i <= n; i++) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                result.add(temp);
            }
            return result;
        }
        for(int i = n; i >= k; i--) {
            for(ArrayList<Integer> temp : combine(i - 1, k - 1)) {
                temp.add(i);
                result.add(temp);
            }
        }
        return result;
    }
}
