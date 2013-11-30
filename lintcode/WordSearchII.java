/*
 * Given a matrix of lower alphabets and a dictionary. Find all words in the 
 * dictionary that can be found in the matrix. A word can start from any 
 * position in the matrix and go left/right/up/down to the adjacent position. 

Example
Given matrix:
doaf
agai
dcan
and dictionary:
{"dog", "dad", "dgdg", "can", "again"}

return {"dog", "dad", "can", "again"}


dog:
doaf
agai
dcan
dad:
doaf
agai
dcan
can:
doaf
agai
dcan
again:
doaf
agai
dcan
Challenge 
Using trie to implement your algorithm.
 */
public class WordSearchII {

    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public ArrayList<String> wordSearchII(char[][] board, 
            ArrayList<String> words) {
        Set<String> set = new HashSet<String>();
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                dfs(board, trie, set, isVisited, i, j, "");
            }
        }
        return new ArrayList<String>(set);
    }

    public void dfs(char[][] board, Trie trie, Set<String> set, 
            boolean[][] isVisited, int i, int j, String s) {
        if (i < 0 || i >= isVisited.length || j < 0 
                || j >= isVisited[0].length || isVisited[i][j]) {
            return;
        }
        s += board[i][j];
        if (!trie.startsWith(s)) {
            return;
        }
        if (trie.search(s)) {
            set.add(s);
        }
        isVisited[i][j] = true;
        dfs(board, trie, set, isVisited, i + 1, j, s);
        dfs(board, trie, set, isVisited, i - 1, j, s);
        dfs(board, trie, set, isVisited, i, j + 1, s);
        dfs(board, trie, set, isVisited, i, j - 1, s);
        isVisited[i][j] = false;
    }

}

class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isLeaf = true;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return cur.isLeaf;
    }

}

class TrieNode {

    TrieNode[] children;
    boolean isLeaf;

    public TrieNode() {
        children = new TrieNode[26];
        isLeaf = false;
    }

}
