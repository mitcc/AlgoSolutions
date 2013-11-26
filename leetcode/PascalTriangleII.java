/*
 * Given an index k, return the kth row of the Pascal's triangle.

 * For example, given k = 3,
 * Return [1,3,3,1].

 * Note:
 * Could you optimize your algorithm to use only O(k) extra space? 
 */
public class PascalTriangleII {
/**************************** updated 2013/11/26 *********************/
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<Integer>(), temp = new ArrayList<Integer>();
        res.add(1);
        temp.add(1);
        temp.add(1);
        for(int i = 1; i <= rowIndex; i++) {
            res = new ArrayList<Integer>();
            res.add(1);
            for(int j = 0; j <= i - 2; j++) 
                res.add(temp.get(j) + temp.get(j + 1));
            res.add(1);
            temp = res;
        }
        return res;
    }

/*********************************************************************/

    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(1);
        if(rowIndex > 0) {
            ArrayList<Integer> temp = getRow(rowIndex - 1);
            for(int i = 0; i <= rowIndex - 2; i++) 
                res.add(temp.get(i) + temp.get(i + 1));
            res.add(1);
        }
        return res;
    }
}
