/*
 * Given a positive integer, return its corresponding 
 * column title as appear in an Excel sheet.

 * For example:

 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB 
 * 
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        String result = "";
        long exp = 1;
        while (n > 0) {
            int remainder = (int) (n % (26 * exp));
            if (remainder == 0)
                remainder = (int) (26 * exp);
            result = (char) (remainder / (int) exp + 64) + result;
            n -= remainder;
            exp *= 26;
        }
        return result;
    }

/*******************************************************************/

    public String convertToTitle(int n) {
        String result = "";
        while (n > 0) {
            result = (char) (65 + (n - 1) % 26) + result;
            n = (n - 1) / 26;
        }
        return result;
    }

}
