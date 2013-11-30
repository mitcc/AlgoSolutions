/*
 * Given an index k, return the kth row of the Pascal's triangle.

 * For example, given k = 3,
 * Return [1,3,3,1].

 * Note:
 * Could you optimize your algorithm to use only O(k) extra space? 
 */
public class PascalTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
		int nCk = 1;
		for (int k = 0; k <= rowIndex; k++) {
			result.add(nCk);
			nCk = (int) ((long) nCk * (rowIndex - k) / (k + 1));
		}
		return result;
    }

/*********************************************************************/

    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(1);
        if (rowIndex > 0) {
            ArrayList<Integer> temp = getRow(rowIndex - 1);
            for (int i = 0; i <= rowIndex - 2; i++) 
                res.add(temp.get(i) + temp.get(i + 1));
            res.add(1);
        }
        return res;
    }

}
