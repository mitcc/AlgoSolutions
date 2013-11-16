/*
 * Given numRows, generate the first numRows of Pascal's triangle.

 * For example, given numRows = 5,
 * Return

 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(numRows <= 0)
            return res;
        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(1);
        res.add(first);
        for(int i = 2; i <= numRows; i++) {
            ArrayList<Integer> prev = res.get(i - 2), next = new ArrayList<Integer>();
            next.add(1);
            for(int j = 1; j < i - 1; j++) 
                next.add(prev.get(j - 1) + prev.get(j));
            next.add(1);
            res.add(next);
        }
        return res;
    }
}
