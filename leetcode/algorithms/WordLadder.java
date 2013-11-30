/*
 * Given two words (beginWord and endWord), and a dictionary's word list, find 
 * the length of shortest transformation sequence from beginWord to endWord, 
 * such that:

 * Only one letter can be changed at a time
 * Each intermediate word must exist in the word list
 * For example,
 * 
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, 
            Set<String> wordList) {
        Queue<String> queue = new LinkedList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        queue.offer(beginWord);
        map.put(beginWord, 1);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            int distance = map.get(cur);
            for (int i = 0; i < cur.length(); ++i) {
                for (char c = 'a'; c <= 'z'; ++c) {
                    if (c == cur.charAt(i))
                        continue;
                    char[] array = cur.toCharArray();
                    array[i] = c;
                    String next = new String(array);
                    if (next.equals(endWord))
                        return distance + 1;
                    if (wordList.contains(next) && !map.containsKey(next)) {
                        queue.offer(next);
                        map.put(next, distance + 1);
                    }
                }
            }
        }
        return 0;
    }
}
