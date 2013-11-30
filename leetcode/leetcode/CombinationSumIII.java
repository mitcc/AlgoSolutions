/*
Find all possible combinations of k numbers that add up to a number n, given 
that only numbers from 1 to 9 can be used and each combination should be a 
unique set of numbers.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(result, new ArrayList<Integer>(), k, n, 1);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> list, 
            int k, int n, int position) {
        if (k == 0 && n == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = position; i <= 9 && n > 0; ++i) {
            list.add(i);
            dfs(result, list, k - 1, n - i, i + 1);
            list.remove(list.size() - 1);
        }
    }

}
