/*
 * Implement an algorithm to print all valid (e.g., properly opened and closed) combinations of n-pairs of parentheses.
 * EXAMPLE:
 * input: 3 (e.g., 3 pairs of parentheses)
 * output: ()()(), ()(()), (())(), ((()))
 */
public class Solution {
    public void printParentheses(int n) {
        helper("", n, n);
    }

    public void helper(String s, int left, int right) {
        if(left == 0 && right == 0)
            System.out.println(s);
        if(left > 0)
            helper(s + "(", left - 1, right);
        if(left < right)
            helper(s + ")", left, right - 1);
    }
}
