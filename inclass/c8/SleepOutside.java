package inclass.c8;

public class SleepOutside {
    public static void main(String[] args) throws
            InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(500);
        System.out.println("Sleep time in ms = "
                + (System.currentTimeMillis() - start));
    }
}