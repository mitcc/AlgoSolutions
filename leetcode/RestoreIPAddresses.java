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
        if(s.length() <= 3 * n && s.length() >= n) {
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




/*  public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        helper(result, 0, "", 0, s);
        return result;
    }

    public void helper(ArrayList<String> result, int part, String cur, int index, String s) {
        if(index == s.length() && part == 4) {
            result.add(cur.substring(0, cur.length() - 1));
            return ;
        }
        if(s.length() - index < 4 - part || s.length() - index > 3 * (4 - part))
            return ;
        int num = 0;
        for(int i = index; i < index + 3 && i < s.length(); i++) {
            num = 10 * num + s.charAt(i) - '0';
            if(num <= 255) 
                helper(result, part + 1, cur + Integer.toString(num) + ".", i + 1, s);
            if(num == 0)
                break;
        }
    }
*/
}
