package multithreads;

/**
 * SharedObject1
 */
class SharedObject1 {

    public synchronized void method1(SharedObject1 so1, SharedObject2 so2) {
        System.out.println("method1 executing, current thread:" + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        so2.method2(so1, so2);
    }
}

/**
 * SharedObject2
 */
class SharedObject2 {

    public synchronized void method2(SharedObject1 so1, SharedObject2 so2) {
        System.out.println("method2 executing, current thread:" + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        so1.method1(so1, so2);
    }
}

/**
 * Deadlock
 * 
 * @author Manjunath Asundi
 */

public class Deadlock {

    public static void main(String[] args) {

        SharedObject1 so1 = new SharedObject1();
        SharedObject2 so2 = new SharedObject2();
        Thread t1 = new Thread(() -> so1.method1(so1, so2));

        Thread t2 = new Thread(() -> so2.method2(so1, so2));

        t1.start();
        try {
            // t1.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        t2.start();
    }
}