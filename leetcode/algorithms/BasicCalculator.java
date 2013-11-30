/*
 * Implement a basic calculator to evaluate a simple expression string.

 * The expression string may contain open ( and closing parentheses ), 
 * the plus + or minus sign -, non-negative integers and empty spaces .
 * 
 * You may assume that the given expression is always valid.
 * 
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 */
public class BasicCalculator {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(1);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = 10 * num + s.charAt(i) - '0';
                    i++;
                }
                i--;
                result += stack.pop() * num;
            } else if (c == '(' || c == '+') {
                stack.push(stack.peek());
            } else if (c == '-') {
                stack.push(-1 * stack.peek());
            } else if (c == ')') {
                stack.pop();
            }
        }
        return result;
    }

/*****************************************************************************/

    public int calculate(String s) {
        Deque<Integer> numList = new LinkedList<Integer>();
        Deque<Character> optList = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = 10 * num + s.charAt(i) - '0';
                    i++;
                }
                i--;
                numList.add(num);
            } else if (c == '(' || c == '+' || c == '-') {
                optList.add(c);
            } else if (c == ')') {
                Stack<Integer> stackNum = new Stack<Integer>();
                Stack<Character> stackOpt = new Stack<Character>();
                while (optList.peekLast() != '(') {
                    stackNum.push(numList.pollLast());
                    stackOpt.push(optList.pollLast());
                }
                optList.pollLast();
                int tmpRes = numList.pollLast();
                while (!stackOpt.empty()) {
                    tmpRes = calc(tmpRes, stackNum.pop(), stackOpt.pop());
                }
                numList.add(tmpRes);
            }
        }
        int result = numList.pollFirst();
        while (optList.size() > 0) {
            result = calc(result, numList.pollFirst(), optList.pollFirst());
        }
        return result;
    }

    public int calc(int num1, int num2, char operator) {
        return num1 + (operator == '+' ? 1 : -1) * num2;
    }

}
