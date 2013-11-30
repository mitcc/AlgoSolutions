/*
 * Implement function ToLowerCase() that has a string parameter str, and returns
 * the same string in lowercase.


Example 1:

Input: "Hello"
Output: "hello"
Example 2:

Input: "here"
Output: "here"
Example 3:

Input: "LOVELY"
Output: "lovely"
 */
public class ToLowerCase {

    public String toLowerCase(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); ++i) {
            builder.append(lowerCase(str.charAt(i)));
        }
        return builder.toString();
    }

    private static char lowerCase(char c) {
        if ('A' <= c && c <= 'Z') {
            return (char) (c + 32);
        }
        return c;
    }

}
