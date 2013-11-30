/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one
sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to 
m + n) to hold additional elements from nums2. The number of elements 
initialized in nums1 and nums2 are m and n respectively.

 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m + n - 1; i >= 0; --i) {
            if (m > 0 && (n > 0 && nums1[m - 1] > nums2[n - 1] || n <= 0)) {
                nums1[i] = nums1[m - 1];
                m--;
            } else {
                nums1[i] = nums2[n - 1];
                n--;
            }
        }
    }

}
