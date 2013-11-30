/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        String result = "";
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousands = {"", "M", "MM", "MMM", "", "", "", "", "", ""};
        result = thousands[num / 1000 % 10] + hundreds[num / 100 % 10] 
            + tens[num / 10 % 10] + ones[num % 10];
        return result;
    }

/*****************************************************************************/

    public String intToRoman(int num) {
        Map<Integer, Character> map = new HashMap<Integer, Character>();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');
        String result = "";
        for (int base = 1; base <= num; base *= 10) {
            int last = num / base % 10;
            if (1 <= last && last <= 3 || 6 <= last && last <= 8) {
                for (int i = 1; i <= last % 5; ++i) {
                    result = map.get(base) + result;
                }
            }
            if (5 <= last && last <= 8) {
                result = map.get(5 * base) + result;
            }
            if (last % 5 == 4) {
                result = "" + map.get(base) + map.get((last + 1) * base) + result;
            }
        }
        return result;
    }

}
