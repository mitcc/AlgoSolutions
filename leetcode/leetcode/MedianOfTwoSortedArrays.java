/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity
should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] tmp = new int[nums1.length + nums2.length];
        for (int i = 0; i < tmp.length; ++i) {
            if (i < nums1.length) {
                tmp[i] = nums1[i];
            } else {
                tmp[i] = nums2[i - nums1.length];
            }
        }
        Arrays.sort(tmp);
        if (tmp.length % 2 == 1) {
            return (double) tmp[tmp.length / 2];
        }
        return (double) (tmp[tmp.length / 2 - 1] + tmp[tmp.length / 2]);
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    }

    public int findKthOfSortedArrays(int[] nums1, int low1, int high1, int[] nums2, int low2, int high2, int k) {
        int len1 = high1 - low1 + 1;
        int len2 = high2 - low2 + 1;
        int len = len1 + len2;
        int k1 = len1 * k / len;
        int k2 = len2 * k / len;

    }

}
