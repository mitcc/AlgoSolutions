/*
Given a integer c, your task is to decide whether there're two integers a and b
such that a^2 + b^2 = c.

Example
Given n = 5
Return true // 1 * 1 + 2 * 2 = 5

Given n = -5
Return false
 */
public class CheckSumOfSquareNumbers {

    /*
     * @param : the given number
     * @return: whether whether there're two integers
     */
    public boolean checkSumOfSquareNumbers(int num) {
        if (num < 0) {
            return false;
        }
        int i = 0;
        int j = (int) Math.sqrt(num);
        while (i <= j) {
            int sum = i * i + j * j;
            if (sum == num) {
                return true;
            } else if (sum < num) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

/*****************************************************************************/

    // TLE
    public boolean checkSumOfSquareNumbers(int num) {
        for (int i = 0; i * i <= num; ++i) {
            int delta = num - i * i;
            int sqrt = (int) Math.sqrt(delta);
            if (sqrt * sqrt == delta) {
                return true;
            }
        }
        return false;
    }

/*****************************************************************************/

    // TLE
    public boolean checkSumOfSquareNumbers(int num) {
        if (num < 0) {
            return false;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i * i <= num; ++i) {
            set.add(i * i);
            if (set.contains(num - i * i)) {
                return true;
            }
        }
        return false;
    }

/*****************************************************************************/

    // OOM
    public boolean checkSumOfSquareNumbers(int num) {
        if (num < 0) {
            return false;
        }
        boolean[] isSquare = new boolean[num + 1];
        isSquare[0] = true;
        for (int i = 1; i * i <= num; ++i) {
            isSquare[i * i] = true;
        }
        for (int i = 0; i * i <= num; ++i) {
            int delta = num - i * i;
            if (isSquare[delta]) {
                return true;
            }
        }
        return false;
    }

}
