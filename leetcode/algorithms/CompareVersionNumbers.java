/*
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 
 * return -1, otherwise return 0.
 * 
 * You may assume that the version strings are non-empty 
 * and contain only digits and the . character.
 * The . character does not represent a decimal point and 
 * is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way 
 * to version three", it is the fifth second-level revision 
 * of the second first-level revision.
 * 
 * Here is an example of version numbers ordering:
 * 
 * 0.1 < 1.1 < 1.2 < 13.37
 */
public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] array1 = version1.split("\\.");
        String[] array2 = version2.split("\\.");
        for (int i = 0; i < Math.max(array1.length, array2.length); i++) {
            if (i < array1.length && i < array2.length && 
                    Integer.parseInt(array1[i]) > Integer.parseInt(array2[i]) || 
                    i == array2.length && Integer.parseInt(array1[i]) != 0)
                return 1;
            else if (i < array1.length && i < array2.length && 
                    Integer.parseInt(array1[i]) < Integer.parseInt(array2[i]) || 
                    i == array1.length && Integer.parseInt(array2[i]) != 0)
                return -1;
        }
        return 0;
    }

/*****************************************************************************/

    public int compareVersion(String version1, String version2) {
        int end1 = 0;
        int end2 = 0;
        if (version1.length() == 0) {
            if (version2.length() == 0)
                return 0;
            else {
                for (; end2 < version2.length() && version2.charAt(end2) != '.'; end2++);
                int b = end2 == 0 ? 0 : Integer.parseInt(version2.substring(0, end2));
                if (b > 0)
                    return -1;
                else if (end2 == version2.length())
                    return 0;
                else
                    return compareVersion(version1, version2.substring(end2 + 1));
            }

        }
        if (version2.length() == 0) {
            if (version1.length() == 0)
                return 0;
            else {
                for (; end1 < version1.length() && version1.charAt(end1) != '.'; end1++);
                int a = end1 == 0 ? 0 : Integer.parseInt(version1.substring(0, end1));
                if (a > 0)
                    return 1;
                else if (end1 == version1.length())
                    return 0;
                else
                    return compareVersion(version1.substring(end1 + 1), version2);
            }
        }
        while (true) {
            for (; end1 < version1.length() && version1.charAt(end1) != '.'; end1++);
            for (; end2 < version2.length() && version2.charAt(end2) != '.'; end2++);
            int a = Integer.parseInt(version1.substring(0, end1));
            int b = Integer.parseInt(version2.substring(0, end2));
            if (a > b)
                return 1;
            else if (a < b)
                return -1;
            else {
                end1 = end1 == version1.length() ? end1 : end1 + 1;
                end2 = end2 == version2.length() ? end2 : end2 + 1;
                return compareVersion(version1.substring(end1), version2.substring(end2));
            }
        }
    }

}
