/*
 * Given a set of distinct integers, S, return all possible subsets.

 * Note:

 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:

 * [
 *  [3],
 *  [1],
 *  [2],
 *  [1,2,3],
 *  [1,3],
 *  [2,3],
 *  [1,2],
 *  []
 * ]
 */

public class Subsets {

    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(S);
        for (int i = 0; i < 1 << S.length; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < S.length; j++) {
                if ((i & 1 << j) != 0)
                    list.add(S[j]);
            }
            result.add(list);
        }
        return result;
    }

/*****************************************************************************/

    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(S);
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < S.length; i++) {
            int k = result.size();
            for (int j = 0; j < k; j++) {
                List<Integer> list = new ArrayList<Integer>(result.get(j));
                list.add(S[i]);
                result.add(list);
            }
        }
        return result;
    }

/*****************************************************************************/

    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(S);
        List<Integer> list = new ArrayList<Integer>();
        dfs(result, list, 0, S);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> list, 
            int position, int[] S) {
        result.add(new ArrayList<Integer>(list));
        for (int i = position; i < S.length; i++) {
            list.add(S[i]);
            dfs(result, list, i + 1, S);
            list.remove(list.size() - 1);
        }
    }
}
