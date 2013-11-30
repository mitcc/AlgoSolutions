/*
 * Given a list of numbers, return all possible permutations.

Example
For nums = [1,2,3], the permutations are:

[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
Challenge
Do it without recursion.
 */
public class Permutations {

    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = 
            new ArrayList<ArrayList<Integer>>();
        if (nums == null) {
            return result;
        }
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.size(); ++i) {
            ArrayList<ArrayList<Integer>> tmp = 
                new ArrayList<ArrayList<Integer>>();
            for (int j = 0; j < result.size(); ++j) {
                for (int k = 0; k <= result.get(j).size(); ++k) {
                    ArrayList<Integer> list = 
                        new ArrayList<Integer>(result.get(j));
                    list.add(k, nums.get(i));
                    tmp.add(list);
                }
            }
            result = tmp;
        }
        return result;
    }

}
