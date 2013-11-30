/*
 * Given an array of strings, return all groups of strings that are anagrams.

 * Note: All inputs will be in lower-case.
 * For example:

 * Input:¡¡¡¡["tea","and","ate","eat","den"]

 * Output:   ["tea","ate","eat"]
 * 
 */
public class Anagrams {

    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> res = new ArrayList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String s = new String(c);
            if (!map.containsKey(s)) {
                map.put(s, i);
            } else {
                if (map.get(s) >= 0) {
                    res.add(strs[map.get(s)]);
                    map.put(s, -1);
                }
                res.add(strs[i]);
            }
        }
        return res;
    }

}
