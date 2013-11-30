/*
 * Given a string containing just the characters '(' and ')', find the length 
 * of the longest valid (well-formed) 
 * parentheses substring.

 * For "(()", the longest valid parentheses substring is "()", which has 
 * length = 2.

 * Another example is ")()())", where the longest valid parentheses substring 
 * is "()()", which has length = 4.
 */
public class LongestValidParentheses {

/**************************** updated 2014.04.04 *****************************/

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int answer = 0;
        int left = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else if (stack.isEmpty())
                left = i;
            else {
                stack.pop();
                answer = Math.max(answer,
                        i - (stack.isEmpty() ? left : stack.peek()));
            }
        }
        return answer;
    }

/*****************************************************************************/

    public int longestValidParentheses(String s) {
        return Math.max(helper(s, 0, s.length(), 1, '('), 
                helper(s, s.length() - 1, -1, -1, ')'));
    }

    public int helper(String s, int start, int end, int step, char c) {
        int maxLen = 0;
        int begin = start - step;
        int count = 0;
        for (int i = start; i != end; i += step) {
            if (s.charAt(i) == c) 
                count++;
            else if (count == 0)
                begin = i;
            else {
                count--;
                if (count == 0)
                    maxLen = Math.max(maxLen, Math.abs(i - begin));
            }
        }
        return maxLen;
    }

/*****************************************************************************/

    public int longestValidParentheses(String s) {
        int len = s.length();
        int[] dp = new int[len];
        int answer = 0;
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                int j = i + 1 + dp[i + 1];
                if (j < len && s.charAt(j) == ')') {
                    dp[i] = dp[i + 1] + 2;
                    if (j + 1 < len)
                        dp[i] += dp[j + 1];
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }

}
