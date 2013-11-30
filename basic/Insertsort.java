public class InsertSort {

    public void insertSort(int[] array, int low, int high) {
        for (int i = low + 1; i <= high; ++i) {
            for (int j = i; j > low && array[j] < array[j - 1]; --j) {
                swap(array, j, j - 1);
            }
        }
    }

    public void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
