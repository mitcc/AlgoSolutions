/*
 * Given two binary strings, return their sum (also a binary string).

Example
a = 11

b = 1

Return 100
 */
public class AddBinary {

    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        String result = "";
        int carrier = 0;
        int len = Math.max(a.length(), b.length());
        for (int i = 0; i < len; ++i) {
            int va = i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            int vb = i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            result = ((va + vb + carrier) % 2) + result;
            carrier = (va + vb + carrier) / 2;
        }
        if (carrier > 0) {
            result = carrier + result;
        }
        return result;
    }

}
