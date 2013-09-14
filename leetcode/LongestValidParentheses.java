/*
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) 
 * parentheses substring.

 * For "(()", the longest valid parentheses substring is "()", which has length = 2.

 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int max = 0, left = -1;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') 
                stack.push(i);
            else {
                if(!stack.isEmpty()) {
                    stack.pop();
                    max = Math.max(max, stack.isEmpty() ? i - left : i - stack.peek());
                } else {
                    left = i;
                }
            }
        }
        return max;
    }
}
