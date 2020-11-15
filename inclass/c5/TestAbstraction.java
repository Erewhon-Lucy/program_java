package inclass.c5;

abstract class Bike {
    Bike() {
        System.out.println(
                "bike is created");
    }
    abstract void run();
    void changeGear() {
        System.out.println(
                "gear changed");
    }
}
class Honda extends Bike {
    void run() {
        System.out.println(
                "running safely..");
    }
}
public class TestAbstraction {
    public static void main(String args[]) {
        Bike obj = new Honda();
        obj.run();
        obj.changeGear();
        Honda obj2 = new Honda();
        obj2.run();
    }
}