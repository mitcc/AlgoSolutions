public class Finder {

    public int findElement(int[] A, int n, int x) {
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = low + (high - low >> 1);
            if (A[mid] == x) {
                return mid;
            }
            if (A[mid] <= A[high]) {
                if (A[mid] < x && x <= A[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (A[low] <= x && x < A[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

}
