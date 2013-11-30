/*
 * Given an array S of n integers, are there elements a, b, c, and d in S such 
 * that a + b + c + d = target? Find all unique quadruplets in the array which 
 * gives the sum of target.

 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, 
 * a <= b <= c <= d)
 * The solution set must not contain duplicate quadruplets.
 *     For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 *     A solution set is:
 *     (-1,  0, 0, 1)
 *     (-2, -1, 1, 2)
 *     (-2,  0, 0, 2)
 * 
 */

public class FourSum {
    
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i] == num[i - 1])
                continue;
            for (int j = i + 1; j < num.length; j++) {
                if (j > i + 1 && num[j] == num[j - 1])
                    continue;
                int k = j + 1;
                int p = num.length - 1;
                while (k < p) {
                    int sum = num[i] + num[j] + num[k] + num[p];
                    if (sum > target) 
                        p--;
                    else if (sum < target)
                        k++;
                    else {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[k]);
                        list.add(num[p]);
                        res.add(list);
                        do {
                            k++;
                        } while (k < p && num[k] == num[k - 1]);
                        do {
                            p--;
                        } while (k < p && num[p] == num[p + 1]);
                    }
                }
            }
        }
        return res;
    }

}
