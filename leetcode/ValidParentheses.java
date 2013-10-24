public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
            else {
                if(stack.size() > 0) {
                    char peek = stack.peek();
                    if(!(s.charAt(i) == ')' && peek == '(' || s.charAt(i) == ']' && peek == '[' 
                            || s.charAt(i) == '}' && peek == '{'))
                        return false;
                    else
                        stack.pop();
                }
                else return false;  
            }
        }
        return stack.isEmpty();
    }
}
