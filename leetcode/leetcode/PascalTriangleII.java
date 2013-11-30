/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        for (int k = 0, nCk = 1; k <= rowIndex; ++k) {
            result.add(nCk);
            nCk = (int) ((long) nCk * (rowIndex - k) / (k + 1)); 
        }
        return result;
    }

}
