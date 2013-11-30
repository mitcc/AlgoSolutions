/*
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...

 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.

 * Given an integer n, generate the nth sequence.

 * Note: The sequence of integers will be represented as a string.
 */

public class CountAndSay {

/*****************************************************************************/

    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String s = countAndSay(n - 1);
        int cnt = 1;
        String res = "";
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                res += "" + cnt + s.charAt(i - 1);
                cnt = 1;
            } else {
                cnt++;
            }
        }
        res += "" + cnt + s.charAt(s.length() - 1);
        return res;
    }


/**************************** updated 20141023 *******************************/

    public String countAndSay(int n) {
        String result = "1";
        for (int i = 2; i <= n; i++) {
            String next = result; 
            result = "";
            int count = 1;
            for (int j = 1; j < next.length(); j++) {
                if (next.charAt(j) == next.charAt(j - 1))
                    count++;
                else {
                    result += "" + count + next.charAt(j - 1);
                    count = 1;
                }
            }
            result += "" + count + next.charAt(next.length() - 1);
        }
        return result;
    }

}
