/*
 * Given an array S of n integers, are there elements a, b, c in S such that 
 * a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.

 * Note:

 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a <= b 
 * <= c)
 * The solution set must not contain duplicate triplets.
 *   For example, given array S = {-1 0 1 2 -1 -4},

 *   A solution set is:
 *   (-1, 0, 1)
 *   (-1, -1, 2)
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i] == num[i - 1])
                continue;
            int start = i + 1;
            int end = num.length - 1;
            while (start < end) {
                int threeSum = num[i] + num[start] + num[end];
                if (threeSum == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[start]);
                    list.add(num[end]);
                    result.add(list);
                    do {
                        start++;
                    } while (start < end && num[start] == num[start - 1]);
                    do {
                        end--;
                    } while (start < end && num[end] == num[end + 1]);
                } else if (threeSum < 0) {
                    start++;
                } else if (threeSum > 0) {
                    end--;
                }
            }
        }
        return result;
    } 

}
