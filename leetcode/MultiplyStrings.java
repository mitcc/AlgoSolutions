/*
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

 * Note: The numbers can be arbitrarily large and are non-negative. 
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] num = new int[len1 + len2];
        for(int i = 0; i < len1; i++) {
            int carry = 0;
            int multiple1 = num1.charAt(len1 - 1 - i) - '0';
            for(int j = 0; j < len2; j++) {
                int multiple2 = num2.charAt(len2 - 1 - j) - '0';
                carry = multiple1 * multiple2 + carry + num[len1 + len2 - 1 - i - j];
                num[len1 + len2 - 1 - i - j] = carry % 10;
                carry /= 10;
            }
            num [len1 - i - 1] = carry;
        } 
        int start = 0;
        while(start < len1 + len2 && num[start] == 0) {
            start++;
        }
        if(start == len1 + len2)
            return "0";
        String result = "";
        for(int i = start; i < len1 + len2; i++) {
            result += num[i];
        }
        return result;
    }
}
