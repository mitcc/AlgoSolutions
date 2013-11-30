public class QuickSort {

    public void quickSort(int[] array, int low, int high) {
        if (low >= high)
            return;
        int i = low;
        for (int j = low; j < high; ++j) {
            if (array[j] <= array[high]) {
                swap(array, i++, j);
            }
        }
        swap(array, i, high);
        quickSort(array, low, i - 1);
        quickSort(array, i + 1, high);
    }

    public void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
