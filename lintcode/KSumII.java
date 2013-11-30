/*
 * Given n unique integers, number k (1<=k<=n) and target.

Find all possible k integers where their sum is target.

Example
Given [1,2,3,4], k = 2, target = 5. Return:

[
  [1,4],
  [2,3]
]
 */
public class KSumII {

    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        ArrayList<ArrayList<Integer>> result = 
            new ArrayList<ArrayList<Integer>>();
        Arrays.sort(A);
        dfs(result, new ArrayList<Integer>(), A, 0, k, target);
        return result;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> result, 
            ArrayList<Integer> list, int[] A, int position, int k,
            int target) {
        if (list.size() == k && target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = position; list.size() < k && i < A.length; ++i) {
            list.add(A[i]);
            dfs(result, list, A, i + 1, k, target - A[i]);
            list.remove(list.size() - 1);
        }
    }

}
