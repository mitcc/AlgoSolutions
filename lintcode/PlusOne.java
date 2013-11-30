/*
 * Given a non-negative number represented as an array of 
 * digits, plus one to the number.

The digits are stored such that the most significant digit 
is at the head of the list.

Example
Given [1,2,3] which represents 123, return [1,2,4].

Given [9,9,9] which represents 999, return [1,0,0,0].
 */
public class PlusOne {

    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        for (; i >= 0 && digits[i] == 9; --i) {
            digits[i] = 0;
        }
        if (i < 0) {
            digits = new int[digits.length + 1];
            i = 0;
        }
        digits[i] += 1;
        return digits;
    }

}
