/*
 * Given a list of non negative integers, arrange them such 
 * that they form the largest number.

 Notice

The result may be very large, so you need to return a 
string instead of an integer.

Example
Given [1, 20, 23, 4, 8], the largest formed number is 
8423201.

Challenge 
Do it in O(nlogn) time complexity.
 */
public class LargestNumber {

    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    public String largestNumber(int[] num) {
        String[] str = new String[num.length];
        for (int i = 0; i < num.length; ++i) {
            str[i] = Integer.toString(num[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }
        int i = 0;
        for (; i < sb.length() && sb.charAt(i) == '0'; ++i);
        if (i == sb.length()) {
            i--;
        }
        sb.delete(0, i);
        return sb.toString();
    }

}
