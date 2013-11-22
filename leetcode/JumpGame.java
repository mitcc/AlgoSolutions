/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 * Each element in the array represents your maximum jump length at that position.

 * Determine if you are able to reach the last index.

 * For example:
 * A = [2,3,1,1,4], return true.

 * A = [3,2,1,0,4], return false.
 */
public class JumpGame {
    public boolean canJump(int[] A) {
        int maxIndex = 0;
        for(int i = 0; i < A.length - 1; i++) {
            maxIndex = Math.max(A[i] + i, maxIndex);
            if(maxIndex == i)
                return false;
            else if(maxIndex >= A.length - 1)
                return true;
        }
        return maxIndex >= A.length - 1;
    }
}
