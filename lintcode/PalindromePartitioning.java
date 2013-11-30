/*
 * Medium Palindrome Partitioning

22% Accepted
Given a string s, partition s such that every 
substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example
Given s = "aab", return:

[
  ["aa","b"],
  ["a","a","b"]
]
 */
public class PalindromePartitioning {

    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (isPalindrome(s)) {
            List<String> list = new ArrayList<String>();
            list.add(s);
            result.add(list);
        }
        for (int i = 1; i < s.length(); ++i) {
            if (isPalindrome(s.substring(0, i))) {
                for (List<String> list : partition(s.substring(i))) {
                    list.add(0, s.substring(0, i));
                    result.add(list);
                }
            }
        }
        return result;
    }

    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; ++i) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
