/*
Given a digit string, return all possible letter combinations that the number 
could represent.

A mapping of digit to letters (just like on the telephone buttons) is given 
below.

http://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg
/200px-Telephone-keypad2.svg.png

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in 
any order you want.
 */
public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        Map<Character, String> map = new HashMap<Character, String>();
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        for (int i = 0; i < digits.length(); ++i) {
            if (result.size() == 0) {
                result.add("");
            }
            int size = result.size();
            for (int j = 0; j < size; ++j) {
                String s = result.remove(0);
                char c = digits.charAt(i);
                for (int k = 0; k < map.get(c).length(); ++k) {
                    result.add(s + map.get(c).charAt(k));
                }
            }
        }
        return result;
    }

}
