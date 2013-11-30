/*
Implement next permutation, which rearranges numbers into the lexicographically 
next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible 
order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding 
outputs are in the right-hand column.

1,2,3 ¡ú 1,3,2
3,2,1 ¡ú 1,2,3
1,1,5 ¡ú 1,5,1
 * 
 */
public class NextPermutation {

    public void nextPermutation(int[] num) {
        for (int i = num.length - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                for (int j = num.length - 1; j > i; j--) {
                    if (num[j] > num[i]) {
                        swap(num, i, j);
                        reverse(num, i + 1, num.length - 1);
                        return ;
                    }
                }
            }
        }
        reverse(num, 0, num.length - 1);
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public void reverse(int[] array, int start, int end) {
        for (int i = start; i <= (start + end) / 2; i++)
            swap(array, i, start + end - i);
    }

}
