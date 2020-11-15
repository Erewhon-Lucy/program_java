package inclass.c8;

public class TestSleep extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
//                System.out.println(e);
            }
            System.out.println(i +": "+System.currentTimeMillis());
        }
    }
    public static void main(String[] args) {
        new TestSleep().start();
    }
}
