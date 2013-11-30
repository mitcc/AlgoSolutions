public SelectionSort {

    public void selectionSort(int[] array, int low, int high) {
        for (int i = low; i <= high; ++i) {
            int minIndex = i;
            for (int j = i + 1; j <= high; ++j) {
                if (array[j] < array[minIndex])
                    minIndex = j;
            }
            swap(array, i, minIndex);
        }
    }

    public void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
