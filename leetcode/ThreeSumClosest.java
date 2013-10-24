/*
 * Given an array S of n integers, find three integers in S such that 
 * the sum is closest to a given number, target. Return the sum of the 
 * three integers. You may assume that each input would have exactly 
 * one solution.

 *     For example, given array S = {-1 2 1 -4}, and target = 1.

 *     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(num);
        for(int i = 0; i < num.length - 2; i++) {
            int left = i + 1, right = num.length - 1;
            while(left < right) {
                int threeSum = num[i] + num[left] + num[right];
                if(threeSum == target)
                    return target;
                else if(threeSum < target)
                    left++;
                else 
                    right--;
                if(result == Integer.MAX_VALUE || Math.abs(result - target) > Math.abs(threeSum - target))
                    result = threeSum;
            }
        }
        return result;
    }
}
