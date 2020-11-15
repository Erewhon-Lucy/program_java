package inclass.c5;

class MySuper {
    public static void print() {
    System.out.println("Inside MySuper.print()");
    }
}
class MySubclass extends MySuper {
    public static void print() {
        System.out.println("Inside MySubclass.print()");
    }
    public static void main(String[] args) {
    MySuper mhSuper = new MySubclass();
    MySubclass mhSub = new MySubclass();
    MySuper.print();
    MySubclass.print();
    ((MySuper) mhSub).print();
    mhSuper = mhSub;
    mhSuper.print();
    ((MySubclass) mhSuper).print();
    }
}