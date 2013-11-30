/*
 * Given a roman numeral, convert it to an integer.

The answer is guaranteed to be within the range from 1 to 3999.

Example
IV -> 4

XII -> 12

XXI -> 21

XCIX -> 99

Clarification
What is Roman Numeral?

https://en.wikipedia.org/wiki/Roman_numerals
https://zh.wikipedia.org/wiki/%E7%BD%97%E9%A9%AC%E6%95%B0%E5%AD%97
http://baike.baidu.com/view/42061.htm
 */
public class RomanToInteger {

    /**
     * @param s Roman representation
     * @return an integer
     */
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = map.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; --i) {
            result += (map.get(s.charAt(i)) < map.get(s.charAt(i + 1)) ? -1 : 1)
                * map.get(s.charAt(i));
        }
        return result;
    }

}
