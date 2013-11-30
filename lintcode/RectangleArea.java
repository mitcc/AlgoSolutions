/*
Implement a Rectangle class which include the following attributes and methods:

Two public attributes width and height.
A constructor which expects two parameters width and height of type int.
A method getArea which would calculate the size of the rectangle and return.
Have you met this question in a real interview? Yes
Example
Rectangle rec = new Rectangle(3, 4);
rec.getArea(); // should get 12
 */
public class RectangleArea {

}

class Rectangle {

    /*
     * Define two public attributes width and height of type int.
     */
    // write your code here
    private int width;
    private int height;

    /*
     * Define a constructor which expects two parameters width and height here.
     */
    // write your code here
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    /*
     * Define a public method `getArea` which can calculate the area of the
     * rectangle and return.
     */
    // write your code here
    public int getArea() {
        return width * height;
    }
}
