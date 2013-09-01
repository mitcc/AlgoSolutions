/*
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color 
 * are adjacent, with the colors in the order red, white and blue.

 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 * Note:
 * You are not suppose to use the library's sort function for this problem.

 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number 
 * of 0's, then 1's and followed by 2's.

 * Could you come up with an one-pass algorithm using only constant space? 
 */
public class SortColors {
/*  public void sortColors(int[] A) {
        int redCount = 0, whiteCount = 0, blueCount = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] == 0)
                redCount++;
            if(A[i] == 1)
                whiteCount++;
            if(A[i] == 2)
                blueCount++;
        }
        for(int i = 0; i < A.length; i++) {
            if(i < redCount)
                A[i] = 0;
            else
                A[i] = i < redCount + whiteCount ? 1 : 2;
        }
    }*/

    public void sortColors(int[] A) {
        int red = 0, blue = A.length - 1;
        for(int i = 0; i <= blue; i++) {
            if(A[i] == 0) {
                int temp = A[i];
                A[i] = A[red];
                A[red++] = temp;
            } else if(A[i] == 2) {
                int temp = A[i];
                A[i--] = A[blue];
                A[blue--] = temp;
            }
        }
    }
}
