/*
 * Compare two strings A and B, determine whether A contains 
 * all of the characters in B.

The characters in string A and B are all Upper Case letters.

Example
For A = "ABCD", B = "ACD", return true.

For A = "ABCD", B = "AABC", return false.

Note
The characters of B in A are not necessary continuous or 
ordered.
 */
public class CompareStrings {

    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters 
     * in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        int[] chars = new int[256];
        for (int i = 0; i < A.length(); ++i) {
            ++chars[A.charAt(i)];
        }
        for (int i = 0; i < B.length(); ++i) {
            if (--chars[B.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

}
