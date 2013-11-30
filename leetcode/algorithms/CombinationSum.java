/*
 * Given a set of candidate numbers (C) and a target number (T), find all unique 
 * combinations in C where
 * the candidate numbers sums to T.

 * The same repeated number may be chosen from C unlimited number of times.

 * Note:

 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, � , ak) must be in non-descending order. 
 * (ie, a1 ? a2 ? � ? ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 */
public class CombinationSum {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(result, new ArrayList<Integer>(), candidates, 0, target);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> list, 
            int[] candidates, int position, int target) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        } 
        for (int i = position; i <= candidates.length - 1 && target > 0; i++) {
            list.add(candidates[i]);
            dfs(result, list, candidates, i, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }

}
