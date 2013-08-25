public class JumpGame {
    public boolean canJump(int[] A) {
        int maxIndex = 0;
        for(int i = 0; i < A.length; i++) {
            if(maxIndex >= i) {
                maxIndex = Math.max(maxIndex, i + A[i]);
                if(maxIndex >= A.length - 1)
                    break;
            } else {
                return false;
            }
        }
        return true;
    }
}
