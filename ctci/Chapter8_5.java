/*
 * Implement an algorithm to print all valid (e.g., properly opened and closed) 
 * combinations of n-pairs of parentheses.
 * EXAMPLE:
 * input: 3 (e.g., 3 pairs of parentheses)
 * output: ()()(), ()(()), (())(), ((()))
 */
public class Chapter8_5 {

    public void printParentheses(int n) {
        dfs("", n, n);
    }

    public void dfs(String s, int left, int right) {
        if (left == 0 && right == 0) {
            System.out.println(s);
        }
        if (left > 0) {
            dfs(s + "(", left - 1, right);
        }
        if (0 <= left && left < right) {
            dfs(s + ")", left, right - 1);
        }
    }
 
}
