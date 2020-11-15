package inclass.c8;

public class TestPriority extends Thread {
    public void run() {
        System.out.println("running thread:" + getName());
        System.out.println("priority is:" + getPriority());
    }
    public static void main(String[] args) {
        TestPriority m0 = new TestPriority();
        TestPriority m1 = new TestPriority();
        m0.setPriority(Thread.MIN_PRIORITY);
        m1.setPriority(Thread.MAX_PRIORITY);
        m0.start();
        m1.start();
    }
}
