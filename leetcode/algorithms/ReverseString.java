/*
 * Write a function that takes a string as 
 * input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
 */
public class ReverseString {

    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; --i) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

/*********************************************************/

    public String reverseString(String s) {
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length / 2; ++i) {
            char tmp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = tmp;
        }
        return new String(array);
    }

/*********************************************************/

    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

}
