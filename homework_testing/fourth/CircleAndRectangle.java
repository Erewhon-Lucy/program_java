package homework_testing.fourth;

class Circle {
    private double radius = 1.0;

    Circle(double x) {
        radius = x;
    }
    Circle() {
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double x) {
        radius = x;
    }
    public double getArea() {
        return Math.PI*radius*radius;
    }
    public double getCircumference() {
        return Math.PI*2*radius;
    }
    public String toString() {
        return "Circle[radius=" + radius +"]";
    }
}

class Rectangle {
    private float length = 1.0f;
    private float width = 1.0f;

    Rectangle(float x, float y) {
        length = x;
        width = y;
    }
    Rectangle() {
    }
    public float getLength() {
        return length;
    }
    public void setLength(float x) {
        length = x;
    }
    public float getWidth() {
        return width;
    }
    public void setWidth(float y) {
        width = y;
    }
    public double getArea() {
        return width*length;
    }
    public double getPerimeter() {
        return 2 * (width + length);
    }
    public String toString() {
        return "Rectangle[length=" + length + ",width=" + width + "]";
    }
}

public class CircleAndRectangle {
    public static void main(String args[]) {
        System.out.println("Testing constructor method:");
        Circle c1 = new Circle();
        Circle c2 = new Circle(2.0);
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(2.0f,2.0f);
        System.out.println(r1.toString());
        System.out.println(r2.toString());
        System.out.print("\n");
        System.out.println("******************************");
        System.out.println("Testing other methods for Circle");
        System.out.println("c1's radius is " + c1.getRadius());
        System.out.println("c1's Area is " + c1.getArea());
        System.out.println("c1's Circumference is " + c1.getCircumference());
        System.out.println("Change c1");
        c1.setRadius(3.0);
        System.out.println("Now c1's radius is " + c1.getRadius());
        System.out.print("\n");
        System.out.println("******************************");
        System.out.println("Testing other methods for Rectangle");
        System.out.println("r1's length is " + r1.getLength());
        System.out.println("r1's width is " + r1.getWidth());
        System.out.println("r1's Aera is " + r1.getArea());
        System.out.println("r1's Perimeter is " + r1.getPerimeter());
        System.out.println("Change r1");
        r1.setLength(3.0f);
        r1.setWidth(3.0f);
        System.out.println("Now r1's length is " + r1.getLength()
        + " and width is " + r1.getWidth());
    }
}
