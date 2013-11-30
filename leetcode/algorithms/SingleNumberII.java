/*
 * Given an array of integers, every element appears three times except for 
 * one. Find that single one.

 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement 
 * it without using extra memory?
 */
public class SingleNumberII {

/*************************** O(n) time, O(n) space ***************************/

    public int singleNumber(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.containsKey(A[i]) ? map.get(A[i]) + 1 : 1);
        }
        int i = 0;
        while (map.get(A[i]) != 1) {
            i++;
        }
        return A[i];
    }

/************************* O(nlgn) time, O(1) space **************************/

    public int singleNumber(int[] A) {
        if (A.length == 1)
            return A[0];
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (A[i] != A[i + 1]) {
                if (i == 0)
                    return A[0];
                else if (i == A.length - 2)
                    return A[A.length - 1];
                else if (A[i] != A[i + 1] && A[i + 1] != A[i + 2])
                    return A[i + 1];
            }
        }
        return -1;
    }

/***************************** O(n) time, O(1) space *************************/

    public int singleNumber(int[] A) {
        int[] bits = new int[32];
        int result = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++) {
                bits[i] += (A[j] >> i) & 1;
            }
            result |= (bits[i] % 3) << i;
        }
        return result;
    }

/***************************** O(n) time, O(1) space *************************/

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
