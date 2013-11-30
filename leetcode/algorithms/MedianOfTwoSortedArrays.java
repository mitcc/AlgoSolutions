/*
 * There are two sorted arrays A and B of size m and n 
 * respectively. Find the median of the two sorted 
 * arrays. The overall run time complexity should be 
 * O(log (m+n)).
 */
public class MedianOfTwoSortedArrays {

    public double findMediaSortedArrays(int A[], int B[]) {
        int[] C = new int[A.length + B.length];
        int a = 0;
        int b = 0;
        int c = 0;
        while (a < A.length || b < B.length) {
            if (a < A.length && b < B.length)
                C[c++] = A[a] < B[b] ? A[a++] : B[b++];
            else if (a < A.length) 
                C[c++] = A[a++];
            else 
                C[c++] = B[b++];
        }
        double result = C[C.length / 2];
        if (C.length % 2 == 0) 
            result = (result + C[C.length / 2 - 1]) / 2;
        return result;
    }

/*****************************************************************************/

    public double findMedianSortedArrays(int A[], int B[]) {
        int aLen = A.length;
        int bLen = B.length;
        if ((aLen + bLen) % 2 == 1)
            return findKth(A, 0, aLen - 1, B, 0, bLen - 1, (aLen + bLen) / 2);
        else
            return (findKth(A, 0, aLen - 1, B, 0, bLen - 1, 
                        (aLen + bLen) / 2) + findKth(A, 0, aLen - 1, 
                            B, 0, bLen - 1, (aLen + bLen) / 2 - 1)) / 2;
    }

    public double findKth(int[] A, int aStart, int aEnd, 
            int[] B, int bStart, int bEnd, int k) {
        int aLen = aEnd - aStart + 1;
        int bLen = bEnd - bStart + 1;
        if (aLen == 0)
            return B[bStart + k];
        if (bLen == 0)
            return A[aStart + k];
        if (k == 0)
            return Math.min(A[aStart], B[bStart]);
        int aMid = aStart + aLen * k / (aLen + bLen);
        int bMid = bStart + k - aLen * k / (aLen + bLen) - 1;
        if (A[aMid] > B[bMid]) {
            k -= (bMid - bStart + 1);
            aEnd = aMid;
            bStart = bMid + 1;
        } else {
            k -= (aMid - aStart + 1);
            bEnd = bMid;
            aStart = aMid + 1;
        }
        return findKth(A, aStart, aEnd, B, bStart, bEnd, k);
    }

}
