/*
 * Given a string containing only digits, restore it by returning all possible 
 * valid IP address combinations.

 * For example:
 * Given "25525511135",

 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class RestoreIPAddresses {

/**************************** updated 2014.04.09 *****************************/

    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        dfs(res, "", s, 4);
        return res;
    }

    public void dfs(ArrayList<String> res, String ip, String subStr, int n) {
        if (n == 0 && subStr.length() == 0) {
            res.add(ip);
        } else if (n > 0) {
            for (int i = 0; i < Math.min(subStr.length(), 3); i++) {
                if (i > 0 && subStr.charAt(0) == '0')  // heading zeros are not allowed.
                    continue;
                if (Integer.parseInt(subStr.substring(0, i + 1)) <= 255) {
                    String temp = ip;
                    ip += (n < 4 ? "." : "") + subStr.substring(0, i + 1);
                    dfs(res, ip, subStr.substring(i + 1), n - 1);
                    ip = temp;
                }
            }
        }
    }

}
