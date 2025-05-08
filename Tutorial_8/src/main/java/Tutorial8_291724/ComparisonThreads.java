package Tutorial8_291724;

class SharedCounter {   // class for share count
    int count = 0;

    public void normalIncrement() { // without synchronized - race condition
        count++;
    }

    public synchronized void synchronizedIncrement() {  // with synchronized
        count++;
    }

    public int getCount() {
        return count;
    }
}

// Normal Thread
class NormalThread extends Thread {
    SharedCounter counter;

    public NormalThread(SharedCounter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) { // increment process 1000x
            counter.normalIncrement();
        }
    }
}

// Synchronized Thread
class SynchronizedThread extends Thread {
    SharedCounter counter;

    public SynchronizedThread(SharedCounter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.synchronizedIncrement();
        }
    }
}

public class ComparisonThreads {
    public static void main(String[] args) throws InterruptedException {
        // test normal thread
        SharedCounter normalCounter = new SharedCounter();
        Thread[] normalThreads = new Thread[10];    // test 10 threads

        long startNormal = System.nanoTime();   // start time
        for (int i = 0; i < 10; i++) {
            normalThreads[i] = new NormalThread(normalCounter);
            normalThreads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            normalThreads[i].join();
        }
        long endNormal = System.nanoTime(); // end time
        double timeNormal = (endNormal - startNormal) / 1_000_000_000.0;

        // test synchronized thread
        SharedCounter synchronizedCounter = new SharedCounter();
        Thread[] syncThreads = new Thread[10];

        long startSync = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            syncThreads[i] = new SynchronizedThread(synchronizedCounter);
            syncThreads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            syncThreads[i].join();
        }
        long endSync = System.nanoTime();
        double timeSync = (endSync - startSync) / 1_000_000_000.0;  // nanosecond ke saat

        // output in second
        System.out.printf("Normal thread = %.8f seconds\n", timeNormal);
        System.out.printf("Synchronized thread = %.8f seconds\n", timeSync);
    }
}

