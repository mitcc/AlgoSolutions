/*
 * Additive number is a string whose digits can form additive sequence.

 * A valid additive sequence should contain at least three numbers. Except for 
 * the first two numbers, each subsequent number in the sequence must be the 
 * sum of the preceding two.
 * 
 * For example:
 * "112358" is an additive number because the digits can form an additive 
 * sequence: 1, 1, 2, 3, 5, 8.
 * 
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * "199100199" is also an additive number, the additive sequence is: 1, 99, 
 * 100, 199.
 * 1 + 99 = 100, 99 + 100 = 199
 * Note: Numbers in the additive sequence cannot have leading zeros, so 
 * sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * 
 * Given a string containing only digits '0'-'9', write a function to determine 
 * if it's an additive number.
 * 
 * Follow up:
 * How would you handle overflow for very large input integers?
 */
public class AdditiveNumber {

    public boolean isAdditiveNumber(String num) {
        if (num == null) {
            return false;
        }
        if (num.length() == 0) {
            return true;
        }
        for (int i = 1; i < num.length(); ++i) {
            for (int j = i + 1; j < num.length(); ++j) {
                if (num.charAt(0) == '0' && i > 1 || num.charAt(i) == '0' && j > i + 1) {
                    continue;
                }
                String prev = num.substring(0, i);
                String cur = num.substring(i, j);
                int index = j;
                while (true) {
                    String next = "" + (Long.parseLong(prev) + Long.parseLong(cur));
                    if (index + next.length() == num.length() 
                            && next.equals(num.substring(index, index + next.length()))) {
                        return true;
                    }
                    if (index + next.length() > num.length() 
                            || !next.equals(num.substring(index, index + next.length()))) {
                        break;
                    }
                    prev = cur;
                    cur = next;
                    index += next.length();
                }
            }
        }
        return false;
    }

}
