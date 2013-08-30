/*
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):

 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.

 * Note: Given n will be between 1 and 9 inclusive.
 */
import java.util.ArrayList;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int factor = 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++) {
            list.add(i);
            factor *=  i;
        }
        StringBuffer sb = new StringBuffer();
        for(int i = n; i > 0; i--) {
            factor /= i;
            int div = (k - 1) / factor;
            sb.append(list.get(div));
            list.remove(div);
            k = k - div * factor;// or: k = (k - 1) % factor + 1;
        }
        return sb.toString();
    }
}
