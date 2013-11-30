/*
 * You know what, left pad is javascript package and referenced by React: 
Github link

One day his author unpublished it, then a lot of javascript projects in the 
world broken.

You can see from github it's only 11 lines.

You job is to implement the left pad function. If you do not know what left 
pad does, see examples below and guess.

Example
leftpad("foo", 5)
>> "  foo"

leftpad("foobar", 6)
>> "foobar"

leftpad("1", 2, "0")
>> "01"
 */
public class LeftPad {

    /**
     * @param originalStr the string we want to append to with spaces
     * @param size the target length of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size - originalStr.length(); ++i) {
            sb.append(" ");
        }
        return sb.toString() + originalStr;
    }

    /**
     * @param originalStr the string we want to append to
     * @param size the target length of the string
     * @param padChar the character to pad to the left side of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size, char padChar) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size - originalStr.length(); ++i) {
            sb.append(padChar);
        }
        return sb.toString() + originalStr;
    }

}
