/*
 * Given an array of integers, every element appears three times except for 
 * one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it 
without using extra memory?
 */
public class SingleNumberII {

    public int singleNumber(int[] nums) {
        int result = 0;
        int[] bits = new int[32];
        for (int i = 0; i < 32; ++i) {
            for (int num : nums) {
                bits[i] += (num >>> i) & 1;
            }
            result |= (bits[i] % 3) << i;
        }
        return result;
    }

/*****************************************************************************/

    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        int threes = 0;
        for (int num : nums) {
            twos |= ones & num;
            ones ^= num;
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }

/*****************************************************************************/

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, 1 + (map.containsKey(num) ? 1 : 0));
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

}
