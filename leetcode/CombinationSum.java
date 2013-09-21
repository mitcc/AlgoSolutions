/*
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where
 * the candidate numbers sums to T.

 * The same repeated number may be chosen from C unlimited number of times.

 * Note:

 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, � , ak) must be in non-descending order. (ie, a1 ? a2 ? � ? ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 */
public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subList = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combinationSumHelper(result, subList, candidates, target, 0, 0);
        return result;
    }

    public void combinationSumHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> subList, 
            int[] candidates, int target, int sum, int preIndex) {
        if(sum == target) 
            result.add(new ArrayList<Integer>(subList));
        if(sum < target) {
            for(int i = preIndex; i < candidates.length; i++) {
                subList.add(candidates[i]);
                combinationSumHelper(result, subList, candidates, target, sum + candidates[i], i);
                subList.remove(subList.size() - 1);
            }
        }
    }
}
