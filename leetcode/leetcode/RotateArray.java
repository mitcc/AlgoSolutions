/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
[5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different
ways to solve this problem.

[show hint]

Hint:
Could you do it in-place with O(1) extra space?
Related problem: Reverse Words in a String II
 */
public class RotateArray {

    // O(n) time, O(1) space.
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = (k % len + len) % len;
        reverse(nums, 0, len - 1 - k);
        reverse(nums, len - k, len - 1);
        reverse(nums, 0, len - 1);
    }

    public void reverse(int[] nums, int low, int high) {
        if (nums == null || nums.length == 0 || low < 0
                || high >= nums.length || low > high) {
            return;
        }
        for (int i = low; i <= (low + high) / 2; ++i) {
            int tmp = nums[i];
            nums[i] = nums[low + high - i];
            nums[low + high - i] = tmp;
        }
    }

/*****************************************************************************/

    // O(n) time, O(1) space.
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int gcd = gcd(len, k);
        for (int i = 0; i < gcd; ++i) {
            int tmp = nums[len - 1 - i];
            for (int j = 0; j < len / gcd - 1; ++j) {
                nums[((len - 1 - i - j * k) % len + len) % len]
                    = nums[((len - 1 - i - (j + 1) * k) % len + len) % len];
            }
            nums[((len - 1 - i - (len / gcd - 1) * k) % len + len) % len] = tmp;
        }
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
