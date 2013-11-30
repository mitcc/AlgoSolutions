/*
A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 
6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.


For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are 
currently on, return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", 
"0:16", "0:32"]
Note:
The order of output does not matter.
The hour must not contain a leading zero, for example "01:00" is not valid, it 
should be "1:00".
The minute must be consist of two digits and may contain a leading zero, for 
example "10:2" is not valid, it should be "10:02".
 */
public class BinaryWatch {

    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<String>();
        for (int hour = 0; hour < 12; ++hour) {
            for (int minute = 0; minute < 60; ++minute) {
                if (hammingWeight(hour) + hammingWeight(minute) == num) {
                    result.add(hour + ((minute < 10 ? ":0" : ":") + minute));
                }
            }
        }
        return result;
    }

    private int hammingWeight(int n) {
        n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n & 0x0f0f0f0f) + ((n >>> 4) & 0x0f0f0f0f); 
        n = (n & 0x00ff00ff) + ((n >>> 8) & 0x00ff00ff);
        return n;
    }

}
