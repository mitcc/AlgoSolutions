/*
 * Given a number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head 
 * of the list.
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int carrier = 1;
        for (int i = digits.length - 1; i >= 0 && carrier > 0; i--) {
            digits[i] = (digits[i] + carrier) % 10;
            carrier = digits[i] == 0 ? 1 : 0;
        }
        if (carrier > 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }

/********************************************************************/

    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while (i >= 0 && digits[i] == 9) {
            digits[i--] = 0;
        }
        if (i >= 0)
            digits[i] += 1;
        else {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }

}
