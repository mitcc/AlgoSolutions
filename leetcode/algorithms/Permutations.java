/*
 * Given a collection of numbers, return all possible permutations.

 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */

public class Permutations {

    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < num.length; i++) {
            List<List<Integer>> tmp = new ArrayList<List<Integer>>();
            for (List<Integer> list : result) {
                for (int j = 0; j <= list.size(); j++) {
                    List<Integer> item = new ArrayList<Integer>(list);
                    item.add(j, num[i]);
                    tmp.add(item);
                }
            }
            result = tmp;
        }
        return result;
    }

/*****************************************************************************/

    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(result, new ArrayList<Integer>(), num);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> list, int[] num) {
        if (list.size() == num.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (list.indexOf(num[i]) == -1) {
                list.add(num[i]);
                dfs(result, list, num);
                list.remove(list.size() - 1);
            }
        }
    }
}
