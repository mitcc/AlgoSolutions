/*
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class Subsets {

    public List<List<Integer>>subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> list, 
            int[] nums, int position) {
        result.add(new ArrayList<Integer>(list));
        for (int i = position; i < nums.length; ++i) {
            list.add(nums[i]);
            dfs(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

/*****************************************************************************/
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; ++i) {
            int size = result.size();
            for (int j = 0; j < size; ++j) {
                List<Integer> list = new ArrayList<Integer>(result.get(j));
                list.add(nums[i]);
                result.add(list);
            }
        }
        return result;
    }

}
