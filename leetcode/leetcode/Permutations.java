/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; ++i) {
            List<List<Integer>> tmp = new ArrayList<List<Integer>>();
            for (List<Integer> list : result) {
                for (int j = 0; j <= list.size(); ++j) {
                    List<Integer> item = new ArrayList<Integer>(list);
                    item.add(j, nums[i]);
                    tmp.add(item);
                }
            }
            result = tmp;
        }
        return result;
    }

/*****************************************************************************/

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean[] isVisited = new boolean[nums.length];
        dfs(result, new ArrayList<Integer>(), nums, isVisited);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer>list, 
            int[] nums, boolean[] isVisited) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (!isVisited[i]) {
                isVisited[i] =true;
                list.add(nums[i]);
                dfs(result, list, nums, isVisited);
                list.remove(list.size() - 1);
                isVisited[i] = false;
            }
        }
    }

}
