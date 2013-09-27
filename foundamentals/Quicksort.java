public class Quicksort {
    public void quicksort(int[] array, int low, int high) {
        if(low >= high)
            return ;
        int i = low - 1;
        for(int j = low; j < high; j++) {
            if(array[j] <= array[high]) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        quicksort(array, low, i);
        quicksort(array, i + 1, high);
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
