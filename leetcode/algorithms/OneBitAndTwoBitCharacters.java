/*
We have two special characters. The first character can be represented by one
bit 0. The second character can be represented by two bits (10 or 11).

Now given a string represented by several bits. Return whether the last
character must be a one-bit character or not. The given string will always end
with a zero.

Example 1:
Input: 
bits = [1, 0, 0]
Output: True
Explanation: 
The only way to decode it is two-bit character and one-bit character. So the
last character is one-bit character.
Example 2:
Input: 
bits = [1, 1, 1, 0]
Output: False
Explanation: 
The only way to decode it is two-bit character and two-bit character. So the
last character is NOT one-bit character.
Note:

1 <= len(bits) <= 1000.
bits[i] is always 0 or 1.
 */
public class OneBitAndTwoBitCharacters {

    public boolean isOneBitCharacter(int[] bits) {
        if (bits == null || bits.length == 0) {
            return false;
        }
        int step = 0;
        for (int i = 0; i < bits.length; i += step) {
            step = bits[i] + 1;
        }
        return step == 1;
    }

/*****************************************************************************/

    public boolean isOneBitCharacter(int[] bits) {
        if (bits == null || bits.length == 0) {
            return false;
        }
        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] == 0 ? 1 : 2;
        }
        return i == bits.length - 1;
    }

/*****************************************************************************/

    public boolean isOneBitCharacter(int[] bits) {
        if (bits == null || bits.length == 0) {
            return false;
        }
        boolean prev = true;
        boolean cur = true;
        for (int i = 0; i < bits.length; ++i) {
            boolean tmpCur = cur;
            cur = cur && bits[i] == 0;
            if (i > 0) {
                cur = cur || prev && bits[i - 1] == 1;
            }
            prev = tmpCur;
        }
        return prev;
    }

/*****************************************************************************/

    // dp, O(n) time, O(n) space.
    public boolean isOneBitCharacter(int[] bits) {
        if (bits == null || bits.length == 0) {
            return false;
        }
        boolean[] dp = new boolean[bits.length + 1];
        dp[0] = true;
        for (int i = 0; i < bits.length; ++i) {
            dp[i + 1] = dp[i] && bits[i] == 0;
            if (i > 0) {
                dp[i + 1] = dp[i + 1] || dp[i - 1] && bits[i - 1] == 1;
            }
        }
        return dp[bits.length - 1];
    }

}
