public class ZigZagConversion {
    public String convert(String s, int nRows) {
        if(nRows == 1)
            return s;
        int len = s.length();
        int zigZagCount = s.length() / (2 * nRows - 2);
        String result = "";
        for(int i = 0; i < nRows; i++) {
            for(int j = 0; j < zigZagCount; j++) {
                if(i == 0 || i == nRows - 1)
                    result += s.charAt(j * (2 * nRows - 2) + i);
                else
                    result += s.charAt(j * (2 * nRows - 2) + i) + s.charAt(j * (2 * nRows - 2) + 2 * nRows - 2 - i);
            }
            if(zigZagCount * (2 * nRows - 2) + i < s.length())
                result += s.charAt(zigZagCount * (2 * nRows - 2) + i);
            if(zigZagCount * (2 * nRows - 2) + 2 * nRows - 2 - i < s.length())
                result += s.charAt(zigZagCount * (2 * nRows - 2) + 2 * nRows - 2 - i);
        }
        return result;
    }
}
