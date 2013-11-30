/*
 * Implement an algorithm to determine if a string 
 * has all unique characters.

Example
Given "abc", return true.

Given "aab", return false.

Challenge
What if you can not use additional data structures?
 */
public class UniqueCharacter {

    public boolean isUnique(String str) {
        boolean[] isUnique = new boolean[128];
        for (int i = 0; i < str.length(); ++i) {
            if (isUnique[str.charAt(i)]) 
                return false;
            isUnique[str.charAt(i)] = true;
        }
        return true;
    }

}
