/*
 * Given an absolute path for a file (Unix-style), simplify it.

 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * click to show corner cases.
 * 
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes 
 * '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return 
 * "/home/foo".
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        String[] pathElems = path.split("/");
        LinkedList<String> list = new LinkedList<String>();
        for (String pathElem : pathElems) {
            if (pathElem.equals("..")) {
                if (list.size() > 0)
                    list.removeLast();
            } else if (!pathElem.equals("") && !pathElem.equals(".")) {
                list.add(pathElem);
            }
        }
        String result = "";
        for (int i = 0; i < list.size(); ++i) {
            result += "/" + list.get(i);
        }
        if (result.length() == 0)
            result += "/";
        return result;
    }

}
