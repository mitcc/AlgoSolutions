/*
 * Given a number represented as an array of digits, plus one to the number.
 */
public class PlusOne {
/*	public int[] plusOne(int[] digits) {
        int len = digits.length;
        int carrier = 1;
        int i = len - 1;
        while(carrier == 1 && i >= 0) {
            digits[i] += carrier;
            carrier = digits[i] / 10;
            digits[i] %= 10;
            i--;
        }
        if(carrier == 1) {
            digits = new int[len + 1];
            digits[0] = 1;
        }
        return digits;
    }*/

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int i = len - 1;
        while(i >= 0 && digits[i] == 9) {
            digits[i--] = 0;
        }
        if(i >= 0)
            digits[i]++;
        else {
            digits = new int[len + 1];
            digits[0] = 1;
        }
        return digits;
    }     
}
