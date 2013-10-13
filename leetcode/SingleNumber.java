/*
 * Given an array of integers, every element appears twice except for one. Find that single one.

 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        boolean[] isSingle = new boolean[256];
        for(int i = 0; i < A.length; i++) {
            isSingle[A[i]] = !isSingle[A[i]];
        }
        int i = 0;
        while(!isSingle[A[i]]) {
            i++;
        }
        return A[i];
    }
}
