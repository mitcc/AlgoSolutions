/*
 * Given a collection of candidate numbers (C) and a 
 * target number (T), find all unique combinations in 
 * C where the candidate numbers sums to T.

 * Each number in C may only be used once in the combination.

 * Note:

 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, � , ak) must be in non-descending order. 
 * (ie, a1 ? a2 ? � ? ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(result, new ArrayList<Integer>(), num, 0, target);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> list, 
            int[] num, int position, int target) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = position; i <= num.length - 1 && target > 0; i++) {
            if (i > position && num[i] == num[i - 1])
                continue;
            list.add(num[i]);
            dfs(result, list, num, i + 1, target - num[i]);
            list.remove(list.size() - 1);
        }
    }

}
