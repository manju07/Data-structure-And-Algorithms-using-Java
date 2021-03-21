package multithreads;

/**
 * Shared Object
 */
class Shared {
    private int amount = 10;

    public synchronized void withDraw(int withDrawMoney) {
        if (amount < withDrawMoney) {
            System.out.println("Balance is less, wait for deposit");
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        } 
        amount -= withDrawMoney;
        System.out.println("Amount withdrawn succeessfully, balance amount:" + amount);
    }

    public synchronized void deposit(int depositMoney) {
        amount += depositMoney;
        System.out.println("Amount deposited succeessfully, balance amount:" + amount);
        notify();
    }

}

/**
 * Interthread communication
 * @author Manjunath Asundi
 */
public class InterThreadCommunication {
    public static void main(String[] args) {
        Shared s1 = new Shared();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                s1.withDraw(100);
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                s1.deposit(200);
            }
        });
        t1.start();
        t2.start();
    }
}