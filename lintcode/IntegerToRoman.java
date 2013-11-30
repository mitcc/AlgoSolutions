/*
 * Given an integer, convert it to a roman numeral.

The number is guaranteed to be within the range from 1 to 3999.

Example
4 -> IV

12 -> XII

21 -> XXI

99 -> XCIX

more examples at: http://literacy.kent.edu/Minigrants/Cinci/romanchart.htm

Clarification
What is Roman Numeral?

https://en.wikipedia.org/wiki/Roman_numerals
https://zh.wikipedia.org/wiki/%E7%BD%97%E9%A9%AC%E6%95%B0%E5%AD%97
http://baike.baidu.com/view/42061.htm
 */
public class IntegerToRoman {

    /**
     * @param n The integer
     * @return Roman representation
     */
    public String intToRoman(int n) {
        String[] ones = {"", "I", "II", "III", 
            "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = {"", "X", "XX", "XXX", 
            "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundreds = {"", "C", "CC", "CCC", 
            "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousands = {"", "M", "MM", "MMM",
            "", "", "", "", "", ""};

        String result = thousands[n / 1000 % 10];
        result += hundreds[n / 100 % 10];
        result += tens[n / 10 % 10];
        result += ones[n % 10];
        return result;
    }

/*****************************************************************************/

    public String intToRoman(int n) {
        String result = "";
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        int base = 1;
        while (n >= base) {
            int number = n / base % 10;
            if (0 < number && number <= 3 || 6 <= number && number <= 8) {
                for (int i = 0; i < number % 5; ++i) {
                    result = map.get(base) + result;
                }
            }
            if (5 <= number && number <= 8) {
                result = map.get(5 * base) + result;
            }
            if (number % 5 == 4) {
                result = map.get(base) + map.get((number + 1) * base) + result;
            }
            base *= 10;
        }
        return result;
    }

}
