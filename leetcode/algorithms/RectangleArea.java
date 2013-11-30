/*
 * Find the total area covered by two 
 * rectilinear rectangles in a 2D plane.

 * Each rectangle is defined by its 
 * bottom left corner and top right 
 * corner as shown in the figure.
 * 
 * https://leetcode.com/static/images
 * /problemset/rectangle_area.png
 *
 * Assume that the total area is never 
 * beyond the maximum possible value of 
 * int.
 */
public class RectangleArea {

    public int computeArea(int A, int B, int C, int D,
            int E, int F, int G, int H) {
        return (C - A) * (D - B) + (G - E) * (H - F) - 
            computeOverlapArea(A, B, C, D, E, F, G, H);
    }

    public int computeOverlapArea(int A, int B, int C, int D, 
            int E, int F, int G, int H) {
        int a = Math.max(A, E);
        int b = Math.min(C, G);
        int c = Math.max(B, F);
        int d = Math.min(D, H);
        return a >= b || c >= d ? 0 : (b - a) * (d - c);
    }

}
