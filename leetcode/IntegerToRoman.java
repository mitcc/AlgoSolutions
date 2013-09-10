/*
 * Given an integer, convert it to a roman numeral.

 * Input is guaranteed to be within the range from 1 to 3999.
 * I = 1;
 * V = 5;
 * X = 10;
 * L = 50;
 * C = 100;
 * D = 500;
 * M = 1000;
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] huns = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thos = {"", "M", "MM", "MMM", "", "", "", "", "", ""};

        String result = "";
        result += thos[num / 1000];
        result += huns[num % 1000 / 100];
        result += tens[num % 100 / 10];
        result += ones[num % 10];
        return result;
    }
}
