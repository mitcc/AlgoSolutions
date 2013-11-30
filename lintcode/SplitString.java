/*
Give a string, you can choose to split the string after one character or two
adjacent characters, and make the string to be composed of only one character
or two characters. Output all possible results.

Example
Given the string "123"
return [["1","2","3"],["12","3"],["1","23"]]
 */
public class SplitString {

    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        dfs(s, result, new ArrayList<String>());
        return result;
    }

    public void dfs(String s, List<List<String>> result, List<String> list) {
        if (s.length() == 0) {
            result.add(new ArrayList<String>(list));
        }
        for (int i = 1; i <= Math.min(2, s.length()); ++i) {
            list.add(s.substring(0, i));
            dfs(s.substring(i), result, list);
            list.remove(list.size() - 1);
        }
    }

}
