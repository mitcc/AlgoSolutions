/*
 * Given an array of integers, every element appears three times except for one. Find that single one.

 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumberII {
/*  public int singleNumber(int[] A) {
        int[] bits = new int[32];
        for(int i = 0; i < A.length; i++) {
            String bin = Integer.toBinaryString(A[i]);
            for(int j = bin.length() - 1; j >= 0; j--) {
                if(bin.charAt(j) == '1') {
                    bits[31 - j]++;
                }
            }
        }
        String binary = "";
        for(int i = 0; i < 32; i++) {
            binary += (bits[i] % 3 == 0) ? "0" : "1";
        }
        return Integer.parseInt(binary, 2);
    }
*/

    public int singleNumber(int[] A) {
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
}
