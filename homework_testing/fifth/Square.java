package homework_testing.fifth;

public class Square extends Rectangle {
    Square() {}
    Square(double side) {
        super(side, side);
    }
    Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }
    public double getSide() {
        return width;
    }
    public void setSide(double side) {
        this.width = this.length = side;
    }
    public void setWidth(double side) {
        this.width = side;
    }
    public void setLength(double side) {
        this.length = side;
    }
    public String toString() {
        return "This is a Square has side of " + getSide() + " and color is " + getColor()
                 + " and filled is " + isFilled() + " and area is " + getArea() +
                " and perimeter is " + getPerimeter();
    }

    public static void main(String[] args) {
        System.out.println("Test Square******************");
        Square s1 = new Square();
        System.out.println(s1.toString());
        Square s2 = new Square(1.2);
        System.out.println(s2.toString());
        Square s3 = new Square(3.0, "pink", true);
        System.out.println(s3.toString());
        System.out.println("Change the third one's side");
        s3.setSide(1.03);
        System.out.println("Now the side is " + s3.getSide());
        System.out.println("Change its color ");
        s3.setColor("brown");
        System.out.println("Now the color is " + s3.getColor());
        System.out.println("Change its filled ");
        s3.setFilled(false);
        System.out.println("Now the filled is " + s3.isFilled());
        System.out.println("Now show the third one ");
        System.out.println(s3.toString());
    }
}
