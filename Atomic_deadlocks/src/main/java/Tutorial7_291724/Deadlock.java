//package Tutorial7_291724;
//
//import java.util.Random;
//
//public class Deadlock implements Runnable {
//    private static final Object resource1 = new Object();
//    private static final Object resource2 = new Object();
//    private final Random random = new Random(System.currentTimeMillis());
//
//    public static void main(String[] args) {
//        Thread myThread1 = new Thread(new Deadlock(), "thread-1");
//        Thread myThread2 = new Thread(new Deadlock(), "thread-2");
//        myThread1.start();
//        myThread2.start();
//    }
//
//    public void run() {
//        for (int i = 0; i < 10000; i++) {
//            boolean b = random.nextBoolean();
//            if (b) {
//                System.out.println("[" + Thread.currentThread().getName() + "] Trying to lock resource 1.");
//                synchronized (resource1) {
//                    System.out.println("[" + Thread.currentThread().getName() + "] Locked resource 1.");
//                    System.out.println("[" + Thread.currentThread().getName() + "] Trying to lock resource 2.");
//                    synchronized (resource2) {
//                        System.out.println("[" + Thread.currentThread().getName() + "] Locked resource 2.");
//                    }
//                }
//            } else {
//                System.out.println("[" + Thread.currentThread().getName() + "] Trying to lock resource 2.");
//                synchronized (resource2) {
//                    System.out.println("[" + Thread.currentThread().getName() + "] Locked resource 2.");
//                    System.out.println("[" + Thread.currentThread().getName() + "] Trying to lock resource 1.");
//                    synchronized (resource1) {
//                        System.out.println("[" + Thread.currentThread().getName() + "] Locked resource 1.");
//                    }
//                }
//            }
//        }
//    }
//}

package Tutorial7_291724;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock implements Runnable {
    // ReentrantLock used to gives more control than synchronized
    private static final ReentrantLock resource1 = new ReentrantLock();
    private static final ReentrantLock resource2 = new ReentrantLock();
    private final Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        Thread myThread1 = new Thread(new Deadlock(), "thread-1");
        Thread myThread2 = new Thread(new Deadlock(), "thread-2");
        myThread1.start();
        myThread2.start();
    }

    @Override
    public void run() {
        // Each thread akan try to lock resources 5x
        for (int i = 0; i < 5; i++) {
            if (random.nextBoolean()) {
                tryLockInOrder(resource1, resource2, "resource 1", "resource 2");
            } else {
                tryLockInOrder(resource2, resource1, "resource 2", "resource 1");
            }
        }
    }

    private void tryLockInOrder(ReentrantLock first, ReentrantLock second, String firstResource, String secondResource) {
        System.out.println("[" + Thread.currentThread().getName() + "] Trying to lock " + firstResource + ".");
        if (first.tryLock()) {
            System.out.println("[" + Thread.currentThread().getName() + "] Locked " + firstResource + ".");
            try {
                Thread.sleep(1); // Delay to increase chance of deadlock
                System.out.println("[" + Thread.currentThread().getName() + "] Trying to lock " + secondResource + ".");
                if (second.tryLock()) {
                    try {
                        System.out.println("[" + Thread.currentThread().getName() + "] Locked " + secondResource + ".");
                    } finally {
                        second.unlock(); // Release 2nd resource
                    }
                } else {
                    System.out.println("[" + Thread.currentThread().getName() + "] Couldn't lock " + secondResource + ", retrying.");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                first.unlock(); // Always release 1st resource
            }
        } else {
            // Fail lock, then will try again
            System.out.println("[" + Thread.currentThread().getName() + "] Couldn't lock " + firstResource + ", retrying.");
        }
    }
}

