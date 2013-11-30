public class AntiOrder {

    public int count(int[] A, int n) {
        int count = 0;
        for (int i = 0; i < A.length; ++i) {
            for (int j = i + 1; j < A.length; ++j) {
                if (A[i] > A[j]) {
                    count++;
                }
            }
        }
        return count;
    }

}
