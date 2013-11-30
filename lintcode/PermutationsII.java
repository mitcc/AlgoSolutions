/*
 * Given a list of numbers with duplicate number in it. Find all unique 
 * permutations.

Example
For numbers [1,2,2] the unique permutations are:

[
  [1,2,2],
  [2,1,2],
  [2,2,1]
]

Challenge
Using recursion to do it is acceptable. If you can do it without recursion, 
that would be great!
 */
public class PermutationsII {

    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Collections.sort(nums);
        boolean[] isVisited = new boolean[nums.size()];
        dfs(result, new ArrayList<Integer>(), nums, isVisited);
        return result;
    }

    public void dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, 
            ArrayList<Integer> nums, boolean[] isVisited) {
        if (list.size() == nums.size()) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.size(); ++i) {
            if (isVisited[i]) {
                continue;
            }
            isVisited[i] = true;
            list.add(nums.get(i));
            dfs(result, list, nums, isVisited);
            list.remove(list.size() - 1);
            isVisited[i] = false;
            while (i + 1 < nums.size() && nums.get(i) == nums.get(i + 1)) {
                i++;
            }
        }
    }

/***************************************************************************************/

    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.size(); ++i) {
            ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();
            for (int j = 0; j < result.size(); ++j) {
                for (int k = 0; k <= result.get(j).size(); ++k) {
                    ArrayList<Integer> list = new ArrayList<Integer>(result.get(j));
                    list.add(k, nums.get(i));
                    if (!tmp.contains(list)) {
                        tmp.add(list);
                    }
                }
            }
            result = tmp;
        }
        return result;
    }

}
