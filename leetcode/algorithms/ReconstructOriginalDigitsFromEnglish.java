/*
 * Given a non-empty string containing an out-of-order English representation
 * of digits 0-9, output the digits in ascending order.

 * Note:
 * Input contains only lowercase English letters.
 * Input is guaranteed to be valid and can be transformed to its original 
 * digits. 
 * That means invalid inputs such as "abc" or "zerone" are not permitted.
 * Input length is less than 50,000.
 * Example 1:
 * Input: "owoztneoer"
 * 
 * Output: "012"
 * Example 2:
 * Input: "fviefuro"
 * 
 * Output: "45"
 */
public class ReconstructOriginalDigitsFromEnglish {

    public String originalDigits(String s) {
        // one, two, three, four, five, six, seven, eight, nine, zero
        // unique: g, u, w, x, z
        int[] count = new int[256];
        for (int i = 0; i < s.length(); ++i) {
            count[s.charAt(i)]++;
        }
        count['o'] -= count['u'] + count['w'] + count['z'];
        count['f'] -= count['u'];
        count['s'] -= count['x'];
        count['h'] -= count['g'];
        count['i'] -= count['g'] + count['x'] + count['f'];
        int[] nums = {count['z'], count['o'], count['w'], 
            count['h'], count['u'], count['f'], count['x'], 
            count['s'], count['g'], count['i']};
        String result = "";
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < nums[i]; ++j) {
                result += i;
            }
        }
        return result;
    }

}
