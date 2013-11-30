/*
 * Given a non-negative integer num, repeatedly add all its 
 * digits until the result has only one digit.
 * 
 * For example:
 * 
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. 
 * Since 2 has only one digit, return it.
 * 
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 * 
 * Hint:
 * 
 * A naive implementation of the above process is trivial. 
 * Could you come up with other methods? Show More Hint 
 * 
 */
public class AddDigits {

    //https://en.wikipedia.org/wiki/Digital_root
    public int addDigits(int num) {
        //return num - (num - 1) / 9 * 9;
        return (num - 1) % 9 + 1;
    }

/*********************************************************/

    public int addDigits(int num) {
        while (num >= 10) {
            int digitSum = 0;
            while (num != 0) {
                digitSum += num % 10;
                num /= 10;
            }
            num = digitSum;
        }
        return num;
    }

}
