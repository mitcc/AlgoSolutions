/*
 * Given two sorted integer arrays nums1 and nums2, 
 * merge nums2 into nums1 as one sorted array.

 * Note:
 * You may assume that nums1 has enough space (size 
 * that is greater or equal to m + n) to hold 
 * additional elements from nums2. The number of 
 * elements initialized in nums1 and nums2 are m and 
 * n respectively.
 */

public class MergeSortedArray {

/**************************** updated 2013/12/16 *****************************/

    public void merge(int A[], int m, int B[], int n) {
        m--;
        n--;
        while(n >= 0) {
            if(m >= 0) 
                A[m + n + 1] = (A[m] > B[n]) ? A[m--] : B[n--];
            else
                A[n] = B[n--];
        }
    } 

/**************************** updated 2014.11.25 *****************************/

    public void merge(int nums1[], int m, int nums2[], int n) {
        int i = m - 1;
        int j = n - 1;
        for (int k = m + n - 1; k >= 0; k--) { 
            nums1[k] = (j < 0 || i >= 0 && nums1[i] > nums2[j]) ? 
                nums1[i--] : nums2[j--];
        }
    }

}
