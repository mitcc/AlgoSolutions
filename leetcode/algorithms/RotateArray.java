/*
 * Rotate an array of n elements to the right by k steps.

 * For example, with n = 7 and k = 3, the array [1,2,3,4,
 * 5,6,7] is rotated to [5,6,7,1,2,3,4].

 * Note:
 * Try to come up as many solutions as you can, there are 
 * at least 3 different ways to solve this problem.
 */
public class RotateArray {
/********************* O(n) time, O(k) space ***********************/

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int[] tmp = new int[k];
        for (int i = 0; i < k; i++) {
            tmp[i] = nums[nums.length - k + i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            nums[i] = i >= k ? nums[i - k] : tmp[i];
        }
    }

/******************* O(k * n) time, O(1) space *********************/

    public void rotate(int[] nums, int k) {
		k %= nums.length;
		for (int i = 0; i < k; i++) {
			int tmp = nums[nums.length - 1];
			for (int j = nums.length - 1; j >= 0; j--) {
				nums[j] = j > 0 ? nums[j - 1] : tmp;
			}
		}
	}

/************************** O(n) time, O(1) space ******************/
    
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < gcd(nums.length, k); i++) {
            int tmp = nums[i];
            int j = i;
            while (true) {
                int p = (j + nums.length - k % nums.length) % nums.length;
                if (p == i)
                    break;
                nums[j] = nums[p];
                j = p;
            }
            nums[j] = tmp;
        }
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a;
            a = b;
            b = tmp % a;
        }
        return a;
    }

}
