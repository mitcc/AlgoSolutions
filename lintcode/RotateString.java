/*
 * Given a string and an offset, rotate string by offset. 
 * (rotate from left to right)

Example
Given "abcdefg".

offset=0 => "abcdefg"
offset=1 => "gabcdef"
offset=2 => "fgabcde"
offset=3 => "efgabcd"
Challenge
Rotate in-place with O(1) extra memory.
 */
public class RotateString {

    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    // O(offset * n) time, O(1) space
    public void rotateString(char[] str, int offset) {
        if (str.length == 0) {
            return;
        }
        for (int i = 0; i < offset % str.length; ++i) {
            char tmp = str[str.length - 1];
            for (int j = str.length - 1; j > 0; --j) {
                str[j] = str[j - 1];
            }
            str[0] = tmp;
        }
    }

/*********************************************************/

    public void rotateString(char[] str, int offset) {
        if (str.length == 0) {
            return;
        }
        reverse(str, 0, str.length - 1);
        reverse(str, 0, offset % str.length - 1);
        reverse(str, offset % str.length, str.length - 1);
    }

    public void reverse(char[] array, int low, int high) {
        while (low < high) {
            swap(array, low++, high--);
        }
    }

    public void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
