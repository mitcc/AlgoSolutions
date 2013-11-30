/*
 * Given an array and a value, remove all instances of that value in place and 
 * return the new length.

 * The order of elements can be changed. It doesn't matter what you leave 
 * beyond the new length.
 */
public class RemoveElement {

    public int removeElement(int[] A, int elem) {
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != elem)
                A[index++] = A[i];
        }
        return index;
    }

/*****************************************************************************/

    public int removeElement(int[] A, int elem) {
        int i = 0; 
        int j = A.length - 1;
        while (i <= j) {
            while (i < A.length && A[i] != elem) {
                i++;
            }
            while (j >= 0 && A[j] == elem) {
                j--;
            }
            if (i < j && A[i] == elem) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        return j + 1;
    }       
    
}
