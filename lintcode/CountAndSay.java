/*
 * The count-and-say sequence is the sequence of integers 
 * beginning as follows:

1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.

11 is read off as "two 1s" or 21.

21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth sequence.

Example
Given n = 5, return "111221".

Note
The sequence of integers will be represented as a string.
 */
public class CountAndSay {

    /**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; ++i) {
            StringBuilder sb = new StringBuilder();
            int j = 0;
            for (int k = 1; k < result.length(); ++k) {
                if (result.charAt(k - 1) != result.charAt(k)) {
                    sb.append(k - j).append(result.charAt(k - 1));
                    j = k;
                }
            }
            sb.append(result.length() - j).
                append(result.charAt(result.length() - 1));
            result = sb.toString();
        }
        return result;
    }

}
