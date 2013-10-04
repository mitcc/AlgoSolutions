public class Mergesort {
    public merge(A, low, mid, high) {
        int n1 = mid - low + 1, n2 = high - mid;
        int[] L = new int[n1], R = new int[n2];
        for(int i = 0; i < n1; i++) {
            L[i] = A[low + i - 1];
        }
        for(int i = 0; i < n2; i++) {
            R[i] = A[mid + j];
        }
    }
}
