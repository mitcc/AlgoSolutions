/*
 * Given an integer array, heapify it into a min-heap array.

For a heap array A, A[0] is the root of heap, and for each A[i], 
A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right 
child of A[i].
Example
Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.

Challenge
O(n) time complexity

Clarification
What is heap?

Heap is a data structure, which usually have three methods: push, pop 
and top. where "push" add a new element the heap, "pop" delete the 
minimum/maximum element in the heap, "top" return the minimum/maximum 
element.

What is heapify?
Convert an unordered integer array into a heap array. If it is 
min-heap, for each element A[i], we will get A[i * 2 + 1] >= A[i] and 
A[i * 2 + 2] >= A[i].

What if there is a lot of solutions?
Return any of them.
 */
public class Heapify {

    // reference https://www.cs.princeton.edu/~wayne/kleinberg-tardos/pdf/DemoHeapify.pdf

    public void heapify(int[] A) {
        for (int i = A.length / 2; i >= 0; --i) {
            minHeapify(A, i);
        }
    }

    public void minHeapify(int[] A, int i) {
        int minIndex = i;
        while (minIndex < A.length) {
            if (2 * i + 1 < A.length && A[2 * i + 1] < A[minIndex]) {
                minIndex = 2 * i + 1;
            }
            if (2 * i + 2 < A.length && A[2 * i + 2] < A[minIndex]) {
                minIndex = 2 * i + 2;
            }
            if (minIndex == i) {
                break;
            }
            int tmp = A[i];
            A[i] = A[minIndex];
            A[minIndex] = tmp;
            i = minIndex;
        }
    }

}
