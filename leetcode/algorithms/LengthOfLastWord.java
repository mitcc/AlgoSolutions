/*
 * Given a string s consists of upper/lower-case alphabets and empty space 
 * characters ' ', return the length of last word in the string.

 * If the last word does not exist, return 0.

 * Note: A word is defined as a character sequence consists of non-space 
 * characters only.

 * For example, 
 * Given s = "Hello World",
 * return 5.
 */

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0)
            return 0;
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }

/*****************************************************************************/
	
	public int lengthOfLastWord(String s) {
		if(s.length() == 0)
			return 0;
		String[] arrays = s.split(" ");
		if(arrays.length == 0)
			return 0;
		return arrays[arrays.length - 1].length();
	}
}
