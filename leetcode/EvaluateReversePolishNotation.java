/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 * Some examples:
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public EvaluateReversePolishNotation {
    public int calculate(String[] tokens, int i) {
        if(tokens[i].equals("+"))
            return Integer.parseInt(tokens[i - 2]) + Integer.parseInt(tokens[i - 1]);
        if(tokens[i].equals("-"))
            return Integer.parseInt(tokens[i - 2]) - Integer.parseInt(tokens[i - 1]);
        if(tokens[i].equals("*"))
            return Integer.parseInt(tokens[i - 2]) * Integer.parseInt(tokens[i - 1]);
        else 
            return Integer.parseInt(tokens[i - 2]) / Integer.parseInt(tokens[i - 1]);
    }

    public int evalRPN(String[] tokens) {
        if(tokens.length == 1)
            return Integer.parseInt(tokens[0]);
        if(tokens.length == 3)
            return calculate(tokens, 2);
        String[] temp = new String[tokens.length - 2];
        int i = 0;
        while(!tokens[i].equals("+") && !tokens[i].equals("-")
                && !tokens[i].equals("*") && !tokens[i].equals("/")) {
            i++;
        }
        for(int j = 0; j <= temp.length - 1; j++) {
            if(i - 3 >= 0 && j <= i - 3)
                temp[j] = tokens[j];
            else if(j == i - 2)
                temp[j] = "" + calculate(tokens, i);
            else if(j >= i - 2)
                temp[j] = tokens[j + 2];
        }
        return evalRPN(temp);
    }
}
