public class Insertsort {
    public void insertsort(int[] A, int low, int high) {
        for(int i = low + 1; i <= high; i++) {
            for(int j = i - 1; j >= 0 && A[j] > A[j + 1]; j--) {
                int temp = A[j];
                A[j] = A[j + 1];
                A[j + 1] = temp;
            }
        }
    }
}
