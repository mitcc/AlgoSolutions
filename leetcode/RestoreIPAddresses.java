/*
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 * For example:
 * Given "25525511135",

 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class RestoreIPAddresses {
    public ArrayList<String> restoreIpAddresses(String s) {
        return helper(s, 4);
    }

    public ArrayList<String> helper(String s, int n) {
        ArrayList<String> result = new ArrayList<String>();
        if(s.length() <= 12 && s.length() != 0) {
            if(n == 1) {
                if(s.length() == 1 || s.charAt(0) != '0' && Long.parseLong(s) <= 255)
                    result.add(s);
            } else {
                for(int i = 1; i < s.length() && i <= 3; i++) {
                    String preStr = s.substring(0, i);
                    if(i > 1 && s.charAt(0) == '0')
                        continue;
                    ArrayList<String> temp = helper(s.substring(i, s.length()), n - 1);
                    if(Integer.parseInt(preStr) <= 255 && !temp.isEmpty()) {
                        for(String item : temp) {
                            result.add(preStr + "." + item);
                        }
                    }
                }
            }  
        } 
        return result;
    }
}
