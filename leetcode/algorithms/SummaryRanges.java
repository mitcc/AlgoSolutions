/*
 * Given a sorted integer array without duplicates, return the 
 * summary of its ranges.
 *
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < nums.length; i++) {
            int start = i;
            for (; i + 1 < nums.length && nums[i] + 1 == nums[i + 1]; i++);
            String range = "" + nums[start];
            if (start < i)
                range += "->" + nums[i];
            result.add(range);
        }
        return result;
    }

}
