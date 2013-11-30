/*
 * You are given a string, s, and a list of words, words, that are all of the 
 * same length. Find all starting indices of substring(s) in s that is a 
 * concatenation of each word in words exactly once and without any intervening 
 * characters.
 *
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 *
 * You should return the indices: [0,9].
 * (order does not matter).
 */
public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        Map<String, Integer> toFind = new HashMap<String, Integer>();
        for (String word : words) {
            toFind.put(word, toFind.containsKey(word) ? 
                    toFind.get(word) + 1 : 1);
        }
        for (int i = 0; i <= s.length() - words.length * words[0].length(); 
                ++i) {
            Map<String, Integer> found = new HashMap<String, Integer>();
            int j;
            for (j = 0; j < words.length; ++j) {
                int k = i + j * words[0].length();
                String sub = s.substring(k, k + words[0].length());
                if (!toFind.containsKey(sub))
                    break;
                found.put(sub, found.containsKey(sub) ? 
                        found.get(sub) + 1 : 1);
                if (found.get(sub) > toFind.get(sub))
                    break;
            }
            if (j == words.length)
                result.add(i);
        }
        return result;
    }

}
