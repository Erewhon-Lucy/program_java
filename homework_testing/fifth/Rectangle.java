package homework_testing.fifth;

public class Rectangle extends Shape{
    protected double width;
    protected double length;
    Rectangle() {}
    Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }
    Rectangle(double width, double length, String color, boolean filled) {
        super(color,filled);
        this.width = width;
        this.length = length;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    public double getArea() {
        return width * length;
    }
    public double getPerimeter() {
        return 2 * (width + length);
    }
    public String toString() {
        return "This is a Rectangle has width of " + getWidth()
                + " and length of " + getLength() + " and color is " + getColor()
                 + " and filled " + isFilled() + " and area is " + getArea()
                 + " and Perimeter is " + getPerimeter();
    }

    public static void main(String[] args) {
        System.out.println("Test Rectangle***************");
        Rectangle r1 = new Rectangle();
        System.out.println(r1.toString());
        Rectangle r2 = new Rectangle(1.2,1.2);
        System.out.println(r2.toString());
        Rectangle r3 = new Rectangle(1.3,1.33, "orange", true);
        System.out.println(r3.toString());
        System.out.println("Change the third one's width");
        r3.setWidth(1.03);
        System.out.println("Now the width is " + r3.getWidth());
        System.out.println("Change its Length");
        r3.setLength(1.003);
        System.out.println("Now the length is " + r3.getLength());
        System.out.println("Change its color ");
        r3.setColor("brown");
        System.out.println("Now the color is " + r3.getColor());
        System.out.println("Change its filled ");
        r3.setFilled(false);
        System.out.println("Now the filled is " + r3.isFilled());
        System.out.println("Show the third one ");
        System.out.println(r3.toString());
    }
}
