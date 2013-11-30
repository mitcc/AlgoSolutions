/*
 * Given a string containing just the characters '(', ')', '{', 
 * '}', '[' and ']', determine if the input string is valid.

Example
The brackets must close in the correct order, "()" and "()[]{}" 
are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {

    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (stack.isEmpty() || c - stack.pop() > 2) {
                return false;
            } 
        }
        return stack.isEmpty();
    }

}
