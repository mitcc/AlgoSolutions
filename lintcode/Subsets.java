/*
 * Given a set of distinct integers, return all possible subsets.

Example
If S = [1,2,3], a solution is:

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
Note
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Challenge
Can you do it in both recursively and iteratively?
 */
public class Subsets {

    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> result =
                new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        for (int num : nums) {
            int k = result.size();
            for (int i = 0; i < k; ++i) {
                ArrayList<Integer> list = 
                    new ArrayList<Integer>(result.get(i));
                list.add(num);
                result.add(list);
            }
        }
        return result;
    }

/*******************************************************************/

    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> result = 
            new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        return dfs(result, nums, 0);
    }

    public ArrayList<ArrayList<Integer>> dfs(ArrayList<ArrayList<Integer>> 
            result, int[] nums, int position) {
        if (position == nums.length) {
            return result;
        }
        int k = result.size();
        for (int i = 0; i < k; ++i) {
            ArrayList<Integer> list = new ArrayList<Integer>(result.get(i));
            list.add(nums[position]);
            result.add(list);
        }
        return dfs(result, nums, position + 1);
    }

/*******************************************************************/

    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> result = 
            new ArrayList<ArrayList<Integer>>();
        dfs(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }

    public void dfs(ArrayList<ArrayList<Integer>> result, 
            ArrayList<Integer> list, int[] nums, int position) {
        result.add(new ArrayList<Integer>(list));
        for (int i = position; i < nums.length; ++i) {
            list.add(nums[i]);
            dfs(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

}
