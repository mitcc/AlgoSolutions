/*
 * Given an array S of n integers, find three integers in S such that the sum 
 * is closest to a given number, target. Return the sum of the three integers.

Example
For example, given array S = {-1 2 1 -4}, and target = 1. The sum that is 
closest to the target is 2. (-1 + 2 + 1 = 2).

Note
You may assume that each input would have exactly one solution.

Challenge
O(n^2) time, O(1) extra space
 */
public class ThreeSumClosest {

    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; ++i) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int low = i + 1;
            int high = numbers.length - 1;
            while (low < high) {
                int sum = numbers[i] + numbers[low] + numbers[high];
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    low++;
                } else if (sum > target) {
                    high--;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;    
                }
            }
        }
        return result;
    }

}
