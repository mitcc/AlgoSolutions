/*
 * Given a collection of integers that might contain duplicates, S, return all 
 * possible subsets.

 * Note:

 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,2], a solution is:

 * [
 *  [2],
 *  [1],
 *  [1,2,2],
 *  [2,2],
 *  [1,2],
 *  []
 * ]
 */

public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        result.add(new ArrayList<Integer>());
        int oldSize = 0;
        for (int i = 0; i < num.length; i++) {
            int newSize = result.size();
            int start = (i > 0 && num[i] != num[i - 1]) ? 0 : oldSize;
            for (int j = start; j < newSize; j++) {
                List<Integer> list = new ArrayList<Integer>(result.get(j));
                list.add(num[i]);
                result.add(list);
            }
            oldSize = newSize;
        }
        return result;
    }

/*****************************************************************************/

    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);
        dfs(result, list, 0, num);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> list, 
            int index, int[] num) {
        result.add(new ArrayList<Integer>(list));
        for (int i = index; i < num.length; i++) {
            list.add(num[i]);
            dfs(result, list, i + 1, num);
            list.remove(list.size() - 1);
            while (i < num.length - 1 && num[i] == num[i + 1]) {
                i++;
            }
        }
    }

/*****************************************************************************/

    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        for (int i = 0; i < 1 << num.length; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < num.length; j++) {
                if ((i & 1 << j) != 0) 
                    list.add(num[j]);
            }
            if (!result.contains(list))
                result.add(list);
        }
        return result;
    }

/*****************************************************************************/

    public List<List<Integer>> subsetsWithDup(int[] num) {
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        Arrays.sort(num);
        for (int i = 0; i < 1 << num.length; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < num.length; j++) {
                if ((i & 1 << j) != 0) 
                    list.add(num[j]);
            }
            set.add(list);
        }
        return new ArrayList<List<Integer>>(set);
    }

/*****************************************************************************/

    public List<List<Integer>> subsetsWithDup(int[] num) {
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        Arrays.sort(num);
        set.add(new ArrayList<Integer>());
        for (int i = 0; i < num.length; i++) {
            HashSet<List<Integer>> setCopy = new HashSet<List<Integer>>(set);
            for (Iterator<List<Integer>> it = setCopy.iterator(); it.hasNext(); ) {
                List<Integer> list = new ArrayList<Integer>(it.next());
                list.add(num[i]);
                set.add(list);
            }
        }
        return new ArrayList<List<Integer>>(set);
    }

}
