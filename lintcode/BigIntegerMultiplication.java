/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2

Example
The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class BigIntegerMultiplication {

    public String multiply(String num1, String num2) {
        int[] array = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; --i) {
            int carrier = 0;
            for (int j = num2.length() - 1; j >= 0; --j) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = product + carrier + array[i + j + 1];
                carrier = sum / 10;
                array[i + j + 1] = sum % 10;
            }
            array[i] = carrier;
        }
        int i = 0;
        for (; i < array.length && array[i] == 0; ++i);
        StringBuilder sb = new StringBuilder();
        for (int j = i; j < array.length; ++j) {
            sb.append(array[j]);
        }
        if (sb.length() == 0) {
            sb.append(0);
        }
        return sb.toString();
    }

}
