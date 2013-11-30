/*
 * Print numbers from 1 to the largest number with N digits by recursion.

 Notice

It's pretty easy to do recursion like:

recursion(i) {
    if i > largest number:
        return
    results.add(i)
    recursion(i + 1)
}
however this cost a lot of recursion memory as the recursion depth maybe very 
large. Can you do it in another way to recursive with at most N depth?

Example
Given N = 1, return [1,2,3,4,5,6,7,8,9].

Given N = 2, return [1,2,3,4,5,6,7,8,9,10,11,12,...,99].

Challenge 
Do it in recursion, not for-loop.
 */
public class PrintNumbersByRecursion {

    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        List<Integer> result = new ArrayList<Integer>();
        recursionHelper(0, n, result);
        return result;
    }

    public void recursionHelper(int depth, int n, List<Integer> result) {
        if (depth == n) {
            return;
        }
        if (depth == 0) {
            for (int i = 1; i <= 9; ++i) {
                result.add(i);
            }
        } else {
            int size = result.size();
            for (int i = 1; i <= 9; ++i) {
                int base = i * (int) Math.pow(10, depth);
                result.add(base);
                for (int j = 0; j < size; ++j) {
                    result.add(base + result.get(j));
                }
            }
        }
        recursionHelper(depth + 1, n, result);
    }

}
