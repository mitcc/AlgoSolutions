/* 
 * Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 */
public class ImplementstrStr {
    public String strStr(String haystack, String needle) {
        if(needle.length() == 0 || haystack.equals(needle))
            return haystack;
        int i = 0, j = 0;
        for(; i <= haystack.length() - needle.length() && j < needle.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                for(; j < needle.length(); j++) {
                    if(haystack.charAt(i + j) != needle.charAt(j)) {
                        j = 0;
                        break;
                    }
                }
            }
        }
        return j == needle.length() ? haystack.substring(i - 1) : null;
    }
}
