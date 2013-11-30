/*
 * Write a function that takes a string as input and returns the string 
 * reversed.

Example:
Given s = "hello", return "olleh".
 */
public class ReverseString {

    public String reverseString(String s) {
        if (s == null) {
            return null;
        }
        char[] A = s.toCharArray();
        for (int i = 0; i < A.length / 2; ++i) {
            char tmp = A[i];
            A[i] = A[A.length - 1 - i];
            A[A.length - 1 - i] = tmp;
        }
        return new String(A);
    }

/*****************************************************************************/

    public String reverseString(String s) {
        if (s == null) {
            return null;
        }
        return new StringBuilder(s).reverse().toString();
    }

}
