/*
 * Design a data structure that supports the following two operations: 
 * addWord(word) and search(word)

search(word) can search a literal word or a regular expression string 
containing only letters a-z or ..

A . means it can represent any one letter.

 Notice

You may assume that all words are consist of lowercase letters a-z.

Example
addWord("bad")
addWord("dad")
addWord("mad")
search("pad")  // return false
search("bad")  // return true
search(".ad")  // return true
search("b..")  // return true
 */
public class AddAndSearchWord {

    TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isLeaf = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
        return dfs(root, word);
    }

    public boolean dfs(TrieNode root, String s) {
        if (s == null) {
            return false;
        }
        if (s.equals("")) {
            return root.isLeaf;
        }
        if (s.charAt(0) != '.') {
            return root.children[s.charAt(0) - 'a'] != null 
                && dfs(root.children[s.charAt(0) - 'a'], s.substring(1));
        } else {
            for (int i = 0; i < 26; ++i) {
                if (root.children[i] != null 
                        && dfs(root.children[i], s.substring(1))) {
                    return true;
                }
            }
            return false;
        }
    }

}
// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");

class TrieNode {

    TrieNode[] children;
    boolean isLeaf;

    public TrieNode() {
        children = new TrieNode[26];
        isLeaf = false;
    }

}
