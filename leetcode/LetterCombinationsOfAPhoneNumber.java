/*
 * Given a digit string, return all possible letter combinations that the number could represent.

 * A mapping of digit to letters (just like on the telephone buttons) is given below.

 * http://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/

 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want. 
 */
public class LetterCombinationsOfAPhoneNumber {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        if(digits.length() == 0) {
            result.add("");
            return result;
        }
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        ArrayList<String> list3 = new ArrayList<String>();
        ArrayList<String> list4 = new ArrayList<String>();
        ArrayList<String> list5 = new ArrayList<String>();
        ArrayList<String> list6 = new ArrayList<String>();
        ArrayList<String> list7 = new ArrayList<String>();
        ArrayList<String> list8 = new ArrayList<String>();
        ArrayList<String> list9 = new ArrayList<String>();
        ArrayList<String> list0 = new ArrayList<String>();
        list2.add("a");
        list2.add("b");
        list2.add("c");
        list3.add("d");
        list3.add("e");
        list3.add("f");
        list4.add("g");
        list4.add("h");
        list4.add("i");
        list5.add("j");
        list5.add("k");
        list5.add("l");
        list6.add("m");
        list6.add("n");
        list6.add("o");
        list7.add("p");
        list7.add("q");
        list7.add("r");
        list7.add("s");
        list8.add("t");
        list8.add("u");
        list8.add("v");
        list9.add("w");
        list9.add("x");
        list9.add("y");
        list9.add("z");
        list1.add("");
        list0.add(" ");
    
        ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
        lists.add(list0);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        lists.add(list5);
        lists.add(list6);
        lists.add(list7);
        lists.add(list8);
        lists.add(list9);

        if(digits.length() == 1)
            return lists.get(Integer.parseInt(digits));
        ArrayList<String> firstChar = lists.get(digits.charAt(0) - '0');
        ArrayList<String> sub = letterCombinations(digits.substring(1));
        for(int i = 0; i < firstChar.size(); i++) {
            for(int j = 0; j < sub.size(); j++) {
                String temp = firstChar.get(i);
                temp += sub.get(j);
                result.add(temp);
            }
        }
        return result;
    }
}
