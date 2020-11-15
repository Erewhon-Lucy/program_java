package inclass.c8;

public class TestJoin extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(i
                    + ": " + getName());
        }
    }
    public static void main(String[] args)
            throws InterruptedException {
        TestJoin t0 = new TestJoin();
        TestJoin t1 = new TestJoin();
        TestJoin t2 = new TestJoin();
        t0.start();
        t0.join();
        t1.start();
        t2.start();
    }
}
