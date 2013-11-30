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

/******************************** updated 20141027 ***************************/

    public String intToRoman(int num) {
        public String intToRoman(int num) {
        String result = "";
        String[] roman = {"I", "V", "X", "L", "C", "D", "M"};
        int i = 0; 
        while (num > 0) {
            int lowBit = num % 10;
            if (lowBit == 4 || lowBit == 9)
                result = roman[2 * i] + (lowBit == 4 ? roman[2 * i + 1] : 
                        roman[2 * i + 2]) + result;
            else {
                for (int j = 0; j < lowBit % 5; j++) 
                    result = roman[2 * i] + result;
                if (lowBit >= 5)
                    result = roman[2 * i + 1] + result;
            }
            num /= 10;
            i++;
        }
        return result;
    }
}
