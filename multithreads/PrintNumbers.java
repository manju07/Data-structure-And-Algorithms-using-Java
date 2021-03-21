package multithreads;

/**
 * InnerTest
 */
class InnerTest {
    int data = 1;

    public synchronized void method1(int n) {
        for (int i = 0; i < 5; i++) {
            // synchronized(this) {
            try {
                System.out.println("Value:" + (data++) + " Thread :" + Thread.currentThread().getName());
                wait();
                notify();
            } catch (Exception e) {
                e.printStackTrace();
            }
            // }
        }
    }

    public synchronized void method2(int n) {
        for (int i = 0; i < 5; i++) {
            // synchronized(this) {
            try {
                System.out.println("Value:" + (data++) + " Thread :" + Thread.currentThread().getName());
                notify();
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
            // }
        }
    }
}

public class PrintNumbers {
    public static void main(String[] args) {
        try {
            InnerTest i1 = new InnerTest();
            Thread t1 = new Thread() {
                @Override
                public void run() {
                    i1.method1(1);
                }
            };
            Thread t2 = new Thread() {
                @Override
                public void run() {
                    i1.method2(10);
                }
            };
            t1.start();
            t2.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}