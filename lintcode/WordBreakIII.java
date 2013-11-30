/*
Give a dictionary of words and a sentence with all whitespace removed, return
the number of sentences you can form by inserting whitespaces to the sentence
so that each word can be found in the dictionary.

Example
Given a String CatMat
Given a dictionary ["Cat", "Mat", "Ca", "tM", "at", "C", "Dog", "og", "Do"]
return 3

we can form 3 sentences, as follows:
CatMat = Cat Mat
CatMat = Ca tM at
CatMat = C at Mat
 */
public class WordBreakIII {

    /*
     * @param : A string
     * @param : A set of word
     * @return: the number of possible sentences.
     */
    public int wordBreak3(String s, Set<String> dict) {
        if (s == null || dict == null) {
            return 0;
        }
        List<List<String>> result = new ArrayList<List<String>>();
        dfs(s, dict, result, new ArrayList<String>(), 0, s.length());
        return result.size();
    }

    public void dfs(String s, Set<String> dict, List<List<String>> result,
            List<String> list, int start, int len) {
        if (start == len) {
            result.add(new ArrayList<String>(list));
        }
        for (int i = start; i < len; ++i) {
            if (dict.contains(s.substring(start, i + 1))) {
                list.add(s.substring(start, i + 1));
                dfs(s, dict, result, list, i + 1, len);
                list.remove(list.size() - 1);
            }
        }
    }

/*****************************************************************************/

    private int result = 0;

    public int wordBreak3(String s, Set<String> dict) {
        if (s == null || dict == null) {
            return 0;
        }
        wordBreakHelper(s, dict, 0, s.length());
        return result;
    }

    public void wordBreakHelper(String s, Set<String> dict, int start, int len) {
        if (start == len) {
            result++;
        }
        for (int i = start; i < len; ++i) {
            if (dict.contains(s.substring(start, i + 1))) {
                wordBreakHelper(s, dict, i + 1, len);
            }
        }
    }

}
