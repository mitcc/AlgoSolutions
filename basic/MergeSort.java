public class MergeSort {

    public void mergeSort(int[] array, int low, int high) {
        if (low >= high)
            return;
        int mid = low + (high - low) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        int[] firstHalf = Arrays.copyOfRange(array, low, mid + 1);
        int i = low; 
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (firstHalf[i - low] < array[j]) {
                array[k++] = firstHalf[i - low];
                i++;
            } else {
                array[k++] = array[j];
                j++;
            }
        }
        while (i <= mid) {
            array[k++] = firstHalf[i - low];
            i++;
        }
    }

}
