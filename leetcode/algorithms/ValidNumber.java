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
        s = s.trim();
        if(s.equals(""))
           return false; 
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
