/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 * For example, given n = 3, a solution set is:

 * "((()))", "(()())", "(())()", "()(())", "()()()" 
 */
public class GenerateParentheses {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        String subString = "";
        generateParenthesisHelper(result, subString, n, n);
        return result;
    }

    public void generateParenthesisHelper(ArrayList<String> result, String subString, int left, int right) {
        if(left == 0 && right == 0) 
            result.add(subString);
        if(left > 0)
            generateParenthesisHelper(result, subString + "(", left - 1, right);
        if(left < right) 
            generateParenthesisHelper(result, subString + ")", left, right - 1);
    }
}
