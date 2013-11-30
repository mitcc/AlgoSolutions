/*
 * Given an array S of n integers, are there elements a, b, c, and d 
 * in S such that a + b + c + d = target?

Find all unique quadruplets in the array which gives the sum of target.

 Notice

Elements in a quadruplet (a,b,c,d) must be in non-descending order. 
(ie, a <= b <= c <= d)
The solution set must not contain duplicate quadruplets.

Example
Given array S = {1 0 -1 0 -2 2}, and target = 0. A solution set is:

(-1, 0, 0, 1)
(-2, -1, 1, 2)
(-2, 0, 0, 2)
 */
public class FourSum {

    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        ArrayList<ArrayList<Integer>> result = 
            new ArrayList<ArrayList<Integer>>();
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 3; ++i) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < numbers.length - 2; ++j) {
                if (j > i + 1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }
                int start = j + 1;
                int end = numbers.length - 1;
                while (start < end) {
                    int sum = numbers[i] + numbers[j] + 
                        numbers[start] + numbers[end];
                    if (sum < target) {
                        start++;
                    } else if (sum > target) {
                        end--;
                    } else {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[start++]);
                        list.add(numbers[end--]);
                        result.add(list);
                        while (start < end && 
                                numbers[start] == numbers[start - 1]) {
                            start++;
                        }
                        while (end > start && 
                                numbers[end] == numbers[end + 1]) {
                            end--;
                        }
                    }
                }
            }
        }
        return result;
    }

}
