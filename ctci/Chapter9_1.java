/*
 * You are given two sorted arrays, A and B, and A has a large enough buffer at 
 * the end to hold B. Write a method to merge B into A in sorted order.
 */
public class Chapter9_1 {

    public int[] merge(int[] A, int[] B) {
        int i = A.length - 1;
        int j = B.length - 1;
        while (j >= 0) {
            A[i + j + 1] = (i >= 0 && A[i] > B[j]) ? A[i--] : B[j--];
        }
        return A;
    }

}
