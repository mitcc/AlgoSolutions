/*
Given a collection of numbers that might contain duplicates, return all 
possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; ++i) {
            List<List<Integer>> tmp = new ArrayList<List<Integer>>();
            for (int j = 0; j < result.size(); ++j) {
                for (int k = 0; k <= result.get(j).size(); ++k) {
                    List<Integer> list = new ArrayList<Integer>(result.get(j));
                    list.add(k, nums[i]);
                    if (!tmp.contains(list)) {
                        tmp.add(list);
                    }
                }
            }
            result = tmp;
        }
        return result;
    }

/*****************************************************************************/

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        boolean[] isVisited = new boolean[nums.length];
        dfs(result, new ArrayList<Integer>(), nums, isVisited);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> list, 
            int[] nums, boolean[] isVisited) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                list.add(nums[i]);
                dfs(result, list, nums, isVisited);
                list.remove(list.size() - 1);
                isVisited[i] = false;
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
    }

}
