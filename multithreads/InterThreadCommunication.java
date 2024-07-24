package multithreads;

/**
 * Shared Object
 */
class Shared {
    private int amount = 10;
    private int iteration = 10, iteration2 = 10;

    public synchronized void withDraw(int withDrawMoney) {
        while (iteration != 0) {
            while (amount < withDrawMoney) {
                System.out.println("Balance is less, wait for deposit");
                try {
                    notify();
                    wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            amount -= withDrawMoney;
            System.out.println("Amount withdrawn " + withDrawMoney + " succeessfully, balance amount:" + amount);
            notify();
            iteration--;
            withDrawMoney += 30;
        }
    }

    public synchronized void deposit(int depositMoney) {
        while (iteration2 != 0 && iteration != 0) {
            amount += depositMoney;
            System.out.println("Amount deposited " + depositMoney + " succeessfully, balance amount:" + amount);
            notify();
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
            iteration2--;
        }
    }

}

/**
 * Interthread communication
 * 
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
                s1.deposit(50);
            }
        });
        t1.start();
        t2.start();
    }
}