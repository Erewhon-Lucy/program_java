package homework_testing.sixth;

public class Geometric {
    public static void main(String[] args) {
//        Circle cc = new ResizableCircle(2);
//        cc.resize; 继承的多态和接口的多态不能互通！
        ResizableCircle c = new ResizableCircle(3);
        System.out.println("Create a resizable circle");
        System.out.println("The radius is : " + c.radius);
        System.out.println("The Perimeter and Area is : " + c.getPerimeter() + " and " + c.getArea());
        System.out.println("Resize it to 50 percent");
        c.resize(50);
        System.out.println("Now the radius is " + c.radius);
        System.out.println("The Perimeter and Area is : " + c.getPerimeter() + " and " + c.getArea());
    }
}

interface GeometricObject {
    double getPerimeter();
    double getArea();
}

interface Resizable {
    void resize(int percent);
}

class Circle implements GeometricObject {
    protected double radius = 1.0;
    Circle(double radius) {
        this.radius = radius;
    }
    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }
}

class ResizableCircle extends Circle implements Resizable{
    ResizableCircle(double radius) {
        super(radius);
    }
    public void resize(int percent) {
        super.radius = super.radius * percent / 100 ;
    }
}
