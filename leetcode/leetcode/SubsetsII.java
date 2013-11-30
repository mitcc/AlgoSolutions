/*
Given a collection of integers that might contain duplicates, nums, return all
possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
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
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }

/*****************************************************************************/

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        result.add(new ArrayList<Integer>());
        int oldSize = result.size();
        for (int i = 0; i < nums.length; ++i) {
            int start = (i > 0 && nums[i] == nums[i - 1]) ? oldSize : 0;
            int newSize = result.size();
            for (int j = start; j < newSize; ++j) {
                List<Integer> list = new ArrayList<Integer>(result.get(j));
                list.add(nums[i]);
                result.add(list);
            }
            oldSize = newSize;
        }
        return result;
    }

}
