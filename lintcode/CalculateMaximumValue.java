/*
Given a string of numbers, write a function to find the maximum value from the
string, you can add a + or * sign between any two numbers.

Example
Given str = 01231, return 10
((((0 + 1) + 2) * 3) + 1) = 10 we get the maximum value 10

Given str = 891, return 73
As 8 * 9 * 1 = 72 and 8 * 9 + 1 = 73 so 73 is maximum.
 */
public class CalculateMaximumValue {

    /*
     * @param : the given string
     * @return: the maximum value
     */
    public int calcMaxValue(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < str.length(); ++i) {
            int value = str.charAt(i) - '0';
            result = Math.max(result + value, result * value);
        }
        return result;
    }

}
