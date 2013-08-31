/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like 
 * this: (you may want to display this pattern in a fixed font for better legibility)

 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:

 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR". 
 */
public class ZigZagConversion {
    public String convert(String s, int nRows) {
        if(nRows == 1)
            return s;
        int len = s.length();
        int zigZagCount = s.length() / (2 * nRows - 2);
        String result = "";
        for(int i = 0; i < nRows; i++) {
            for(int j = 0; j <= zigZagCount; j++) {
                if((i == 0 || i == nRows - 1) && j * (2 * nRows - 2) + i < s.length())
                    result += s.charAt(j * (2 * nRows - 2) + i);
                else {
                    if(j * (2 * nRows - 2) + i < s.length())
                        result += s.charAt(j * (2 * nRows - 2) + i);
                    if(j * (2 * nRows - 2) + 2 * nRows - 2 - i < s.length())
                        result += s.charAt(j * (2 * nRows - 2) + 2 * nRows - 2 - i);
            }
        }
        return result;
    }
}
