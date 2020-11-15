package homework_testing.sixth;

public class Move {
    public static void main(String[] args) {
        MovablePoint p = new MovablePoint(1, 2, 3, 4);
        MovableCircle c = new MovableCircle(11, 12, 13, 14,1);
        System.out.println(p.toString());
        System.out.println(c.toString());
        System.out.println("let's change position:");
        p.moveUp();
        p.moveLeft();
        c.moveDown();
        c.moveRight();
        System.out.println("Now they are: ");
        System.out.println(p.toString());
        System.out.println(c.toString());
    }
}

interface Movable {
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
}

class MovablePoint implements Movable {
    int x;
    int y;
    int xSpeed;
    int ySpeed;
    MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public String toString() {
        return "this is a point at x = " + this.x + " and y = " + this.y +
                "\nand Speed in x is " + this.xSpeed + " Speed in y is " + this.ySpeed;
    }

    public void moveUp() {
        this.y = this.y + this.ySpeed;
    }

    public void moveDown() {
        this.y = this.y + this.ySpeed;
    }

    public void moveLeft() {
        this.x = this.x - this.xSpeed;
    }

    public void moveRight() {
        this.x = this.x + this.xSpeed;
    }
}

class MovableCircle implements Movable {
    private int radius;
    private MovablePoint center;
    MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        center = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }
    public String toString() {
        return "this is a circle with radius of :" + this.radius +
                "\nit has the center in x = " + this.center.x + " and in y = " + this.center.y +
                "\nand speed in x is " + this.center.xSpeed + " and speed in y is " + this.center.ySpeed;
    }

    public void moveUp() {
        center.y = center.y + center.ySpeed;
    }

    public void moveDown() {
        center.y = center.y - center.ySpeed;
    }

    public void moveLeft() {
        center.x = center.x - center.xSpeed;
    }

    public void moveRight() {
        center.x = center.x + center.xSpeed;
    }
}