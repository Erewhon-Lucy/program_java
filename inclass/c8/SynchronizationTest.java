package inclass.c8;

class Account {
    int money;
    synchronized void withdraw(int amount) {
        money -= amount;
    }
    synchronized void deposit(int amount) {
        money += amount;
    }
}
class Customer extends Thread {
    Account account;
    Customer(Account account) {
        this.account = account;
    }
    public void run() {
        for (int i = 0; i < 10000; i++) {
            account.deposit(100);
            account.withdraw(100);
        }
    }
}
public class SynchronizationTest {
    public static void main(String[] args)
            throws InterruptedException {
        Account account = new Account();
        Thread t0 = new Customer(account);
        Thread t1 = new Customer(account);
        t0.start();
        t1.start();
        t0.join();
        t1.join();
        System.out.println(account.money);
    }
}