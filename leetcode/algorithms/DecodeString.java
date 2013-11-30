/*
 * Given an encoded string, return it's decoded string.

 * The encoding rule is: k[encoded_string], where the encoded_string 
 * inside the square brackets is being repeated exactly k times. Note
 * that k is guaranteed to be a positive integer.
 * 
 * You may assume that the input string is always valid; No extra 
 * white spaces, square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain
 * any digits and that digits are only for those repeat numbers, k. 
 * For example, there won't be input like 3a or 2[4].
 * 
 * Examples:
 * 
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString {

    public String decodeString(String s) {
        String result = "";
        if (s == null) {
            return result;
        }
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<String> strStack = new Stack<String>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; ++i) {
            if (Character.isDigit(ch[i])) {
                int num = 0;
                while (i < ch.length && Character.isDigit(ch[i])) {
                    num = 10 * num + (ch[i++] - '0');
                }
                i--;
                numStack.push(num);
            } else if (ch[i] == '[') {
                strStack.push(result);
                result = "";
            } else if (ch[i] == ']') {
                int times = numStack.pop();
                String tmp = "";
                for (int j = 0; j < times; ++j) {
                    tmp += result;
                }
                result = strStack.pop() + tmp;
            } else if (Character.isLetter(ch[i])) {
                result += ch[i];
            }
        }
        return result;
    }

}
