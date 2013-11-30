/*
 * Given a pattern and a string str, find if str follows the same pattern.

 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 * Both pattern and str contains only lowercase alphabetical letters.
 * Both pattern and str do not have leading or trailing spaces.
 * Each word in str is separated by a single space.
 * Each letter in pattern must map to a word with length that is at least 1.
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map1 = new HashMap<Character, String>();
        Map<String, Character> map2 = new HashMap<String, Character>();
        String[] s = str.split(" ");
        if (pattern.length() != s.length)
            return false;
        for (int i = 0; i < s.length; ++i) {
            if (map1.containsKey(pattern.charAt(i)) && 
                    !map1.get(pattern.charAt(i)).equals(s[i]) || 
                    map2.containsKey(s[i]) && 
                    map2.get(s[i]) != pattern.charAt(i))
                return false;
            map1.put(pattern.charAt(i), s[i]);
            map2.put(s[i], pattern.charAt(i));
        }
        return true;
    }

}
