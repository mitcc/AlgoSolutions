public class BubbleSort {

    // 20150813
    public void bubbleSort(int[] array, int low, int high) {
        for (int i = low; i <= high; ++i) {
            boolean swapped = false;
            for (int j = high; j >= low + 1; --j) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    public void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
