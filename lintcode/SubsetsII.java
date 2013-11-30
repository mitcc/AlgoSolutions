/*
 * Given a list of numbers that may has duplicate numbers, 
 * return all possible subsets

 Notice

Each element in a subset must be in non-descending order.
The ordering between two subsets is free.
The solution set must not contain duplicate subsets.
Example
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

Challenge
Can you do it in both recursively and iteratively?
 */
public class SubsetsII {

    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> result = 
            new ArrayList<ArrayList<Integer>>();
        Collections.sort(S);
        dfs(result, new ArrayList<Integer>(), 0, S);
        return result;
    } 

    public void dfs(ArrayList<ArrayList<Integer>> result, 
            ArrayList<Integer> list, int position, ArrayList<Integer> S) {
        result.add(new ArrayList<Integer>(list));
        for (int i = position; i < S.size(); ++i) {
            list.add(S.get(i));
            dfs(result, list, i + 1, S);
            list.remove(list.size() - 1);
            while (i + 1 < S.size() && S.get(i) == S.get(i + 1)) {
                ++i;
            }
        }
    }

/*****************************************************************************/

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> result = 
            new ArrayList<ArrayList<Integer>>();
        Collections.sort(S);
        result.add(new ArrayList<Integer>());
        int oldSize = 0;
        for (int i = 0; i < S.size(); ++i) {
            int start = (i > 0 && S.get(i) != S.get(i - 1)) ? 0 : oldSize;
            int newSize = result.size();
            for (int j = start; j < newSize; ++j) {
                ArrayList<Integer> list = new ArrayList<Integer>(result.get(j));
                list.add(S.get(i));
                result.add(list);
            }
            oldSize = newSize;
        }
        return result;
    }

}
