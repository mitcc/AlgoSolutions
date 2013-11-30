/*
 * Given an array of strings, return all groups of strings that are anagrams.

Example
Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].

Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].

Note
All inputs will be in lower-case
 */
public class Anagrams {

    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        Map<String, String> map = new HashMap<String, String>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String s = new String(array);
            if (!map.containsKey(s)) {
                map.put(s, str);
            } else {
                if (map.get(s) != null) {
                    result.add(map.get(s));
                    map.put(s, null);
                }
                result.add(str);
            }
        }
        return result; 
    }

}
