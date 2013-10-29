/*
 * Validate if a given string is numeric.

 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up 
 * front before implementing one.
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) != ' ' && s.charAt(j) != ' ')
                break;
            if(s.charAt(i) == ' ')
                i++;
            if(s.charAt(j) == ' ')
                j--;
        }
        s = s.substring(i, j + 1);
        boolean hasDot = false, hasE = false, hasNum = false;
        for(int k = 0; k < s.length(); k++) {
            if(s.charAt(k) == '-' || s.charAt(k) == '+') {
            	if(k == s.length() - 1 || k > 0 && s.charAt(k - 1) != 'e')
            		return false;
            }
            else if(s.charAt(k) == 'e') {
                if(hasE || k == s.length() - 1 || !hasNum || k == 0 || k == s.length() - 1)
                    return false;
                hasE = true;
            }
            else if(s.charAt(k) == '.') {
                if(hasE || hasDot || k == s.length() - 1 && !hasNum
                        || k < s.length() - 1 && (s.charAt(k + 1) == '+' || s.charAt(k + 1) == '-'))
                    return false;
                hasDot = true;
            }
            else if(s.charAt(k) - '0' >= 0 && s.charAt(k) - '0' <= 9)
                hasNum = true;
            else
                return false;
        }
        return true;
    }       
}
