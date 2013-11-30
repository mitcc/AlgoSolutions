/*
 * Given n and k, return the k-th permutation sequence.

 Notice

n will be between 1 and 9 inclusive.

Example
For n = 3, all permutations are listed as follows:

"123"
"132"
"213"
"231"
"312"
"321"
If k = 4, the fourth permutation is "231"

Challenge
O(n*k) in time complexity is easy, can you do it in O(n^2) or less?
 */
public class PermutationSequence {

    /**
      * @param n: n
      * @param k: the kth permutation
      * @return: return the k-th permutation
      */
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<Integer>();
        int factorial = 1;
        for (int i = 1; i <= n; ++i) {
            list.add(i);
            factorial *= i;
        }
        factorial /= n;
        String result = "";
        for (int i = 1; i <= n - 1; ++i) {
            int index = (k - 1) / factorial;
            result += list.get(index);
            list.remove(Integer.valueOf(list.get(index)));
            k = (k - 1) % factorial + 1;
            factorial /= n - i;
        }
        result += list.get(0);
        return result;
    }

}
