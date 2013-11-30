/*
 * Given a collection of numbers, return all possible permutations.

 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < num.length; i++) {
            List<List<Integer>> tmp = new ArrayList<List<Integer>>();
            for (List<Integer> list : result) {
                for (int j = 0; j <= list.size(); j++) {
                    List<Integer> item = new ArrayList<Integer>(list);
                    item.add(j, num[i]);
                    if (!tmp.contains(item))
                        tmp.add(item);
                }
            }
            result = tmp;
        }
        return result;
    }

/*****************************************************************************/

    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        boolean[] isVisited = new boolean[num.length];
        dfs(result, new ArrayList<Integer>(), num, isVisited);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> list, 
            int[] num, boolean[] isVisited) {
        if (list.size() == num.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                list.add(num[i]);
                dfs(result, list, num, isVisited);
                list.remove(list.size() - 1);
                isVisited[i] = false;
                while (i < num.length - 1 && num[i] == num[i + 1]) {
                    i++;
                }
            }
        }
    }

}
