/*
 * Given an array S of n integers, are there elements a, b, c in S such that 
 * a + b + c = 0? Find all unique triplets in the array which gives the sum of 
 * zero.

Example
For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:

(-1, 0, 1)
(-1, -1, 2)
Note
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ¡Ü b ¡Ü c)

The solution set must not contain duplicate triplets.
 */
public class ThreeSum {

    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> result = 
            new ArrayList<ArrayList<Integer>>();
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; ++i) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int low = i + 1;
            int high = numbers.length - 1;
            while (low < high) {
                if (numbers[i] + numbers[low] + numbers[high] == 0) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(numbers[i]);
                    list.add(numbers[low]);
                    list.add(numbers[high]);
                    result.add(list);
                    do {
                        low++;
                    } while (low < high && numbers[low] == numbers[low - 1]);
                    do {
                        high--;
                    } while (low < high && numbers[high] == numbers[high + 1]);
                } else if (numbers[i] + numbers[low] + numbers[high] < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return result;
    }

}
