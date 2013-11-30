/*
 * Given a roman numeral, convert it to an integer.

 * Input is guaranteed to be within the range from 1 to 3999.
 * I = 1;
 * V = 5;
 * X = 10;
 * L = 50;
 * C = 100;
 * D = 500;
 * M = 1000;
 *
 * the numeral I can be placed before V and X to make 4 units (IV) and 9 units 
 * (IX respectively)
 * X can be placed before L and C to make 40 (XL) and 90 (XC respectively)
 * C can be placed before D and M to make 400 (CD) and 900 (CM) according to 
 * the same pattern
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = map.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            result += (map.get(s.charAt(i)) < map.get(s.charAt(i + 1)) ? 
                    -1 : 1) * map.get(s.charAt(i));
        }
        return result;
    }
}
