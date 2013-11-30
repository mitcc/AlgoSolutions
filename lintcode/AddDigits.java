/*
Given a non-negative integer num, repeatedly add all its digits until the 
result has only one digit.

Example
Given num = 38.
The process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return 
2.

Challenge 
Could you do it without any loop/recursion in O(1) runtime?
 */
public class AddDigits {

    /**
     * @param num a non-negative integer
     * @return one digit
     */
    // O(1) time.
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

/*****************************************************************************/

    public int addDigits(int num) {
        while (num >= 10) {
            num = sumOfDigits(num);
        }
        return num;
    }

    public int sumOfDigits(int num) {
        int sum = 0;
        for (; num != 0; num /= 10) {
            sum += num % 10;
        }
        return sum;
    }

}
