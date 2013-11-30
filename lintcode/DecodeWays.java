/*
 * A message containing letters from A-Z is being encoded to numbers 
 * using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total 
number of ways to decode it.

Example
Given encoded message 12, it could be decoded as AB (1 2) or L (12).
The number of ways decoding 12 is 2.
 */
public class DecodeWays {

    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int cur = 1;
        for (int i = 1, prev = 1; i < s.length(); ++i) {
            int next = 0;
            if (s.charAt(i) != '0') {
                next += cur;
            }
            if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && 
                    s.charAt(i) <= '6') {
                next += prev;
            }
            prev = cur;
            cur = next;
        }
        return cur;
    }

}
