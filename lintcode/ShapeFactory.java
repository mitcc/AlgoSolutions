/*
 * Factory is a design pattern in common usage. Implement 
 * a ShapeFactory that can generate correct shape.

You can assume that we have only tree different shapes: 
Triangle, Square and Rectangle.

Example
ShapeFactory sf = new ShapeFactory();
Shape shape = sf.getShape("Square");
shape.draw();
>>  ----
>> |    |
>> |    |
>>  ----

shape = sf.getShape("Triangle");
shape.draw();
>>   /\
>>  /  \
>> /____\

shape = sf.getShape("Rectangle");
shape.draw();
>>  ----
>> |    |
>>  ----
 */
/**
 * Your object will be instantiated and called as such:
 * ShapeFactory sf = new ShapeFactory();
 * Shape shape = sf.getShape(shapeType);
 * shape.draw();
 */
interface Shape {

    void draw();

}

class Rectangle implements Shape {

    public void draw() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 6; ++j) {
                if ((i == 0 || i == 2) && 1 <= j && j <= 4) {
                    System.out.print("-");
                } else if (i == 1 && (j == 0 || j == 5)) {
                    System.out.print("|");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}

class Square implements Shape {

    public void draw() {
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 6; ++j) {
                if ((i == 0 || i == 3) && 1 <= j && j <= 4) {
                    System.out.print("-");
                } else if ((i == 1 || i == 2) && (j == 0 || j == 5)) {
                    System.out.print("|");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}

class Triangle implements Shape {

    public void draw() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 6; ++j) {
                if (i + j == 2) {
                    System.out.print("/");
                } else if (j - i == 3) {
                    System.out.print("\\");
                } else if (i == 2 && 1 <= j && j <= 5) {
                    System.out.print("_");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}

public class ShapeFactory {

    /**
     * @param shapeType a string
     * @return Get object of type Shape
     */
    public Shape getShape(String shapeType) {
        switch (shapeType) {
            case "Rectangle":
                return new Rectangle();
            case "Square":
                return new Square();
            case "Triangle":
                return new Triangle();
            default:
                return null;
        }
    }

}
