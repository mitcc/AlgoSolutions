/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

* (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

* Find the minimum element.

* You may assume no duplicate exists in the array.
*/

public class FindMinimumInRotatedSortedArray {
    
    public int findMin(int[] num) {
        int start = 0;
        int end = num.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (num[mid] < num[end]) 
                end = mid;
            else
                start = mid + 1;
        }
        return num[start];
    } 

}

