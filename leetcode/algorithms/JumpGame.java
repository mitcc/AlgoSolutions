/*
 * Given an array of non-negative integers, you are initially 
 * positioned at the first index of the array.

 * Each element in the array represents your maximum 
 * jump length at that position.

 * Determine if you are able to reach the last index.

 * For example:
 * A = [2,3,1,1,4], return true.

 * A = [3,2,1,0,4], return false.
 */
public class JumpGame {

    public boolean canJump(int[] A) {
        int end = 0;
        for (int i = 0; end >= i && i < A.length; i++) {
            end = Math.max(end, i + A[i]);
            if (end >= A.length - 1)
                return true;
        }
        return false;
    }

}
