/*
Given a set of candidate numbers (C) (without duplicates) and a target number 
(T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        dfs(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> list, 
            int[] candidates, int target, int position) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = position; i < candidates.length && target > 0; ++i) {
            list.add(candidates[i]);
            dfs(result, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }

}
