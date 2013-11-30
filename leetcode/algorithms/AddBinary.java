/*
 * Given two binary strings, return their sum (also a binary string).

 * For example,
 * a = "11"
 * b = "1"
 * Return "100". 
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        String result = "";
        int len = Math.max(a.length(), b.length());
        int carrier = 0;
        for (int i = 0; i < len; ++i) {
            int ca = i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
            int cb = i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
            result = (ca + cb + carrier) % 2 + result;
            carrier = (ca + cb + carrier) / 2;
        }
        return carrier == 0 ? result : carrier + result;
    }

}
