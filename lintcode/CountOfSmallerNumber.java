/*
 * Give you an integer array (index from 0 to n-1, where n is the size of this 
 * array, value from 0 to 10000) and an query list. For each query, give you an 
 * integer, return the number of element in the array that are smaller than the 
 * given integer.

 Notice

We suggest you finish problem Segment Tree Build and Segment Tree Query II 
first.

Example
For array [1,2,7,8,5], and queries [1,8,5], return [0,4,2]

Challenge 
Could you use three ways to do it.

Just loop
Sort and binary search
Build Segment Tree and Search.
 */
public class CountOfSmallerNumber {

    /**
     * @param A: An integer array
     * @return: The number of element in the array that 
     *          are smaller that the given integer
     */
    // TODO


/*****************************************************************************/

    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (queries == null || queries.length == 0) {
            return result;
        }
        for (int query : queries) {
            int count = 0;
            for (int a : A) {
                count += a < query ? 1 : 0;
            }
            result.add(count);
        }
        return result;
    }

}
