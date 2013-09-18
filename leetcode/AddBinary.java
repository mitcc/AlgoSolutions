/*
 * Given two binary strings, return their sum (also a binary string).

 * For example,
 * a = "11"
 * b = "1"
 * Return "100". 
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if(a.length() == 0)
            return b;
        if(b.length() == 0)
            return a;
        String result = "";
        int carry = 0;
        for(int i = 0; i < Math.max(a.length(), b.length()); i++) {
            int x = (i > a.length() - 1) ? 0 : a.charAt(a.length() - 1 - i) - '0';
            int y = (i > b.length() - 1) ? 0 : b.charAt(b.length() - 1 - i) - '0';
            result = (x + y + carry) % 2 + result;
            carry = (x + y + carry) / 2;
        }
        if(carry > 0)
            result = carry % 2 + result;
        return result;
    }
}
