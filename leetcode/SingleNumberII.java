/*
 * Given an array of integers, every element appears three times except for one. Find that single one.

 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumberII {
/*  public int singleNumber(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < A.length; i++) {
            map.put(A[i], map.containsKey(A[i]) ? map.get(A[i]) + 1 : 1);
        }
        int i = 0; 
        while(map.get(A[i]) == 3) {
            i++;
        }
        return A[i];
    }

    public int singleNumber(int[] A) {
        int[] count = new int[32];
        int result = 0;
        for(int i = 0; i < 32; i++) {
            for(int j = 0; j < A.length; j++) {
                count[i] += (A[j] >> i) & 1;
            }
            count[i] %= 3;
            result |= count[i] << i;
        }
        return result;
    }
*/

    public int singleNumber(int[] A) {
        int one = 0, two = 0, three = 0;
        for(int i = 0; i < A.length; i++) {
            two |= one & A[i];
            one ^= A[i];
            three = one & two;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }
}
