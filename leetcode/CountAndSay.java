/*
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...

 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.

 * Given an integer n, generate the nth sequence.

 * Note: The sequence of integers will be represented as a string.
 */
package info.mitcc.leetcode;

public class CountAndSay {
	public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(n == 1) 
			return "1";
		String output = "";
        String str = this.countAndSay(n - 1);
        int i = 0, j = 1;
        int len = str.length();
        while(j < len) {
        	if(str.charAt(i) != str.charAt(j)) {
        		output += (j - i) + "" + str.charAt(i);
        		i = j;
        		j++;
        	} else {
        		j++;
        	}
        }
        output += (len - i) + "" + str.charAt(i);
        return output;
    }
	public static void main(String[] args) {
		System.out.println(new CountAndSay().countAndSay(4));
	}
}
