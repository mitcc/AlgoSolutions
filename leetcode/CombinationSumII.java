/*
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in 
 * C where the candidate numbers sums to T.

 * Each number in C may only be used once in the combination.

 * Note:

 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, � , ak) must be in non-descending order. (ie, a1 ? a2 ? � ? ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 */
public class CombinationSumII {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subList = new ArrayList<Integer>();
        Arrays.sort(num);
        combinationSum2Helper(result, subList, num, target, 0, 0);
        return result;
    }

    public void combinationSum2Helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> subList, 
            int[] num, int target, int sum, int preIndex) {
        if(sum == target) 
            result.add(new ArrayList<Integer>(subList));
        if(sum < target) {
            for(int i = preIndex; i < num.length; i++) {
                if(i > preIndex && num[i] == num[i - 1])
                    continue;
                subList.add(num[i]);
                combinationSum2Helper(result, subList, num, target, sum + num[i], i + 1);
                subList.remove(subList.size() - 1);
            }
        }
    }
}
