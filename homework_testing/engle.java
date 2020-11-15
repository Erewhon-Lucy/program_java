package homework_testing;

public class engle {
    public static void main(String args[]){
        Circle s1 = new Circle(4,"red",true);
        System.out.println(s1.toString());
        System.out.println(s1.getArea());
        System.out.println(s1.getPerimeter());
        s1.setColor("blue");
        s1.setFilled(false);
        s1.setRadius(5);
        System.out.println(s1.toString());
        System.out.println("---------------------------------");
        Rectangle r1 = new Rectangle(4,5,"red",true);
        System.out.println(r1.toString());
        System.out.println(r1.getArea());
        System.out.println(r1.getPerimeter());
        r1.setLength(6);
        r1.setWidth(8);
        System.out.println(r1.toString());
        System.out.println("----------------------------------");
        Square s2 = new Square(6,"blue",false);
        System.out.println(s2.toString());
        System.out.println(s2.getArea());
        System.out.println(s2.getPerimeter());
        s2.setSide(7);
        System.out.println(s2.toString());
    }
}
abstract class Shape{
    String color;
    boolean filled;
    Shape(){}
    Shape(String color,boolean filled){
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    abstract double getArea();
    abstract double getPerimeter();
    public abstract String toString();
}
class Circle extends Shape{
    double radius;
    Circle(){}
    Circle(double radius){
        this.radius = radius;
    }
    Circle(double radius,String color,boolean filled){
        this.radius = radius;
        this.color = color;
        this.filled = filled;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    double getArea() {
        return radius * Math.PI * radius;
    }

    double getPerimeter() {
        return radius*2*Math.PI;
    }
    public String toString(){
        return "Circle :radius = " + radius + ",color = " +
                color + ",filled = " + filled;
    }
}
class Rectangle extends Shape{
    double width,length;
    Rectangle(){}
    Rectangle(double width,double length){
        this.width = width;
        this.length = length;
    }
    Rectangle(double width,double length,String color,boolean filled){
        this.width = width;
        this.length = length;
        this.color = color;
        this.filled = filled;
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

    double getArea() {
        return width*length;
    }

    double getPerimeter() {
        return width*2+length*2;
    }
    public String toString(){
        return "Rectangle:width = " + width + ",length = " + length +
                ",color = " + color + ",boolean = " + filled;
    }
}
class Square extends Rectangle{
    Square(){}
    Square(double side){
        this.width = side;
        this.length = side;
    }
    Square(double side,String color,boolean filled){
        this.width = side;
        this.length = side;
        this.color = color;
        this.filled = filled;
    }

    public double getSide() {
        return width;
    }
    public void setSide(double side){
        this.width = side;
    }
    public String toString(){
        return "Square:side = " + width + ",String = " + color +
                ",filled = " + filled;
    }
}